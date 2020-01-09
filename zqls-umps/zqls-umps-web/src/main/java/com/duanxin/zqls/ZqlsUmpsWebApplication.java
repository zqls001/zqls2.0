package com.duanxin.zqls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/7 8:51
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableSwagger2
public class ZqlsUmpsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZqlsUmpsWebApplication.class, args);
    }
}
