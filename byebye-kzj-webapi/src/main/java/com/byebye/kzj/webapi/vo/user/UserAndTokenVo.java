package com.byebye.kzj.webapi.vo.user;

import com.byebye.kzj.model.UserInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/11 10:36  by  侯春春（houcc@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class UserAndTokenVo extends BaseUserVo {
    private String token;

    private Date tokenUpdateTime;

    public static UserAndTokenVo trans(UserInfo userInfo) {
        UserAndTokenVo result = new UserAndTokenVo();
        result.setUserId(userInfo.getUserId());
        result.setUserName(userInfo.getUserName());
        result.setSex(userInfo.getSex());
        result.setAvatar(userInfo.getAvatar());
        result.setMobile(userInfo.getMobile());
        result.setPushCode(userInfo.getPushCode());
        result.setOpenId(userInfo.getOpenId());
        result.setIsValidate(userInfo.getIsValidate());
        result.setRealName(userInfo.getRealName());
        result.setIdCode(userInfo.getIdCode());
        result.setUserType(userInfo.getUserType());
        result.setIsTalk(userInfo.getIsTalk());
        result.setArticleCount(userInfo.getArticleCount());
        result.setIsActive(userInfo.getIsActive());
        result.setCreateTime(userInfo.getCreateTime());
        result.setUpdateTime(userInfo.getUpdateTime());
        result.setToken("");
        result.setTokenUpdateTime(new Date());
        return result;
    }

    /**
     * 认证车系名称
     */
    private String carName;
}
