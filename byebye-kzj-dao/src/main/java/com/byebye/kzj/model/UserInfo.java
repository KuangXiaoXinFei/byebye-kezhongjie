package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import com.byebye.kzj.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserInfo extends BaseModel {
    @NotNull(message="")
    private Integer userId;

    private String userName;

    @FieldComment(value="1是男")
    private Integer sex;

    private String avatar;

    private String mobile;

    private String pushCode;

    private String openId;

    @FieldComment(value="1是验证")
    private Integer isValidate;

    private String realName;

    private String idCode;

    @FieldComment(value="1是真实用户")
    private Integer userType;

    @FieldComment(value="1是")
    private Integer isTalk;

    private Integer articleCount;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}