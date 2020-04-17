package com.duanxin.zqls.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域请求配置
 * @author duanxin
 * @version 1.0
 * @date 2020/4/17 10:12
 */
@Configuration
public class CorsConfig {

    /**
     * 当前跨域请求最大有效时长，默认 7 天
     * */
    private final static long MAX_AGE = 7 * 24 * 60 * 60;

    private CorsConfiguration buildConfig() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // 设置允许跨域访问源地址
        config.addAllowedHeader("*"); // 设置允许跨域访问源请求头
        config.addAllowedMethod("*"); // 设置允许跨域访问源请求方法
        config.setMaxAge(MAX_AGE); // 设置有效访问时长
        return config;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 对接口配置跨域设置
        return new CorsFilter(source);
    }
}
