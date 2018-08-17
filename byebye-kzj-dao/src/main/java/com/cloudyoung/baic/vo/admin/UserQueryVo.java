package com.cloudyoung.baic.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/13 上午10:41
 */
@Data
@Accessors(chain = true)
public class UserQueryVo implements Serializable {
    private Integer userId;

    private String userName;

    private Integer isTalk;

    private Integer userType;

    private String startTime;

    private String endTime;
}
