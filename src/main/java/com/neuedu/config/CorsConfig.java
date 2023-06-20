package com.neuedu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")      //设置允许访问的请求路径
                .allowedOrigins("*")              //设置允许访问的域名
                .allowCredentials(true)              //设置跨域访问时允许添加Cookie
                .allowedMethods("GET","POST","DELETE","PUT") //设置允许访问的请求方式
                .allowedHeaders("*")                //设置允许访问的请求头
                .maxAge(3600);                      //设置允许访问的最大时间

    }
}
