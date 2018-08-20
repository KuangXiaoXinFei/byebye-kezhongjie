package com.byebye.kzj.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/21 下午4:25
 */
@Data
@Accessors(chain = true)
public class UserCarVo implements Serializable {
    private String vinCode;

    private String carName;

    private String[] imageList;
}
