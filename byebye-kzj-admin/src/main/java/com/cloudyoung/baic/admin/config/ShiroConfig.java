package com.cloudyoung.baic.admin.config;

import com.cloudyoung.baic.admin.shiro.AuthcFilter;
import com.cloudyoung.baic.admin.shiro.SysRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @version 1.0  2018/1/3 11:56
 */
@Configuration
public class ShiroConfig {

    @Bean
    public FilterRegistrationBean shiroLoginFilteRegistration(AccessControlFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        registration.setOrder(1);
        return registration;
    }

    @Bean(name = "statelessAuthcFilter")
    public AuthcFilter getStateAuthcFilter() {
        return new AuthcFilter();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map filters = new LinkedHashMap(1);
        filters.put("statelessAuthcFilter", getStateAuthcFilter());
        shiroFilterFactoryBean.setFilters(filters);

        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/dologin", "anon");
        filterChainDefinitionMap.put("/error", "anon");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "statelessAuthcFilter");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean(name = "sysRealm")
    public SysRealm myShiroRealm() {
        SysRealm myShiroRealm = new SysRealm();
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager(SysRealm sysRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(sysRealm);
        return securityManager;
    }

}
