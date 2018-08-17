package com.cloudyoung.baic.service.adminservice;

import com.cloudyoung.baic.model.AuthResource;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/5 14:51  by  李娜（lina@cloud-young.com）创建
 */
public interface AuthResourceService {
    /**
     * Description:获取当前有效的资源信息
     * @version 1.0  2018/7/5 14:59  by  李娜（lina@cloud-young.com）创建
     * @param
     * @return
     */
    List<AuthResource> getResourceList();

}
