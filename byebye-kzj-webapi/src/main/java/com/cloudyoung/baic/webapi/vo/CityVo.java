package com.cloudyoung.baic.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/8/3 上午11:48
 */
@Data
@Accessors(chain = true)
public class CityVo implements Serializable {
    private Integer cityId;

    private Integer cityCode;

    private String cityName;

    private Integer provinceId;

    private String provinceName;

    private String fistChar;

    /**
     * 1是直辖市 0不是
     */
    private Integer cityType;
}
