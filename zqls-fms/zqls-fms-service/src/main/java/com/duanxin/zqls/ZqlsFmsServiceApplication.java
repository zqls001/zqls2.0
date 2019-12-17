package com.duanxin.zqls;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/16 8:50
 */
@SpringBootApplication()
@MapperScan("com.duanxin.zqls.fms.mapper")
@EnableDubbo(scanBasePackages = {
        "com.duanxin.zqls.fms.service",
        "com.duanxin.zqls.ucenter.service"
})
public class ZqlsFmsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZqlsFmsServiceApplication.class, args);
    }
}
