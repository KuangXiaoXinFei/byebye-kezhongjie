package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class AuthAccount extends BaseModel {
    @NotNull(message="")
    private Integer accountId;

    private String accountName;

    private String realName;

    private String password;

    private Integer roleId;

    private String email;

    private String mobile;

    private Integer isInital;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}