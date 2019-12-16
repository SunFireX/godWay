package com.dyt.swm.godway.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author weiming.sun
 * @Description
 * @Date 2019/7/25 17:50
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config{

   /**
    * @Author weiming.sun
    * @Description  swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等，不然会扫描到spring一些api
    * @Date 2019/7/25 17:51
    **/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.dyt.swm.godway")).paths(PathSelectors.any()).build();
    }

    /**
     * @Author weiming.sun
     * @Description 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     * @Date 2019/7/25 17:54
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("SpringBoot 使用 Swagger2 构建RESTful API")
                // 创建人
                .contact(new Contact("weiming.sun", "https://blog.csdn.net/wdy_2099", "13027792157@163.com"))
                // 版本号
                .version("1.0.0")
                // 描述
                .description("API 描述文件").build();
    }

}

