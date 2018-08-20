package com.byebye.kzj.webapi.vo;

import com.byebye.kzj.common.utils.DateUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Description:评论列表
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/18 14:37  by  李娜（lina@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class CommentListVo implements Serializable {

    //评论id
    private Integer commentId;

    private Integer userId;

    private String commentContent;

    //关联评论id
    private Integer relaCommentId;

    //关联评论用户Id
    private Integer relaCommentUserId;

    //点赞次数
    private Integer likeCount;

    private String createTime;

    //    用户姓名
    private String userName;
    //    @评论人的姓名
    private String relaCommentUserName;
    //    头像地址
    private String avatar;
    //    是否点赞，1：点赞，2：没有点赞
    private Integer isLike;
    //    二级评论列表
    private List<CommentListVo> childCommentList;
    //    二级评论数
    private Integer childListCount;

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
        Date date = DateUtil.toDate(createTime, "yyyy-MM-dd HH:mm:ss");
        String time = DateUtil.formatDateTime(date, "yyyy-MM-dd HH:mm:ss");
        this.createTime = time;
    }
}
