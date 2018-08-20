package com.byebye.kzj.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/18 15:44
 */
@Data
@Accessors(chain = true)
public class MaintanceVo implements Serializable {
    //剩余里程数
    private String mileage;
    private List<MaintanceDetailVo> list;
}
