package com.byebye.kzj.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/19 下午3:11
 */
@Data
@Accessors(chain = true)
public class TestDriveCarVo implements Serializable {
    private Integer carId;
    private String brandName;
    private String serialName;
    private String styleName;
    private String year;
    private String carInfo;
    private String whiteCoverImage;
    private String clarityImage;
    private String referPrice;
}
