package com.byebye.kzj.webapi.po;

import com.byebye.kzj.model.NewsComment;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 1.0 刘风栓
 */
@Data
@Accessors(chain = true)
public class NewsCommentPo extends NewsComment implements Serializable {

    //1：评论 对资讯或者一级评论的评论都是评论, 2：@回复
    private int replyType;

}
