package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import com.cloudyoung.baic.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class BannerInfo extends BaseModel {
    @NotNull(message="")
    private Integer bannerId;

    private String imagePath;

    private String url;

    private Integer weight;

    private String description;

    @FieldComment(value="1上架")
    private Integer status;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}