package com.duanxin.zqls.web.annotation;
import java.lang.annotation.ElementType;
import	java.lang.annotation.RetentionPolicy;
import	java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 标识方法请求需要经过拦截器
 * @author duanxin
 * @version 1.0
 * @date 2019/12/12 8:58
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginRequired {
}
