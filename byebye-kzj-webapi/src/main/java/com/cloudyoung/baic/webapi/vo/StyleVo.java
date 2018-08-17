package com.cloudyoung.baic.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/23 下午3:16
 */
@Data
@Accessors(chain = true)
public class StyleVo implements Serializable {

    private Integer carId;

    private String styleName;

    private Integer brandId;

    private String brandName;

    private Integer serialId;

    private String serialName;

    private String referPrice;

    private Integer year;

    private String whiteCoverImage;

    private String clarityImage;

    private String carInfo;
}
