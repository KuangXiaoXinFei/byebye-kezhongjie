package com.cloudyoung.baic.vo.admin;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/14 15:09
 */
@Data
@Accessors(chain=true)
public class AddBannerVo implements Serializable {

    private Integer adId;
    private String url;
    private Integer weight;
    private Integer status;
    private String description;

}
