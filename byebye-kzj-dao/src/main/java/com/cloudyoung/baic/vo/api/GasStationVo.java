package com.cloudyoung.baic.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/20 下午6:06
 */
@Data
@Accessors(chain = true)
public class GasStationVo implements Serializable {

    private String name;

    private String address;

    /**
     * 距离(米)
     */
    private Integer distance;

    /**
     * 时间(分钟)
     */
    private Integer duration;

    private Integer rate;

    /**
     * 加油时间
     */
    private String fillTime;

    /**
     *品牌
     */
    private String brand;

    private String longitude;

    private String latitude;
}
