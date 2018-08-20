package com.byebye.kzj.service.adminservice;

import com.byebye.kzj.model.PushAlertInfo;
import com.byebye.kzj.vo.admin.PushAlertQueryVo;
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
