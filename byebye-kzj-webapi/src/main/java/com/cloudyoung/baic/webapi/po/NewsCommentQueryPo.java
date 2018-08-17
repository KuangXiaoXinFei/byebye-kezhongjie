package com.cloudyoung.baic.webapi.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  张伟杰（zhangwj@cloud-young.com）created at 2018/7/13 15:31
 */

@Data
@Accessors(chain = true)
public class NewsCommentQueryPo  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private Long commentId;
    /**
     * 评论ID,分页使用
     */
    //private Long lastCommentId;

    /**
     * 资讯文章id
     */
    private Long newsId;

    /**
     * 当前用户id
     */
    private Long userId;

}
