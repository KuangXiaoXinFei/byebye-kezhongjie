package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class SerialOverallImages extends BaseModel {
    @NotNull(message="")
    private Integer overallId;

    private Integer serialId;

    private Integer colorId;

    private String colorName;

    private String imgUrl;

    private Integer orderNum;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}