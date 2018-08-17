package com.cloudyoung.baic.webapi.vo;

import com.cloudyoung.baic.common.utils.DateUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/14 14:11  by  李娜（lina@cloud-young.com）创建
 */
@Data
@Accessors(chain = true)
public class PushListVo implements Serializable {
    //    消息标题
    private String title;
    //    消息内容
    private String content;
    //    消息类型
    private Integer type;
    //    消息创建时间
    private String createTime;

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
        Date date = DateUtil.toDate(createTime, "yyyy-MM-dd HH:mm:ss");
        String time = DateUtil.formatDateTime(date, "yyyy-MM-dd HH:mm:ss");
        this.createTime = time;
    }

}
