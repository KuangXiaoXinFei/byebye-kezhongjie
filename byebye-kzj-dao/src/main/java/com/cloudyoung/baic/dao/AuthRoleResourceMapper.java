package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.AuthRoleResource;
import com.cloudyoung.baic.model.AuthRoleResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthRoleResourceMapper extends BaseMapper<AuthRoleResource, AuthRoleResourceExample> {

    int addAuthRoleResource(@Param("list") List<AuthRoleResource> list);

    List<Integer> getRoleResourceByRoleId(@Param("roleId") Integer roleId);

    int deleteByIdList(@Param("ids") List<Integer> ids);
}