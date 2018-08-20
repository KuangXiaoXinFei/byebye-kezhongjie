package com.byebye.kzj.webapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/20 12:21
 */
@Data
@Accessors(chain = true)
public class UserVinCarInfoVo implements Serializable {

    private String carImage;
    private String carCode;
    private String carName;
    private String enginerCode;


}
