package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class NewsCarRelation extends BaseModel {
    @NotNull(message="")
    private Integer relaId;

    private Integer newsId;

    private Integer brandId;

    private Integer serialId;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}