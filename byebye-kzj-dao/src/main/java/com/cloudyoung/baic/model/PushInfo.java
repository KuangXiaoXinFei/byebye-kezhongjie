package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import com.cloudyoung.baic.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class PushInfo extends BaseModel {
    @NotNull(message="")
    private Integer pushId;

    private Integer userId;

    private String pushContent;

    @FieldComment(value="0是未发送")
    private Integer pushStatus;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}