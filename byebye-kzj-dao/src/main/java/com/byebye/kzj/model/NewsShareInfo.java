package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import com.byebye.kzj.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class NewsShareInfo extends BaseModel {
    @NotNull(message="")
    private Integer shareId;

    private Integer newsId;

    private Integer userId;

    @FieldComment(value="1是朋友圈")
    private Integer shareType;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}