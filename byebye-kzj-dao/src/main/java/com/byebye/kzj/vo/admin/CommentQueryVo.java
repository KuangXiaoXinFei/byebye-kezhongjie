package com.byebye.kzj.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/10 11:16  by  李娜（lina@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class CommentQueryVo implements Serializable {
    //    评论id
    private Integer commentId;
    //    评论内容
    private String commentContent;
    //    用户id
    private Integer userId;
    //    用户昵称
    private String userName;
    //    关联评论id
    private Integer relaCommentId;
    //    资讯id
    private Integer newsId;
    //    资讯标题
    private String title;
    //    最小创建时间
    private String minCreateTime;
    //    最大创建时间
    private String maxCreateTime;
}
