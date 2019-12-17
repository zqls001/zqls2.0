package com.duanxin.zqls.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/12/13 10:00
 */
public class CookieUtil {

    /**
     * 设置Cookie
     * @param response 响应
     * @param key 名
     * @param value 值
     * @param path 路径
     * @param maxAge 过期值
     * @date 2019/12/13 10:02
     **/
    public static void setCookie(HttpServletResponse response, String key, String value, String path, int maxAge) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath(path);
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    public static void setCookie(HttpServletResponse response, String key, String name, int maxAge) {
        setCookie(response, key, name, "/", maxAge);
    }

    public static void setCookie(HttpServletResponse response, String key, String name) {
        setCookie(response, key, name, "/", 3600);
    }

    public static void setCookie(HttpServletResponse response, String key) {
        setCookie(response, key, "", "/", 3600);
    }

    /**
     * 获取cookie值
     * @param request 请求
     * @param key 名
     * @date 2019/12/13 10:10
     * @return java.lang.String
     **/
    public static String getCookie(HttpServletRequest request, String key) {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (null == cookies || 0 == cookies.length) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().toLowerCase().equals(key.toLowerCase())) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }

    /**
     * 删除cookie
     * @param response 响应
     * @param key 名
     * @date 2019/12/13 10:12
     **/
    public static void removeCookie(HttpServletResponse response, String key) {
        setCookie(response, key, "", "/", 0);
    }
}
