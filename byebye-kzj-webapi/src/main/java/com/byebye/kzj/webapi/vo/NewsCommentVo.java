package com.byebye.kzj.webapi.vo;

import com.byebye.kzj.common.model.FieldComment;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 资讯评论vo
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  张伟杰（zhangwj@cloud-young.com）created at 2018/7/13 10:39
 */
@Data
@Accessors(chain = true)
public class NewsCommentVo implements Serializable {

    private static final long serialVersionUID = 1L;

    //资讯页面（展示最早的两条二级评论）
    private List<NewsCommentVo> commentlist = new ArrayList<NewsCommentVo>();

    //评论详情页面
    private PageInfo<NewsCommentVo> pageData;

    private Long commentId;

    private Long newsId;

    private Long userId;

    private String commentContent;

    private Long relaCommentId;

    private Long relaCommentUserId;

    //private Integer commentStatus;

    private Integer commentCount;

    private Date createTime;

    private Date updateTime;

    private String userName;

    private String avatar;

    private String relaCommentUserName;

    //逻辑标识
    private Integer isActive;

    @FieldComment(value="点赞状态")
    private int isLiked = 0;

}
