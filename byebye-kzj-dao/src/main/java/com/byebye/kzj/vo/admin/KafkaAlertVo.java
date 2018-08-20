package com.byebye.kzj.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/16 11:43  by  侯春春（houcc@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class KafkaAlertVo  implements Serializable {
    private String TYPE;

    private String vin;

    private Integer fltlvl;

    private Long nowDate;

    private String textContent;

    private String title;

    private String voiceContent;
}
