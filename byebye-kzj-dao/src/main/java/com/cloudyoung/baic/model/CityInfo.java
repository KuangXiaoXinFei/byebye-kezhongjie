package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class CityInfo extends BaseModel {
    @NotNull(message="")
    private Integer cityId;

    private Integer cityCode;

    private String cityName;

    private Integer provinceId;

    private String provinceName;

    private String fistChar;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}