package com.cloudyoung.baic.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/13 14:36  by  侯春春（houcc@cloud-young.com）创建
 */
@Data
@Accessors(chain=true)
public class WxUserInfoVo implements Serializable {
    private String nickname;

    private String headimgurl;

    private String sex;
}
