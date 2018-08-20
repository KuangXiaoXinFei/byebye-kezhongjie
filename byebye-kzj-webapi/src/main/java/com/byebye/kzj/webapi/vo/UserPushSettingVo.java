package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/19 19:43  by  侯春春（houcc@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class UserPushSettingVo implements Serializable {
    private Integer settingId;

    private String beginTime;

    private String endTime;

    private List<UserPushSettingValueVo> values;
}
