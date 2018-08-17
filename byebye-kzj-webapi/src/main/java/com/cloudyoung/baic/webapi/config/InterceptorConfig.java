package com.cloudyoung.baic.webapi.config;

import com.cloudyoung.baic.webapi.intercepter.SignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/6/27 19:44  by  马双亮（masl@cloud-young.com）创建
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public SignInterceptor signInterceptor() {
        return new SignInterceptor();
    }

    //增加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInterceptor())
                .addPathPatterns("/v1/**")
                .excludePathPatterns("/v1/h5/**")
                .excludePathPatterns("/v1/user/scanImage")
                .excludePathPatterns("/baic/v1/error/**");     //指定该类拦截的url
    }
}
