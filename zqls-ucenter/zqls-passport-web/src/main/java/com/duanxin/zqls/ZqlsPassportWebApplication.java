package com.duanxin.zqls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 认证中心web端
 * @author duanxin
 * @version 1.0
 * @date 2019/12/13 9:18
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableSwagger2
public class ZqlsPassportWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqlsPassportWebApplication.class, args);
    }

}
