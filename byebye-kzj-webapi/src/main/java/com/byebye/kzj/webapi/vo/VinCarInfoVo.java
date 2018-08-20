package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/8/2 10:54
 */
@Data
@Accessors(chain=true)
public class VinCarInfoVo  implements Serializable {

    private String carImage;
    private String carName;
    private String colorName;
    private Integer colorId;
    private String enginerCode;
    private String uuid;
    private Integer serialId;

}
