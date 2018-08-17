package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import com.cloudyoung.baic.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class MaintainHistory extends BaseModel {
    @NotNull(message="")
    private Integer maintainId;

    private Integer userId;

    private String mileage;

    private Date maintainTime;

    private String content;

    private String shopCode;

    private String shopName;

    private Integer recordId;

    @FieldComment(value="1是导入")
    private Integer source;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}