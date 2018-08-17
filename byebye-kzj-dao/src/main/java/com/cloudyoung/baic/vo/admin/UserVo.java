package com.cloudyoung.baic.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/18 下午2:56
 */
@Data
@Accessors(chain = true)
public class UserVo implements Serializable {
    private Integer userId;
    private String userName;
    private Integer sex;
    private String avatar;
    private Date createTime;
    private Integer isTalk;
    private Integer userType;
    private Integer isValidate;
    private String realName;
    private String idCode;
    private String vinCode;
    private Integer articleCount;
}
