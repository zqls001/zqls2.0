package com.duanxin.zqls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class
        }
)
public class ZqlsMailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqlsMailServiceApplication.class, args);
    }

}
