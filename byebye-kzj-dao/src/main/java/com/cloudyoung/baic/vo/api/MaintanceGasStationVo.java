package com.cloudyoung.baic.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
