package com.byebye.kzj.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/13 上午11:22
 */
@Data
@Accessors(chain = true)
public class UserParamsVo  implements Serializable {
    private Integer userId;

    private String userName;

    private String mobile;

    private Integer sex;

    private String avatar;
}
