package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/8/3 下午2:43
 */
@Data
@Accessors(chain = true)
public class CityInfoVo implements Serializable {
    private String key;
    private List<CityVo> value;
}
