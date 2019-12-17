package com.duanxin.zqls.web.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Http工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/12/13 9:40
 */
public class HttpUtil {

    /**
     * 从httpRequest中url的参数header/cookie中取值
     * @param key 关键字
     * @date 2019/12/13 9:41
     * @return java.lang.String
     **/
    public static String getData(String key) {
        HttpServletRequest request = getRequest();
        String value = request.getHeader(key);
        if (null == value) {
            value = request.getParameter(key);
        }
        if (null == value) {
            value = CookieUtil.getCookie(request, key);
        }
        return value;
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
    }
}
