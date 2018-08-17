package com.cloudyoung.baic.vo.api;

import com.cloudyoung.baic.model.UserPushSettingValue;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/20 11:46  by  侯春春（houcc@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class UserPushSettingValueVo implements Serializable {
    private Integer valueId;

    private Integer settingKey;

    private Integer settingValue;

    private String settingKeyName;

    public static UserPushSettingValueVo trans(UserPushSettingValue obj) {
        UserPushSettingValueVo result = new UserPushSettingValueVo();
        result.setValueId(obj.getValueId());
        result.setSettingKey(obj.getSettingKey());
        result.setSettingValue(obj.getSettingValue());
        return result;
    }
}
