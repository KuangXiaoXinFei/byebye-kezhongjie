package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import com.byebye.kzj.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class AuthRole extends BaseModel {
    @NotNull(message="")
    private Integer roleId;

    private String roleName;

    private String roleKey;

    @FieldComment(value="1是")
    private Integer isAdmin;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}