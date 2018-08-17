package com.cloudyoung.baic.admin.config;

import com.cloudyoung.baic.admin.intercepter.BasePathInterceptor;
import com.cloudyoung.baic.admin.intercepter.MenuInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * WebMvc配置
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        registry.addInterceptor(new BasePathInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index")
                .excludePathPatterns("/static/**");
        registry.addInterceptor(menuInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/MP_verify_rOD3m1KVGV7nR8hE.txt")
                .excludePathPatterns("/h5")
                .excludePathPatterns("/login")
                .excludePathPatterns("/dologin")
                .excludePathPatterns("/logout")
                .excludePathPatterns("/error/**")
                .excludePathPatterns("/static/**");
        super.addInterceptors(registry);
    }

    @Bean
    MenuInterceptor menuInterceptor() {
        return new MenuInterceptor();
    }

}
