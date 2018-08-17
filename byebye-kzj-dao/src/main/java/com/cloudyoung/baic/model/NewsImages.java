package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class NewsImages extends BaseModel {
    @NotNull(message="")
    private Long imageId;

    @NotNull(message="")
    private Integer newsId;

    @NotNull(message="")
    private String imageUrl;

    @NotNull(message="")
    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}