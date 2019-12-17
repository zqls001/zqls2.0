package com.duanxin.test;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/24 9:52
 */
@SpringBootApplication()
@MapperScan("com.duanxin.test.mapper")
@EnableDubbo(scanBasePackages = "com.duanxin.test.service")
public class DubboTestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboTestServiceApplication.class, args);
    }
}
