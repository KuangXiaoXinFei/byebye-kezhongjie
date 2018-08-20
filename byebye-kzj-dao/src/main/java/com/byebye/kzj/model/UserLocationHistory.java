package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import com.byebye.kzj.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserLocationHistory extends BaseModel {
    @NotNull(message="")
    private Integer localId;

    private Integer userId;

    @FieldComment(value="1是高德")
    private Integer source;

    private BigDecimal amapLongitude;

    private BigDecimal amapLatitude;

    private BigDecimal baiduLongitude;

    private BigDecimal baiduLatitude;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}