package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import com.cloudyoung.baic.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class DealerInfo extends BaseModel {
    @NotNull(message="")
    private Integer dealerId;

    private String dealerCode;

    @NotNull(message="")
    private String dealerName;

    @FieldComment(value="公司全称")
    @NotNull(message="公司全称")
    private String companyName;

    @FieldComment(value="销售地址")
    private String saleAddress;

    @FieldComment(value="服务地址")
    @NotNull(message="服务地址")
    private String serviceAddress;

    private String serviceCall;

    private String saleCall;

    private String helpCall;

    private Integer cityId;

    @FieldComment(value="服务经度")
    private String serviceLongitude;

    private String serviceLatitude;

    @FieldComment(value="销售经度")
    @NotNull(message="销售经度")
    private String saleLongitude;

    @FieldComment(value="销售纬度")
    @NotNull(message="销售纬度")
    private String saleLatitude;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}