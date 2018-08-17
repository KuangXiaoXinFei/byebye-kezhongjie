package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import com.cloudyoung.baic.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class PublicPush extends BaseModel {
    @NotNull(message="")
    private Integer publicId;

    private String pushContent;

    @FieldComment(value="1发送0")
    @NotNull(message="1发送0")
    private Integer pushStatus;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}