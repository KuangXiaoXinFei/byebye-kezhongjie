package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import com.byebye.kzj.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class TestDriveInfo extends BaseModel {
    @NotNull(message="")
    private Integer testId;

    private Integer styleId;

    private String carName;

    private String userName;

    private String mobile;

    @FieldComment(value="1是男2是女")
    private Byte sex;

    @FieldComment(value="1是发送")
    private Byte postStatus;

    private Byte isActive;

    @NotNull(message="")
    private Date createTime;

    @NotNull(message="")
    private Date updateTime;
}