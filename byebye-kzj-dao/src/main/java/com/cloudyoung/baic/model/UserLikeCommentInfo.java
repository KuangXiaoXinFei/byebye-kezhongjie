package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserLikeCommentInfo extends BaseModel {
    @NotNull(message="")
    private Integer relaId;

    private Integer commentId;

    private Integer userId;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}