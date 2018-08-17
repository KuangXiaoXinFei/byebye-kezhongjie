package com.cloudyoung.baic.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/6 下午2:24
 */
@Data
@Accessors(chain = true)
public class AuthAccountVo {
    /**
     * 账户Id
     */
    private String accountId;
    /**
     * 用户名
     */
    private String accountName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 是否超管 1是 0否
     */
    private Integer isAdmin;
}
