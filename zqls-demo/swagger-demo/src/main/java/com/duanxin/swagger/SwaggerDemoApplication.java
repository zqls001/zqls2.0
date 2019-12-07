package com.duanxin.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/12/5 16:09
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
public class SwaggerDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoApplication.class, args);
    }
}
