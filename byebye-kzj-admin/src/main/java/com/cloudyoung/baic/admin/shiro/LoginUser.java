package com.cloudyoung.baic.admin.shiro;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/6 16:36  by  李娜（lina@cloud-young.com）创建
 */
public class LoginUser implements Serializable{
    public LoginUser() {
    }

    private Integer userId;

    private String userName;

    private String showName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoginUser user = (LoginUser) o;

        if (!userId.equals(user.userId)) {
            return false;
        }
        if (!userName.equals(user.userName)) {
            return false;
        }

        return showName.equals(user.showName);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + showName.hashCode();
        return result;
    }
}
