package com.byebye.kzj.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/20 上午10:35
 */
@Data
@Accessors(chain = true)
public class DealerInfoVo implements Serializable {

    private Integer dealerId;

    private String dealerName;

    private String dealerCode;

    private String address;

    private String serviceCall;

    private String saleCall;

    private String helpCall;

    private String longitude;

    private String latitude;
}
