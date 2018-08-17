package com.cloudyoung.baic.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/9 12:22
 */
@Data
@Accessors(chain = true)
public class BatteryInfoVo implements Serializable {
    private Boolean status;
    private Boolean health;
}
