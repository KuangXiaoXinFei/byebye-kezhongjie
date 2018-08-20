package com.byebye.kzj.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/8/4 18:58
 */
@Data
@Accessors(chain = true)
public class PowerSysDetailVo implements Serializable {

    private String powerName;
    private Integer powerId;
    private Integer firLvl;
    private Integer problemNum;
    private List<Map<String, String>> seriousProblems;
}
