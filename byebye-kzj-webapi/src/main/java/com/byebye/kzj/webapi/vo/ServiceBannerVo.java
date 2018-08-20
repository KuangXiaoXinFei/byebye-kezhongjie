package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/11 下午4:01
 */
@Data
@Accessors(chain = true)
public class ServiceBannerVo {
    private Integer serviceId;

    private String title;

    private String url;

    private String imagePath;

    private String extend;

    private Integer type;
}
