package com.cloudyoung.baic.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/18 15:48
 */
@Data
@Accessors(chain = true)
public class MaintanceDetailVo implements Serializable {

    private Integer code;
    private String title;
    private String mileage;
    private String content;
    private String baike;
}
