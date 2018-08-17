package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import com.cloudyoung.baic.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class SmsCodeInfo extends BaseModel {
    @NotNull(message="")
    private Integer smsId;

    private String mobile;

    private String code;

    @FieldComment(value="1是已用")
    private Integer status;

    private Date deadline;

    @FieldComment(value="1是登录验证")
    private Integer smsType;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}