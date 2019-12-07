package com.duanxin.zqls.fms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 食物模块Swagger配置类
 * @author duanxin
 * @version 1.0
 * @date 2019/12/5 16:25
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * swagger配置文件信息
     * @date 2019/12/5 16:32
     * @return springfox.documentation.spring.web.plugins.Docket
     **/
    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                select().
                apis(RequestHandlerSelectors.basePackage("com.duanxin.zqls.fms")).
                paths(PathSelectors.any()).
                build();
    }

    /**
     * 构建api文档信息
     * */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().
                // 设置页面标题
                title("食物模块api接口文档").
                // 页面描述
                description("欢迎访问食物模块api接口文档").
                // 定义版本号
                version("0.0.1").
                build();
    }

}
