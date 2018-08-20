package com.byebye.kzj.admin.shiro;

import com.byebye.kzj.model.AuthAccount;
import com.byebye.kzj.service.adminservice.AuthAccountService;
import com.byebye.kzj.service.util.CookieUtil;
import com.byebye.kzj.service.util.EncryptUtil;
import com.byebye.kzj.vo.admin.ResourceVo;
import com.byebye.kzj.vo.admin.ResponseVo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/6 16:31  by  李娜（lina@cloud-young.com）创建
 */
@Component
public class UserUtil {
    private static String Request_Login_User_NAME = "r_security-token";

    private static String Session_Login_User_NAME = "s_security-token";

    private final String LOGIN_COOKIE_NAME = "mytoken";

    private static final String LOGIN_USER = "LoginUser";

    private static final String LOGIN_USER_SESSION = "LoginUserSession";

    @Value("${md5.salt}")
    private String MD5_SALT;

    @Autowired
    private AuthAccountService authAccountService;

    public String getUserRedirectResource(HttpServletRequest servletRequest) {
        LoginUser user = this.getLoginUser(servletRequest);
        if (user == null || StringUtils.isEmpty(user.getUserName())) {
            return null;
        }
        List<ResourceVo> resourceVoList = authAccountService.getResourceListByAccountName(user.getUserName());
        if (resourceVoList == null || resourceVoList.size() == 0) {
            return null;
        }
        resourceVoList.sort(new Comparator<ResourceVo>() {
            @Override
            public int compare(ResourceVo o1, ResourceVo o2) {

                if (o1.getParentId() > o2.getParentId()) {
                    return 1;
                } else if (o1.getParentId().equals(o2.getParentId())) {
                    return o1.getOrderNum().compareTo(o2.getOrderNum());
                } else {
                    return -1;
                }
            }
        });
        ResourceVo one = resourceVoList.get(0);
        if (one == null) {
            return null;
        }
        return one.getResourceUrl();
    }

    public LoginUser getLoginUser(HttpServletRequest httpServletRequest) {
        LoginUser loginUser = null;
        HttpSession session = httpServletRequest.getSession();
        Object loginUserSession = session.getAttribute(LOGIN_USER_SESSION);
        if (loginUserSession != null) {
            loginUser = (LoginUser) loginUserSession;
            httpServletRequest.setAttribute(LOGIN_USER, loginUser);
        }
        loginUser = this.getUser(httpServletRequest);
        if (loginUser != null) {
            session.setAttribute(LOGIN_USER_SESSION, loginUser);
            httpServletRequest.setAttribute(LOGIN_USER, loginUser);
        }
        return loginUser;
    }

    private LoginUser getUser(HttpServletRequest request) {
        String userName = "";
        if (request.getAttribute(Request_Login_User_NAME) != null) {
            userName = request.getAttribute(Request_Login_User_NAME).toString();
        }

        if (userName == null || userName.length() == 0) {
            userName = CookieUtil.getFromCookie(request, LOGIN_COOKIE_NAME);
            userName = EncryptUtil.decryptString(userName, trimString(MD5_SALT));
        }
        AuthAccount account = authAccountService.getAccountByName(userName);
        if (account != null) {
            LoginUser loginUser = new LoginUser();
            loginUser.setUserId(account.getAccountId());
            loginUser.setUserName(account.getAccountName());
            loginUser.setShowName(account.getRealName());
            return loginUser;
        }
        return null;
    }

    private String trimString(String in) {
        if (in == null || in.length() == 0) {
            return "";
        }
        return in.trim();
    }


    public String getUserName(HttpServletRequest request) {
        String userName = "";
        if (request.getAttribute(Request_Login_User_NAME) != null) {
            userName = request.getAttribute(Request_Login_User_NAME).toString();
        }

        HttpSession session = request.getSession();
        if (StringUtils.isEmpty(userName) && session.getAttribute(Session_Login_User_NAME) != null) {
            userName = session.getAttribute(Session_Login_User_NAME).toString();
        }
        if (userName == null || userName.length() == 0) {
            userName = CookieUtil.getFromCookie(request, LOGIN_COOKIE_NAME);
            userName = EncryptUtil.decryptString(userName, trimString(MD5_SALT));
        }
        return userName;
    }


    public ResponseVo userLogin(String userName, String password, HttpServletRequest request, HttpServletResponse response) {
        AuthAccount account = authAccountService.getAccountByName(userName);
        if (account == null) {
            return ResponseVo.getInstanceForError(303103, "账号不存在！");
        }
        String newPassword = EncryptUtil.md5Encrypt(password, trimString(MD5_SALT));
        if (!newPassword.equals(account.getPassword())) {
            return ResponseVo.getInstanceForError(303102, "密码错误！");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(account.getAccountId());
        loginUser.setUserName(account.getAccountName());
        loginUser.setShowName(account.getRealName());

        //主体，当前状态为没有认证的状态"未认证"
        Subject subject = SecurityUtils.getSubject();
        //登录后存放进shiro token 生成令牌
        UsernamePasswordToken token = new UsernamePasswordToken(userName, "defaultPWD");
        //登录方法
        try {
            subject.login(token);
            request.setAttribute(LOGIN_USER, loginUser);
            request.setAttribute(Request_Login_User_NAME, userName);
            //session
            HttpSession session = request.getSession();
            session.setAttribute(Session_Login_User_NAME, userName);
            session.setAttribute(LOGIN_USER_SESSION, loginUser);
            //todo: 写cookie
            String userNameEncrypt = EncryptUtil.encrypt(userName, trimString(MD5_SALT));
            Cookie cookie = CookieUtil.createCookie(LOGIN_COOKIE_NAME, userNameEncrypt);
            response.addCookie(cookie);
        } catch (Exception e) {
            return ResponseVo.getInstanceForError(303103, "登录失败！");
        }
        return ResponseVo.getInstanceForOk("/index");
    }

    public void clearLogin(HttpServletRequest request, HttpServletResponse response) {
        //session
        HttpSession session = request.getSession();
        session.removeAttribute(LOGIN_USER_SESSION);
        session.removeAttribute(Session_Login_User_NAME);
        //cookie
        CookieUtil.clearCookie(request, response, LOGIN_COOKIE_NAME);
        //主体,当前状态为没有认证的状态“未认证”
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    public void createUserCookie(HttpServletRequest request, HttpServletResponse response, String userName) {
        if (StringUtils.isNotEmpty(userName)) {
            //userName = EncryptUtil.decryptString(userName, trimString(MD5_SALT));
            request.setAttribute(Request_Login_User_NAME, userName);
            //session
            HttpSession session = request.getSession();
            if (session.getAttribute(Session_Login_User_NAME) != null) {
                session.setAttribute(Session_Login_User_NAME, userName);
            }
            String userNameEncrypt = EncryptUtil.encrypt(userName, trimString(MD5_SALT));
            Cookie cookie = CookieUtil.createCookie(LOGIN_COOKIE_NAME, userNameEncrypt);
            response.addCookie(cookie);
        }
    }
}
