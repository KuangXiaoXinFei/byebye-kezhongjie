package com.cloudyoung.baic.webapi.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/7 12:48
 */
@Data
@Accessors(chain=true)
public class TrobuleHistoryContentPo {
    private String vin;
    private String pCode;
    private Date timeHapRec;
    private Date timeHealRec;
    private String fltlvl;
    private boolean flthis;
    private boolean fltdlt;
    private String title;

}
