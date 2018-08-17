package com.cloudyoung.baic.service.adminservice;

import com.cloudyoung.baic.model.PushAlertInfo;
import com.cloudyoung.baic.vo.admin.PushAlertQueryVo;
import com.github.pagehelper.PageInfo;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/13 14:42  by  李娜（lina@cloud-young.com）创建
 */
public interface PushAlertService {
    PageInfo getPageList(PushAlertQueryVo query,Integer pageIndex,Integer pageSize);

    int add(PushAlertInfo info);
}
