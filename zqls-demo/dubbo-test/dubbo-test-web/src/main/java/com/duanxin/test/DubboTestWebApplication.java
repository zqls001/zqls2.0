package com.duanxin.test;

import com.duanxin.zqls.common.config.RedissonAutoConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/24 9:55
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        RedissonAutoConfiguration.class
})
@EnableDubbo(scanBasePackages = "com.duanxin.test.service")
public class DubboTestWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboTestWebApplication.class, args);
    }
}
