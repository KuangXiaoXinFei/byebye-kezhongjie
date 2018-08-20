package com.byebye.kzj.webapi.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/8/1 下午6:37
 */
@Data
@Accessors(chain = true)
public class UserPushSettingPo implements Serializable {
    private Integer settingId;
    private String beginTime;
    private String endTime;
    private String valueArray;
}
