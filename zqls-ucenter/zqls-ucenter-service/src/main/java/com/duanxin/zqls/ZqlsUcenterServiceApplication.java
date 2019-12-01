package com.duanxin.zqls;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication()
@MapperScan("com.duanxin.zqls.ucenter.mapper")
@EnableDubbo(scanBasePackages = "com.duanxin.zqls.ucenter.service")
public class ZqlsUcenterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqlsUcenterServiceApplication.class, args);
    }

}
