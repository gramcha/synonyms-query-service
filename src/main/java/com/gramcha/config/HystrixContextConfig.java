package com.gramcha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Created by gramachandran on 30/10/18.
 */
@Configuration
public class HystrixContextConfig implements WebMvcConfigurer {

    @Bean
    HystrixContextInterceptor hystrixContextInterceptor() {
        return new HystrixContextInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(hystrixContextInterceptor());
    }

}