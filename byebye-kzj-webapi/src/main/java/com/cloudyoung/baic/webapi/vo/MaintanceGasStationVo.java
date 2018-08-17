package com.cloudyoung.baic.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/21 14:24
 */
@Data
@Accessors(chain = true)
public class MaintanceGasStationVo implements Serializable {
    private String company;
    private String mileage;
    private String time;
    private List<String> items;

}
