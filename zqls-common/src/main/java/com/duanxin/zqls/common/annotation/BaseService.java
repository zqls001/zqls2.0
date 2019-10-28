package com.duanxin.zqls.common.annotation;
import java.lang.annotation.*;

/**
 * 初始化继承BaseService的service
 * @author duanxin
 * @version 1.0
 * @date 2019/9/16 16:02
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}
