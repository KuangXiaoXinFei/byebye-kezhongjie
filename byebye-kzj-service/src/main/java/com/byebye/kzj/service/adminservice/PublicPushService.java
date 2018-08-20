package com.byebye.kzj.service.adminservice;

import com.byebye.kzj.model.PublicPush;
import com.byebye.kzj.vo.admin.PublicPushVo;
import com.github.pagehelper.PageInfo;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/9 14:38  by  李娜（lina@cloud-young.com）创建
 */
public interface PublicPushService {
    /**
     * Description:获取消息
     * @version 1.0  2018/7/9 11:26  by  李娜（lina@cloud-young.com）创建
     * @param
     * @return
     */

    PageInfo getPushPageList(PublicPushVo query, Integer pageIndex, Integer pageSize);


    boolean insert(PublicPush publicPush);
}
