package com.cloudyoung.baic.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/17 15:24
 */
@Data
@Accessors(chain = true)
public class OilWearCollectVo implements Serializable {

    private String mileage;
    private Integer warSettingNum;
    private Integer ranking;

}
