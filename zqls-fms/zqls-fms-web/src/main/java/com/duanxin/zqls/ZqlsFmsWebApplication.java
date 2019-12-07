package com.duanxin.zqls;

import com.duanxin.zqls.common.config.RedissonAutoConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 9:06
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        ThymeleafAutoConfiguration.class,
        RedissonAutoConfiguration.class
})
@EnableDubbo(scanBasePackages = "com.duanxin.zqls.fms.service")
@EnableSwagger2
public class ZqlsFmsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZqlsFmsWebApplication.class, args);
    }
}
