package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/31 上午11:07
 */
@Data
@Accessors(chain = true)
public class CarCoordinateVo implements Serializable {
    private String longitude;

    private String latitude;
}
