package com.cloudyoung.baic.vo.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/20 下午6:25
 */
@Data
@Accessors(chain = true)
public class DictionaryVo implements Serializable {
    private Integer ids;

    private Integer dictionaryId;

    private String dictionaryName;

    private Integer dictionaryClassId;

    private Short orderNum;
}
