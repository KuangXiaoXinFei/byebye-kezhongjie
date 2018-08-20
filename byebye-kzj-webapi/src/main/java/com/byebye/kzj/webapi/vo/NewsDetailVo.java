package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 资讯详情
 *
 * @author 1.0 刘风栓
 */
@Data
@Accessors(chain = true)
public class NewsDetailVo extends NewsListVo  implements Serializable {

    public NewsDetailVo() {
        newsContent = "";
    }

    private Integer status;

    //资讯内容
    private String newsContent;

}
