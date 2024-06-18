package com.neuedu.mobilebank.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private HandlerInterceptor myInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {

            registry.addInterceptor(myInterceptor)
                    .addPathPatterns("/**")
                    .excludePathPatterns("/mobile/**");

            WebMvcConfigurer.super.addInterceptors(registry);
        }

    //后端允许跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域的规则
        registry.addMapping("/**")
                //放行哪些原始域
                .allowedOrigins("*")
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                .allowedHeaders("*")
                .exposedHeaders("*");
    }






}
