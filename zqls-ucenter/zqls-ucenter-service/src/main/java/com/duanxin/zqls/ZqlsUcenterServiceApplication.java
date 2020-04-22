package com.duanxin.zqls;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.duanxin.zqls.ucenter.mapper")
@EnableDubbo(scanBasePackages = "com.duanxin.zqls.ucenter.service")
@ComponentScan({"org.n3r.idworker", "com.duanxin.zqls"})
public class ZqlsUcenterServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZqlsUcenterServiceApplication.class, args);
    }

}
