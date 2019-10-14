package com.duanxin.zqls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        ThymeleafAutoConfiguration.class
})
public class ZqlsUcenterWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqlsUcenterWebApplication.class, args);
    }

}
