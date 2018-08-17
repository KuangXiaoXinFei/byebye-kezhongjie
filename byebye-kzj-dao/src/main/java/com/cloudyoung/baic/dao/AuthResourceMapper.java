package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.AuthResource;
import com.cloudyoung.baic.model.AuthResourceExample;

import java.util.List;

public interface AuthResourceMapper extends BaseMapper<AuthResource, AuthResourceExample> {
    /**
     * Description:获取当前有效的资源信息
     *
     * @param
     * @return
     * @version 1.0  2018/7/5 14:59  by  李娜（lina@cloud-young.com）创建
     */
    List<AuthResource> getResourceList();
}