package com.byebye.kzj.webapi.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/18 下午12:19
 */
@Data
@Accessors(chain = true)
public class UserCarPo implements Serializable {
    private String vinCode;
    private String carCode;
    private String carInfo;
    private Integer colorId;
    private String colorName;
    private String coverUrl;
    private String engineNum;
    private String realName;
    private String uuid;
}
