package com.cloudyoung.baic.webapi.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/12 下午2:14
 */
@Data
@Accessors(chain = true)
public class UserLocationPo implements Serializable {
    private Integer userId;
    private Integer source;
    private BigDecimal longitude;
    private BigDecimal latitude;
}
