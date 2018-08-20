package com.byebye.kzj.service.adminservice.impl;

import com.byebye.kzj.dao.AuthResourceMapper;
import com.byebye.kzj.model.AuthResource;
import com.byebye.kzj.service.adminservice.AuthResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/5 14:52  by  李娜（lina@cloud-young.com）创建
 */
@Service("authResourceService")
public class AuthResourceServiceImpl implements AuthResourceService {

    @Autowired
    private AuthResourceMapper authResourceMapper;

    @Override
    public List<AuthResource> getResourceList() {
        return authResourceMapper.getResourceList();
    }

}
