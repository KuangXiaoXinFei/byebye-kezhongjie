package com.byebye.kzj.vo.api.user;

import com.byebye.kzj.model.UserInfo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/11 9:57  by  侯春春（houcc@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class BaseUserVo extends UserInfo {
    public static BaseUserVo trans(UserInfo userInfo) {
        BaseUserVo result = new BaseUserVo();
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
        return result;
    }
}
