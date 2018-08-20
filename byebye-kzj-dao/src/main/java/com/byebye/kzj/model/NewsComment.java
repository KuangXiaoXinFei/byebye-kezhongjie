package com.byebye.kzj.model;

import com.byebye.kzj.common.model.BaseModel;
import com.byebye.kzj.common.model.FieldComment;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
public class NewsComment extends BaseModel {
    //评论id
    private Integer commentId;

    private Integer newsId;

    @FieldComment(value = "用户ID")
    private Integer userId;

    @FieldComment(value = "评论内容")
    private String commentContent;

    //关联评论id
    private Integer relaCommentId;

    //关联评论用户Id
    private Integer relaCommentUserId;

    //点赞次数
    private Integer likeCount;

    //逻辑标识 1.有效 2.逻辑删除
    private Integer isActive;

    @NotNull(message = "")
    private Date createTime;

    @NotNull(message = "")
    private Date updateTime;
}