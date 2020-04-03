package com.duanxin.zqls.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * spring容器初始化完成事件
 * @author duanxin
 * @version 1.0
 * @date 2019/9/16 16:14
 */
@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private final static Logger log = LoggerFactory.getLogger(ApplicationContextListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // 初始化容器
        /*if (null == event.getApplicationContext().getParent()) {
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
        }*/

        //  todo：系统入口初始化

    }
}
