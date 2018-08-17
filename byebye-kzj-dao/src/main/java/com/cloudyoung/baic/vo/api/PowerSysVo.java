package com.cloudyoung.baic.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/12 16:08
 */
@Data
@Accessors(chain =true)
public class PowerSysVo implements Serializable {
    private String powerMark;
    private String desciption;
    private BatteryInfoVo battery;
    private List<PowerSysDetailVo> list;
}
