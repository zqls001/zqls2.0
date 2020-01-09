package com.duanxin.zqls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/1/7 8:38
 */
@SpringBootApplication
@MapperScan("com.duanxin.zqls.umps.mapper")
public class ZqlsUmpsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZqlsUmpsServiceApplication.class, args);
    }
}
