package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserPushSettingValue extends BaseModel {
    @NotNull(message="")
    private Integer valueId;

    private Integer settingId;

    private Integer settingKey;

    private Integer settingValue;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}