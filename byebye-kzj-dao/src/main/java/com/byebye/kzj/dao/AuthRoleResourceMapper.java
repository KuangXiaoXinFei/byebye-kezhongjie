package com.byebye.kzj.dao;

import com.byebye.kzj.model.AuthRoleResource;
import com.byebye.kzj.model.AuthRoleResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthRoleResourceMapper extends BaseMapper<AuthRoleResource, AuthRoleResourceExample> {

    int addAuthRoleResource(@Param("list") List<AuthRoleResource> list);

    List<Integer> getRoleResourceByRoleId(@Param("roleId") Integer roleId);

    int deleteByIdList(@Param("ids") List<Integer> ids);
}