package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class WxUserLogin extends BaseModel {
    @NotNull(message="")
    private Integer wxId;

    private String accessToken;

    private String refreshToken;

    private String openId;

    private Date expiresIn;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}