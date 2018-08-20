package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/7 15:50
 */
@Data
@Accessors(chain=true)
public class TroubleHistoryListVo implements Serializable {

    private String pCode;

    private String title;
    //故障发生时间
    private String hapRecTime;
    //故障维护时间
    private String healRecTime;
    //故障等级
    private String fltLevel;
    //是否修复
    private Boolean isRepair;
    //是否是现存故障
    private Boolean isTrouble;

}
