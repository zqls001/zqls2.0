package com.duanxin.zqls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 9:06
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        ThymeleafAutoConfiguration.class
})
public class ZqlsFmsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZqlsFmsWebApplication.class, args);
    }
}
