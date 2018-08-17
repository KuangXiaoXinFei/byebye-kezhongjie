package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import com.cloudyoung.baic.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserCarInfo extends BaseModel {
    @NotNull(message="")
    private Integer id;

    private Integer userId;

    private String vinCode;

    private String carCode;

    private String uuid;

    private String colorName;

    private Integer colorId;

    private Integer serialId;

    private String carInfo;

    private String coverUrl;

    @NotNull(message="")
    private String vinUrl;

    @FieldComment(value="发动机号")
    @NotNull(message="发动机号")
    private String engineNum;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}