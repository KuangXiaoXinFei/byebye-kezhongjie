package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ComplainInfo extends BaseModel {
    @NotNull(message = "")
    private Long id;

    private Integer userId;

    private Integer newsId;

    private Integer isActive;

    @NotNull(message = "")
    private Date createTime;

    @NotNull(message = "")
    private Date updateTime;
}