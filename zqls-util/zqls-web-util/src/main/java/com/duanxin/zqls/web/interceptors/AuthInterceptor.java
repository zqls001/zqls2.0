package com.duanxin.zqls.web.interceptors;
import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.web.annotation.LoginRequired;
import com.duanxin.zqls.web.base.BaseResult;
import com.duanxin.zqls.web.code.ResultCode;
import com.duanxin.zqls.web.util.CookieUtil;
import com.duanxin.zqls.web.util.HttpClientUtil;
import com.duanxin.zqls.web.util.HttpUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 登入验证拦截器
 * @author duanxin
 * @version 1.0
 * @date 2019/12/12 9:00
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private final static Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断请求方法是否带有需要被拦截的注解标识
        HandlerMethod handlerMethod = null;
        if (handler instanceof HandlerMethod) {
            handlerMethod = (HandlerMethod) handler;
        }
        LoginRequired methodAnnotation = null;
        if (handlerMethod != null) {
            methodAnnotation = handlerMethod.getMethodAnnotation(LoginRequired.class);
        }
        // 是否拦截
        if (null == methodAnnotation) {
            return true;
        }

        // 其他请求的登入过滤
        String tmpTicket = HttpUtil.getData("tmpTicket");
        if (StringUtils.isNotBlank(tmpTicket)) {
            // 对临时票据进行校验
            Map<String, Object> param = Maps.newHashMap();
            param.put("tmpTicket", tmpTicket);
            String doPost = HttpClientUtil.doPost("http://localhost:8072/passport/verifyTmpTicket", param);
            BaseResult result = GsonUtil.jsonToBean(doPost, BaseResult.class);
            if (ResultCode.SUCCESS.getCode() == result.getCode()) { // 校验成功
                // 更新临时票据
                String doGet = HttpClientUtil.doGet("http://localhost:8072/passport/refreshTmpTicket");
                BaseResult r = GsonUtil.jsonToBean(doGet, BaseResult.class);
                CookieUtil.setCookie(response, "tmpTicket", tmpTicket, 3600);
                return true;
            } else { // 校验失败
                returnMsg(response, BaseResult.unauthorized("校验信息无效，请重新登入"));
                return false;
            }
        }

        // 第一次登入
        String jobNumber = HttpUtil.getData("jobNumber");
        String password = HttpUtil.getData("password");
        if (StringUtils.isNotBlank(jobNumber) && StringUtils.isNotBlank(password)) {
            // 用户没有自动登入
            Map<String, Object> map = Maps.newHashMap();
            map.put("jobNumber", jobNumber);
            map.put("password", password);
            // 进行登入请求
            String doPost = HttpClientUtil.doPost("http://localhost:8072/passport/login", map);
            BaseResult result2 = GsonUtil.jsonToBean(doPost, BaseResult.class);
            if (ResultCode.SUCCESS.getCode() == result2.getCode()) {
                // 登入成功，将token存入cookie
                CookieUtil.setCookie(response, "tmpTicket", tmpTicket, 3600);
                return true;
            }
        }
        // 用户没有自动登入，之前也没有登入过，或者cookie失效
        returnMsg(response, BaseResult.unauthorized("校验信息无效，请重新登入"));
        return false;
    }

    private void returnMsg(HttpServletResponse response, BaseResult result) {
        OutputStream out = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            out.write(GsonUtil.objectToString(result).getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (IOException e) {
            log.error("");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
