package com.byebye.kzj.webapi.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/19 下午7:42
 */
@Data
@Accessors(chain = true)
public class TestDrivePo implements Serializable {
    private Integer carId;
    private String carName;
    private String userName;
    private String mobile;
    private Integer sex;
    private String dealerIds;
}
