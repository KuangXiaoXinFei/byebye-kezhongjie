package com.byebye.kzj.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 1.0 刘风栓
 */
@Data
@Accessors(chain = true)
public class NewsListQueryVo implements Serializable {

    //品牌
    private Integer brandId;

    //车系
    private Integer serialId;

    //资讯Id
    private Long newsId;
    //资讯标题
    private String newsTitle;
    //作者
    private String userName;
    //作者Id
    private Long userId;
    //资讯类型
    private Integer newsType;
    //资讯状态
    private Integer status;

    //1.官方 2.用户
    private Integer source;

    //创建日期 开始
    private String minCreateTime;
    //创建日期 截至
    private String maxCreateTime;
}
