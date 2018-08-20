package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class AuthResource extends BaseModel {
    @NotNull(message="")
    private Integer resourceId;

    private String resourceName;

    private String resourceKey;

    private String resourceUrl;

    private String icon;

    private Integer orderNum;

    private Integer parentId;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}