package com.byebye.kzj.service.adminservice;

import com.byebye.kzj.model.CarInfo;

import java.util.List;

/**
 * CarInfo
 */
public interface CarInfoService {

    List<CarInfo> getCarList();

    /**
     * 获取所有品牌
     *
     * @return CarInfo集合
     * @author 2018-07-19 by 刘风栓
     */
    List<CarInfo> getAllBrandList();

    /**
     * 根据品牌获取所有车系
     *
     * @return CarInfo集合
     * @author 2018-07-19 by 刘风栓
     */
    List<CarInfo> getSerialListByBrandId(Integer brandId);
}
