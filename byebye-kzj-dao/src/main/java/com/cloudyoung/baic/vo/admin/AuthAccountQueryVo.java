package com.cloudyoung.baic.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/5 下午5:54
 */
@Data
@Accessors(chain = true)
public class AuthAccountQueryVo implements Serializable {
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

}
