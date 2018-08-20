package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
public class CarInfo extends BaseModel {
    @NotNull(message="")
    private Integer carId;

    private Integer brandId;

    private String brandName;

    private String logo;

    private Integer serialId;

    private String serialName;

    private String serialColor;

    private String whitecoverImage;

    private String clarityImage;

    private Integer styleId;

    private String styleName;

    private BigDecimal referPrice;

    private BigDecimal engineCapacity;

    private String power;

    private Integer year;

    private String addPressType;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}