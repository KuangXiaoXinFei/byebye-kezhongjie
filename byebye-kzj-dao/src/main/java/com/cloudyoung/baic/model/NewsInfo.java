package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import com.cloudyoung.baic.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class NewsInfo extends BaseModel {
    @NotNull(message="")
    private Integer newsId;

    private String title;

    private String description;

    private Integer userId;

    @FieldComment(value="1是图文")
    private Integer newsType;

    @FieldComment(value="1是官方")
    private Integer source;

    private Integer imageCount;

    private String imagesUrl;

    @FieldComment(value="1一张图")
    private Integer showModel;

    @FieldComment(value="1是")
    private Integer isComment;

    @FieldComment(value="1是上架")
    private Integer status;

    private Integer isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}