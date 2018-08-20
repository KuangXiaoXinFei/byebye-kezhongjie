package com.cloudyoung;

import com.byebye.kzj.dao.NewsInfoMapper;
import com.byebye.kzj.service.adminservice.AuthAccountService;
import com.byebye.kzj.service.adminservice.AuthRoleService;
import com.byebye.kzj.model.AuthRole;
import com.byebye.kzj.vo.admin.NewsInfoVo;
import com.byebye.kzj.vo.admin.ResourceVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/5 10:40  by  李娜（lina@cloud-young.com）创建
 */
public class RoleTest extends BaseTest {
    @Autowired
    private AuthRoleService authRoleService;
    @Autowired
    private AuthAccountService authAccountService;

    @Autowired
    private NewsInfoMapper newsInfoMapper;

    @Test
    public void getRole() {
        List<AuthRole> list = authRoleService.getRoleList();
        System.out.println(list);
    }

    @Test
    public void getResource() {
        List<ResourceVo> list = authAccountService.getResourceListByAccountName("admin");
        System.out.println(list);
    }

    @Test
    public void mapKeyTest() {
        Map<Integer, NewsInfoVo> list = newsInfoMapper.getListByQuery();
        System.out.println(list);
    }
}
