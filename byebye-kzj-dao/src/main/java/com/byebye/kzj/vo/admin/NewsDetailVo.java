package com.byebye.kzj.vo.admin;

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
public class NewsDetailVo implements Serializable {

    private Integer newsId;

    private String title;

    //资讯内容
    private String newsContent;

    private Integer status;

}
