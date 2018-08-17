package com.cloudyoung.baic.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/9 17:04
 */
@Data
@Accessors(chain = true)
public class OilWearInfoVo implements Serializable {
    //行驶油耗
    private String driveUser;
    //激烈驾驶油耗
    private String otherUse;
    //空调油耗
    private String acUse;
    //怠速油耗
    private String idleUse;
}
