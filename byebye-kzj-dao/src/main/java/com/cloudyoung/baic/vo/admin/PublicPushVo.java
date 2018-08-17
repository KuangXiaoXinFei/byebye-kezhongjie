package com.cloudyoung.baic.vo.admin;

import com.cloudyoung.baic.model.PublicPush;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/9 11:53  by  李娜（lina@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class PublicPushVo extends PublicPush {
    //创建日期 开始
    private String minCreateTime;
    //创建日期 截至
    private String maxCreateTime;
}
