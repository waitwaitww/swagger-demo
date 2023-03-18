package com.feng.swagger.config;


import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration  //等价于@Component
@EnableSwagger2  //开启Swagger2
public class SwaggerConfig {

    //配置了Swagger的Docket的Bean实例
    @Bean
    public Docket getDocket(Environment environment){

        //application中定义：
//        @Value("${swagger21.enable}")
//        boolean flag ;

        //获取项目当前环境：
        Profiles profiles = Profiles.of("dev","test");

        boolean curentprofiles = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(curentprofiles)
                .groupName("杨锋")
                .select()
                //RequestHandlerSelectors ：配置要扫描接口的方式
                //basePackage 指定扫描的包
                //any  扫描全部
                //none 都不扫描
                //withClassAnnotation  扫描类上的注解，参数是一个注解的反射对象  RestController.class
                //withMethodAnnotation  扫描方法上的注解  GetMapping.class
                .apis(RequestHandlerSelectors.basePackage("com.feng.swagger.controller"))
                //过滤路径
//                .paths(PathSelectors.ant("/feng/**"))
                .build();
    }

    //配置Swagger文档信息
    private ApiInfo apiInfo(){
        //作者信息
        Contact DEFAULT_CONTACT = new Contact("yangfeng", "https://www.bilibili.com/", "232332323@qq.com");

        return new ApiInfo(
                "feng's Documentation",
                "my best",
                "1.0",
                "https://www.bilibili.com/",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
