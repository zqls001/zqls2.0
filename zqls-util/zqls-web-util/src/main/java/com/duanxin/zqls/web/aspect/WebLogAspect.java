package com.duanxin.zqls.web.aspect;

import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.web.bo.WebLog;
import com.duanxin.zqls.web.util.HttpUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import net.logstash.logback.marker.Markers;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;

/**
 * Controller层同一日志处理切面
 * @author duanxin
 * @version 1.0
 * @date 2019/12/24 11:20
 */
@Component
@Aspect
@Order(1)//多个切面的执行优先级，数值越小执行优先级越高
public class WebLogAspect {

    private final static Logger log = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.duanxin.zqls.*.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturn(Object ret) throws Throwable {

    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        // 获取当前请求对象
        HttpServletRequest request = HttpUtil.getRequest();
        // 记录请求信息
        WebLog webLog = new WebLog();
        Object result = pjp.proceed();
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(ApiOperation.class)) {
            ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
            webLog.setDescription(apiOperation.value());
        }
        long endTime = System.currentTimeMillis();
        webLog.setStartTime(startTime);
        webLog.setResult(result);
        webLog.setBasePath(request.getScheme() + "//:" + request.getServerName() +
                ":" + request.getServerPort() + "/" + request.getContextPath());
        webLog.setIp(request.getRemoteUser());
        webLog.setSpendTime(endTime - startTime);
        webLog.setUri(request.getRequestURI());
        webLog.setUrl(request.getRequestURL().toString());
        webLog.setParameter(getParameters(method, pjp.getArgs()));
        webLog.setMethod(request.getMethod());
        Map<String, Object> logMap = Maps.newHashMap();
        logMap.put("url", webLog.getUrl());
        logMap.put("method", webLog.getMethod());
        logMap.put("parameter", webLog.getParameter());
        logMap.put("spendTime", webLog.getSpendTime());
        logMap.put("description", webLog.getDescription());
        log.info(Markers.appendEntries(logMap), GsonUtil.objectToString(webLog));
        return result;
    }

    /**
     * 根据传入参数获取请求参数
     * @param method 方法
     * @param args 传入参数
     * @date 2019/12/26 8:50
     * @return java.lang.Object
     **/
    private Object getParameters(Method method, Object[] args) {
        List<Object> asList = Lists.newArrayList();
        Parameter[] parameters = method.getParameters();
        for (int i = 0, len = parameters.length; i < len; ++i) {
            // 将RequestBody注解的参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (null != requestBody) {
                asList.add(args[i]);
            }
            // 将RequestParam注解的参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (null != requestParam) {
                Map<String, Object> map = Maps.newHashMap();
                String key = parameters[i].getName();
                if (StringUtils.isNotEmpty(requestParam.value())) {
                    key = requestParam.value();
                }
                map.put(key, args[i]);
                asList.add(map);
            }
            // 将PathVariable注解的参数
            PathVariable pathVariable = parameters[i].getAnnotation(PathVariable.class);
            if (null != pathVariable) {
                Map<String, Object> map = Maps.newHashMap();
                map.put(parameters[i].getName(), args[i]);
                asList.add(map);
            }
        }
        if (asList.size() == 0) {
            return null;
        }
        if (asList.size() == 1) {
            return asList.get(0);
        }
        return asList;
    }
}
