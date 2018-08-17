package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class MaintainDetail extends BaseModel {
    @NotNull(message="")
    private Integer detailId;

    private Integer maintainId;

    private String code;

    private String content;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}