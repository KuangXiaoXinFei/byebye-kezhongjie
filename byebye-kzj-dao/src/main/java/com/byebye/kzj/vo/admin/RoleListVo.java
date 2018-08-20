package com.byebye.kzj.vo.admin;


import com.byebye.kzj.model.AuthResource;
import com.byebye.kzj.model.AuthRole;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/4 14:45  by  李娜（lina@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class RoleListVo extends AuthRole {

    /*角色对应的权限内容文本*/
    private String authContent;
    /*角色对应的权限列表*/
    private List<AuthResource> authList;
}
