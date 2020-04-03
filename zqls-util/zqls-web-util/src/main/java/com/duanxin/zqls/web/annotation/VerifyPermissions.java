package com.duanxin.zqls.web.annotation;
import java.lang.annotation.ElementType;
import	java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 验证权限标识注解
 * @author duanxin
 * @version 1.0
 * @date 2020/3/6 15:27
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface VerifyPermissions {
}
