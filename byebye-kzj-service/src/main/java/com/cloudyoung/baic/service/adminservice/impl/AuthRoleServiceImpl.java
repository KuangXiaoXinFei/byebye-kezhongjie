package com.cloudyoung.baic.service.adminservice.impl;

import com.cloudyoung.baic.common.utils.PinYinUtil;
import com.cloudyoung.baic.dao.AuthAccountMapper;
import com.cloudyoung.baic.dao.AuthRoleMapper;
import com.cloudyoung.baic.dao.AuthRoleResourceMapper;
import com.cloudyoung.baic.service.adminservice.AuthRoleService;
import com.cloudyoung.baic.model.*;
import com.cloudyoung.baic.vo.admin.RoleListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/4 14:38  by  李娜（lina@cloud-young.com）创建
 */
@Service("authRoleService")
public class AuthRoleServiceImpl implements AuthRoleService {
    @Autowired
    private AuthRoleMapper authRoleMapper;
    @Autowired
    private AuthRoleResourceMapper authRoleResourceMapper;
    @Autowired
    private AuthAccountMapper authAccountMapper;

    @Override
    public PageInfo getRolePageList(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<RoleListVo> list = authRoleMapper.getRolePageList();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public boolean addRole(AuthRole role, List<Integer> authIds) {
        String py = PinYinUtil.getPinyinString(role.getRoleName()).toUpperCase();
        role.setRoleKey(py);
        int i = authRoleMapper.insertSelective(role);
        int j = 0;
        if (i > 0) {
            if (CollectionUtils.isNotEmpty(authIds)) {
                List<AuthRoleResource> list = new ArrayList<>();
                for (Integer integer : authIds) {
                    AuthRoleResource authRoleResource = new AuthRoleResource();
                    authRoleResource.setRoleId(role.getRoleId())
                            .setResourceId(integer);
                    list.add(authRoleResource);
                }
                j = authRoleResourceMapper.addAuthRoleResource(list);
            }

        }
        return i > 0 && j > 0 ? true : false;
    }

    @Override
    public boolean updateRole(Integer roleId, String roleName, List<Integer> authIds) {
        AuthRole role = new AuthRole();
        String py = PinYinUtil.getPinyinString(roleName).toUpperCase();
        role.setRoleId(roleId)
                .setRoleName(roleName)
                .setRoleKey(py)
                .setUpdateTime(new Date());
        int i = authRoleMapper.updateByPrimaryKeySelective(role);
        int j = 0;
        if (i > 0) {
            List<Integer> list = authRoleResourceMapper.getRoleResourceByRoleId(roleId);
            if (CollectionUtils.isNotEmpty(list)) {
                authRoleResourceMapper.deleteByIdList(list);
            }
            List<AuthRoleResource> addList = new ArrayList<>();
            for (Integer resourceId : authIds) {
                AuthRoleResource record = new AuthRoleResource();
                record.setRoleId(roleId)
                        .setResourceId(resourceId);
                addList.add(record);
            }
            j = authRoleResourceMapper.addAuthRoleResource(addList);
        }
        return i > 0 & j > 0 ? true : false;
    }

    @Override
    public List<AuthRole> getRoleList() {
        AuthRoleExample example = new AuthRoleExample();
        AuthRoleExample.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1);
        return authRoleMapper.selectByExample(example);
    }

    @Override
    public Boolean isExistRole(String roleName, Integer roleId) {
        return authRoleMapper.isExistRole(roleName, roleId) != null ? true : false;
    }

    @Override
    public RoleListVo getResourceListByRoleId(Integer roleId) {
        return authRoleMapper.getResourceListByRoleId(roleId);
    }

    @Override
    public boolean deleteRole(Integer roleId) {
        AuthRole role = new AuthRole();
        role.setRoleId(roleId)
                .setIsActive(0)
                .setUpdateTime(new Date());
        //删除角色
        int i = authRoleMapper.updateByPrimaryKey(role);
        //删除角色、资源关系表
        int j = 0;
        if (i > 0) {
            List<Integer> list = authRoleResourceMapper.getRoleResourceByRoleId(roleId);
            if (CollectionUtils.isNotEmpty(list)) {
                j = authRoleResourceMapper.deleteByIdList(list);
            }
        }
        return i > 0 && j > 0 ? true : false;
    }

    @Override
    public List<AuthAccount> getAccountInfoByRoleId(Integer roleId) {
        AuthAccountExample example = new AuthAccountExample();
        AuthAccountExample.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1)
                .andRoleIdEqualTo(roleId);
        return authAccountMapper.selectByExample(example);
    }

}

