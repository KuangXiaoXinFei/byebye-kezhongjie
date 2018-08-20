package com.byebye.kzj.service.adminservice;

import com.byebye.kzj.model.AuthAccount;
import com.byebye.kzj.model.AuthRole;
import com.byebye.kzj.vo.admin.RoleListVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/4 14:38  by  李娜（lina@cloud-young.com）创建
 */
public interface AuthRoleService {
    /**
     * Description:获取列表数据
     *
     * @param
     * @return
     * @version 1.0  2018/7/4 14:49  by  李娜（lina@cloud-young.com）创建
     */

    PageInfo getRolePageList(Integer pageIndex, Integer pageSize);

    /**
     * Description:添加角色信息
     *
     * @param
     * @return
     * @version 1.0  2018/7/4 14:50  by  李娜（lina@cloud-young.com）创建
     */
    boolean addRole(AuthRole role, List<Integer> authIds);

    /**
     * Description:更新角色信息
     *
     * @param
     * @return
     * @version 1.0  2018/7/4 14:52  by  李娜（lina@cloud-young.com）创建
     */

    boolean updateRole(Integer roleId, String roleName, List<Integer> authIds);

    /**
     * Description:获取角色列表
     *
     * @param
     * @return
     * @version 1.0  2018/7/4 15:00  by  李娜（lina@cloud-young.com）创建
     */

    List<AuthRole> getRoleList();

    /**
     * Description:角色判重
     *
     * @param
     * @return
     * @version 1.0  2018/7/5 18:21  by  李娜（lina@cloud-young.com）创建
     */

    Boolean isExistRole(String roleName, Integer roleId);

    /**
     * Description:获取当前角色下配置的资源
     *
     * @param
     * @return
     * @version 1.0  2018/7/6 9:55  by  李娜（lina@cloud-young.com）创建
     */

    RoleListVo getResourceListByRoleId(Integer roleId);

    /**
     * Description:删除角色
     *
     * @param
     * @return
     * @version 1.0  2018/7/6 12:32  by  李娜（lina@cloud-young.com）创建
     */

    boolean deleteRole(Integer roleId);

    /**
     * Description:获取当前角色下绑定的用户
     *
     * @param
     * @return
     * @version 1.0  2018/7/6 14:26  by  李娜（lina@cloud-young.com）创建
     */

    List<AuthAccount> getAccountInfoByRoleId(Integer roleId);

}
