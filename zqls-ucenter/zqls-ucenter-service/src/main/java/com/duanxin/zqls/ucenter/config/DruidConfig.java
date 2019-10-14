package com.duanxin.zqls.ucenter.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Druid配置
 * @author duanxin
 * @version 1.0
 * @date 2019/9/20 9:27
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置管理druid后台的servlet
     * @date 2019/9/20 9:30
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     **/
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> map = new HashMap<> ();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "admin");
        // 允许所有访问
        map.put("allow", "");
        // 拒绝访问ip
        map.put("deny", "");
        bean.setInitParameters(map);

        return bean;
    }

    /**
     * 配置web监控的filter
     * @date 2019/9/20 9:34
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     **/
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> map = new HashMap<>();
        // 排除过滤范围
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
