package com.cloudyoung.baic.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/13 15:43  by  李娜（lina@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class PushAlertQueryVo implements Serializable {
    //    警告id
    private Integer pushId;
    //    警告级别
    private Integer level;
    //    vin码
    private String vin;
    //    用户名
    private String userName;
    //    手机号
    private String mobile;
    //    创建时间
    private String minCreateTime;
    private String maxCreateTime;
    //    发生时间
    private String minOccurTime;
    private String maxOccurTime;
}
