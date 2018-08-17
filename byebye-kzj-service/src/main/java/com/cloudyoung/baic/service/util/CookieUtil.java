package com.cloudyoung.baic.service.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * All Rights Reserved.
 */
public class CookieUtil {

    /**
     * cookie的过期时间，默认2小时
     */
    private static int cookieExpireSecond = 3600 * 2;

    public static String getFromCookie(HttpServletRequest request, String cookieName) {
        String token = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        return token;
    }

    public static Cookie createCookie(String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(cookieExpireSecond);
        cookie.setPath("/");
        return cookie;
    }

    public static void clearCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = new Cookie(cookies[i].getName(), null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");//根据你创建cookie的路径进行填写
                    response.addCookie(cookie);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
