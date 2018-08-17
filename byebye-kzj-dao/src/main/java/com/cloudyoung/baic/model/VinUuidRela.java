package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class VinUuidRela extends BaseModel {
    @NotNull(message="")
    private Integer id;

    private String vinCode;

    private String uuid;

    private Date collectTime;

    private String carCode;

    private String gearBoxCode;

    private String engine;

    private String engineType;

    private String capacity;

    private String power;

    private String modeName;

    private String modeNo;

    private String zname;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}