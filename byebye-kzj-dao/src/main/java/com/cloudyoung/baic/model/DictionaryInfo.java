package com.cloudyoung.baic.model;

import com.cloudyoung.baic.common.model.BaseModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class DictionaryInfo extends BaseModel {
    @NotNull(message="")
    private Integer id;

    private Integer dictionaryId;

    private String dictionaryName;

    private Integer dictionaryClassId;

    private Short orderNum;

    private Byte isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}