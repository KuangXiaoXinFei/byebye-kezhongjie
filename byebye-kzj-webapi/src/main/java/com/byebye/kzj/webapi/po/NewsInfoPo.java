package com.byebye.kzj.webapi.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 1.0 刘风栓
 */
@Data
@Accessors(chain=true)
public class NewsInfoPo implements Serializable {

    private Integer newsId;

    private String title;

    private Integer newsType;

    private Integer userId;
    //资讯内容
    private String newsContent;
}
