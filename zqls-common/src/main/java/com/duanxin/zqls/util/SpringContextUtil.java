package com.duanxin.zqls.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 资源文件读取工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/9/15 14:53
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 根据bean名获取bean
     * @param name bean名称
     * @date 2019/9/15 14:59
     * @return java.lang.Object
     **/
    public static Object getBean(String name) {
        return context.getBean(name);
    }

    /**
     * 根据名称获取指定类型bean
     * @param name bean名
     * @param clazz 返回bean类型，若类型不合抛出异常
     * @date 2019/9/15 15:00
     * @return T
     **/
    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }

    /**
     * 根据类型获取bean
     * @param clazz bean类型
     * @date 2019/9/15 15:02
     * @return T
     **/
    public static <T> T getBean(Class<T> clazz) {
        T t = null;
        Map<String, T> beanMap = context.getBeansOfType(clazz);

        for (Map.Entry<String, T> entry : beanMap.entrySet()) {
            t = entry.getValue();
        }

        return t;
    }

    /**
     * 判断容器是否存在bean
     * @param name bean名
     * @date 2019/9/15 15:03
     * @return boolean
     **/
    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    /**
     * 判断是否单例
     * @param name bean名
     * @date 2019/9/15 15:04
     * @return boolean
     **/
    public static boolean isSingleton(String name) {
        return context.isSingleton(name);
    }

    /**
     * bean类型
     * @param name bean名
     * @date 2019/9/15 15:05
     * @return java.lang.Class
     **/
    public static Class getType(String name) {
        return context.getType(name);
    }
}
