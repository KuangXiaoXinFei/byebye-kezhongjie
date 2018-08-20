package com.byebye.kzj.service.adminservice;

import com.byebye.kzj.vo.admin.CommentQueryVo;
import com.github.pagehelper.PageInfo;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/10 11:38  by  李娜（lina@cloud-young.com）创建
 */
public interface NewsCommentService {
    /**
     * Description:获取列表数据
     * @version 1.0  2018/7/10 14:47  by  李娜（lina@cloud-young.com）创建
     * @param 
     * @return
     */
    
    PageInfo getQueryList(CommentQueryVo query, Integer pageIndex, Integer pageSize);

    /**
     * Description:
     * @version 1.0  2018/7/10 15:18  by  李娜（lina@cloud-young.com）创建
     * @param 
     * @return
     */
    
    boolean deleteByCommentId(Integer commentId);
}
