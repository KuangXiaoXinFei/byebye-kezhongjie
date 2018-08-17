package com.cloudyoung.baic.vo.admin;

import com.cloudyoung.baic.model.PushAlertInfo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/13 15:49  by  李娜（lina@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class PushAlertInfoVo extends PushAlertInfo {
    //    用户名
    private String userName;
    //    手机号
    private String mobile;
    //    告警级别
    private String levelText;
}
