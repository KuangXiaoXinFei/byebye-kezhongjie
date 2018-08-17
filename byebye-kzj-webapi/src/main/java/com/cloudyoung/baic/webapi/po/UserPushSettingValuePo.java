package com.cloudyoung.baic.webapi.po;

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
public class UserPushSettingValuePo implements Serializable {
    private Integer valueId;

    private Integer settingValue;
}
