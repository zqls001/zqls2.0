package com.duanxin.zqls.common.listener;

import com.duanxin.zqls.common.annotation.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * spring容器初始化完成事件
 * @author duanxin
 * @version 1.0
 * @date 2019/9/16 16:14
 */
@Slf4j
@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // 初始化容器
        if (null == event.getApplicationContext().getParent()) {
            log.debug(">>>> spring初始化完毕 <<<<");
            // spring初始化完毕，通过反射调用所有使用BaseService注解的initMapper方法
            Map<String, Object> baseServices = event.getApplicationContext().getBeansWithAnnotation(BaseService.class);
            for (Object service : baseServices.values()) {
                log.debug(">>>> {}.initMapper()", service.getClass().getName());
                try {
                    Method initMapper = service.getClass().getMethod("initMapper");
                    initMapper.invoke(service);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    log.error("初始化BaseService的initMapper方法异常", e);
                    e.printStackTrace();
                }
            }
        }

        //  todo：系统入口初始化

    }
}
