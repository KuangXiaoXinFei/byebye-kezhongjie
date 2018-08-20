package com.byebye.kzj.vo.admin;

import com.byebye.kzj.model.NewsInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 1.0 刘风栓
 */
@Data
@Accessors(chain = true)
public class NewsInfoVo extends NewsInfo implements Serializable {

    private String userName;
    //关联车系个数
    private Integer serialCount;
}
