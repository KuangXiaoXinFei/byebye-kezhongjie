package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.AuthRole;
import com.cloudyoung.baic.model.AuthRoleExample;
import com.cloudyoung.baic.vo.admin.RoleListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthRoleMapper extends BaseMapper<AuthRole, AuthRoleExample> {

    /**
     * Description:获取页面角色列表
     * @version 1.0  2018/7/5 18:17  by  李娜（lina@cloud-young.com）创建
     * @param 
     * @return
     */
    
    List<RoleListVo> getRolePageList();

    /**
     * Description:角色判重
     * @version 1.0  2018/7/5 18:21  by  李娜（lina@cloud-young.com）创建
     * @param 
     * @return
     */
    
    AuthRole isExistRole(@Param("roleName") String roleName, @Param("roleId") Integer roleId);

    /**
     * Description:获取当前角色下配置的资源
     * @version 1.0  2018/7/6 9:55  by  李娜（lina@cloud-young.com）创建
     * @param
     * @return
     */

    RoleListVo getResourceListByRoleId(@Param("roleId") Integer roleId);
}