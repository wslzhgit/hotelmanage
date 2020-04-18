package com.java.spring;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 2020/2/19   11:46
 * Author:W.铭
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.java.spring.*")
@MapperScan(basePackages = "com.java.spring.mapper")
public class StartApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class);
    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
