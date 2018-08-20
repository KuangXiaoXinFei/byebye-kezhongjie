package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import com.byebye.kzj.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ServiceBanner extends BaseModel {
    @NotNull(message = "")
    private Integer serviceId;

    private String title;

    private String url;

    private String imagePath;

    private String extend;

    @FieldComment(value = "1是导航")
    private Integer type;

    private Integer orderNum;

    private Integer isActive;

    @NotNull(message = "")
    private Date createTime;

    @NotNull(message = "")
    private Date updateTime;
}