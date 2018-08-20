package com.byebye.kzj.admin.shiro;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Description:
 * All Rights Reserved.
 */
public class AuthcFilter extends AccessControlFilter {

    @Autowired
    private UserUtil userUtil;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String userName = "";
        try {
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            //主体,当前状态为没有认证的状态“未认证”
            userName = userUtil.getUserName(servletRequest);
            if (StringUtils.isNotEmpty(userName)) {
                userUtil.createUserCookie(servletRequest, servletResponse, userName);
                UsernamePasswordToken statelessToken = new UsernamePasswordToken(userName, "defaultPWD");
                //5、委托给Realm进行登录
                getSubject(request, response).login(statelessToken);
                //userUtil.getLoginUser(servletRequest);
            } else {
                getSubject(request, response).logout();
                onLoginFail(request, response); //6、登录失败
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            onLoginFail(request, response); //6、登录失败
            return false;
        }
        return true;
    }

    //登录失败时返回配置信息NOLOGINRESULT
    private void onLoginFail(ServletRequest request, ServletResponse response) throws IOException {
        System.out.println();
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("login fail,response");
        if (isAjax((HttpServletRequest) request)) {
            httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            httpResponse.setCharacterEncoding("utf-8");
            httpResponse.getWriter().write("没有权限");
        } else {
            httpResponse.sendRedirect("/login");
        }
    }

    private boolean isAjax(HttpServletRequest request) {
        Enumeration enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String temp = enumeration.nextElement().toString();
            if (temp.toUpperCase().equals("X-REQUESTED-WITH")) {
                return true;
            }
        }
        return false;
    }
}
