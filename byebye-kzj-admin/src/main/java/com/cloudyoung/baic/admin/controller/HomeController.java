package com.cloudyoung.baic.admin.controller;

import com.cloudyoung.baic.admin.shiro.LoginUser;
import com.cloudyoung.baic.admin.shiro.UserUtil;
import com.cloudyoung.baic.vo.admin.ResponseVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/3 14:10  by  李娜（lina@cloud-young.com）创建
 */
@Controller
public class HomeController {

    @Autowired
    private UserUtil userUtil;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        String redirectUrl = userUtil.getUserRedirectResource(request);
        if (StringUtils.isEmpty(redirectUrl)) {
            return "redirect:/error/noauthority";
        }
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        LoginUser user = userUtil.getLoginUser(request);
        if (user != null) {
            return "redirect:/index";
        }
        return "/login";
    }

    @ResponseBody
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public ResponseVo doLogin(String userName, String password
            , HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            return ResponseVo.getInstanceForError(100001, "请输入账号或密码");
        }
        return userUtil.userLogin(userName, password, request, response);
    }


    /**
     * 用户登出
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        userUtil.clearLogin(request, response);
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public ResponseVo getUser(HttpServletRequest request) {
        LoginUser user = userUtil.getLoginUser(request);
        if (user == null) {
            return ResponseVo.getInstanceForError("获取用户信息失败");
        }
        return ResponseVo.getInstanceForOk(user);
    }

    /**
     * 没权限错误页面
     *
     * @return
     */
    @RequestMapping("/error/noauthority")
    public String noauthority() {
        return "/error/noauthority";
    }



}
