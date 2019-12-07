package com.duanxin.zqls;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        ThymeleafAutoConfiguration.class
})
@EnableDubbo(scanBasePackages = "com.duanxin.zqls.ucenter.service")
@EnableSwagger2
public class ZqlsUcenterWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqlsUcenterWebApplication.class, args);
    }

}
