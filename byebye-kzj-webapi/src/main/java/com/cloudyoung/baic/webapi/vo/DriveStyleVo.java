package com.cloudyoung.baic.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/10 10:45
 */
@Data
@Accessors(chain =true)
public class DriveStyleVo implements Serializable {

    private String drivingStyle;
    private String drivingDescription;
    private Integer star;
    //急加速
    private Integer quicken;
    //急刹车
    private Integer stop;
    //d
    private Integer swerve;
    //夜间行驶
    private Integer nightDriving;
    //连续加减速
    private Integer continueSpeed;

}
