package com.byebye.kzj.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/2 10:49  by  李娜（lina@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class KafkaGuFenItVo implements Serializable {
    //    车机id采集日期
    private String zcreate;
    //    发动机排量
    private String zengineDisplacement;
    //    发动机功率
    private String zenginePower;
    //    发动机型号
    private String zengineType;
    //    车机id
    private String zhum;
    //    发动机号
    private String zkcfdjh;
    //    整车编码
    private String zmatId;
    //    整车物料号名称
    private String zmodName;
    //    平台编号
    private String zmodNo;
    //    平台名称
    private String zname;
    //    变速箱号
    private String ztransCo;
    //    vin
    private String zxsvinm;
}
