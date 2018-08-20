package com.byebye.kzj.vo.admin;

import com.byebye.kzj.model.NewsComment;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/10 11:38  by  李娜（lina@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class NewsCommentVo extends NewsComment {
    //    资讯标题
    private String title;
    //    用户昵称
    private String userName;

}
