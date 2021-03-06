package com.duanxin.zqls;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class,
                MailSenderAutoConfiguration.class,
                DruidDataSourceAutoConfigure.class
        }
)
public class ZqlsMailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqlsMailServiceApplication.class, args);
    }

}
