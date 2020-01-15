package com.duanxin.zqls;

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
public class ZqlsFmsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZqlsFmsServiceApplication.class, args);
    }
}
