package com.duanxin.zqls.web.interceptors;

import com.duanxin.zqls.common.util.GsonUtil;
import com.duanxin.zqls.web.annotation.LoginRequired;
import com.duanxin.zqls.web.base.BaseResult;
import com.duanxin.zqls.web.code.ResultCode;
import com.duanxin.zqls.web.util.HttpClientUtil;
import com.duanxin.zqls.web.util.HttpUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登入验证拦截器
 * @author duanxin
 * @version 1.0
 * @date 2019/12/12 9:00
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

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
        String token = HttpUtil.getData("token");
        if (StringUtils.isNotBlank(token)) {
            // 请求有token，进行验证
            String doGet = HttpClientUtil.doGet("http://localhost:8072/passport/checkToken?token=" + token);
            BaseResult result = GsonUtil.jsonToBean(doGet, BaseResult.class);
            if (ResultCode.SUCCESS.getCode() == result.getCode()) {
                // 校验通过
                // 进行token过期性校验
                Map<String, Object> param = Maps.newHashMap();
                param.put("token", token);
                String doPut = HttpClientUtil.doPut("http://localhost:8072/passport/refreshJwt", param);
                BaseResult result1 = GsonUtil.jsonToBean(doPut, BaseResult.class);
                if (ResultCode.SUCCESS.getCode() == result1.getCode()) {
                    // 更新客户端token
                    Cookie cookie = new Cookie("token", result1.getData().toString());
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    response.addCookie(cookie);
                }
                return true;
            } else {
                // 校验失败，进行重新登入
                return false;
            }
        }

        // 第一次登入
        String jobNumber = request.getParameter("jobNumber");
        String password = request.getParameter("password");
        if (StringUtils.isNotBlank(jobNumber) && StringUtils.isNotBlank(password)) {
            // 用户没有自动登入
            Map<String, Object> map = new HashMap<>();
            map.put("jobNumber", jobNumber);
            map.put("password", password);
            // 进行登入请求
            String doPost = HttpClientUtil.doPost("http://localhost:8072/passport/login", map);
            BaseResult result2 = GsonUtil.jsonToBean(doPost, BaseResult.class);
            if (ResultCode.SUCCESS.getCode() == result2.getCode()) {
                // 登入成功，将token存入cookie
                Cookie cookie = new Cookie("token", result2.getData().toString());
                cookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(cookie);
                return true;
            }
        }
        // 用户没有自动登入，之前也没有登入过，或者cookie失效
        return false;
    }
}
