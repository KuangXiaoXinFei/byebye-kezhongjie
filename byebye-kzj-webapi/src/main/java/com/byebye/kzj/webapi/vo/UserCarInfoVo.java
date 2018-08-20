package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/20 下午2:31
 */
@Data
@Accessors(chain = true)
public class UserCarInfoVo implements Serializable {
    private String carInfo;

    private String carCode;

    private String engineNum;

    private String vinCode;

    private String imageUrl;
}
