package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.CarInfo;
import com.cloudyoung.baic.model.CarInfoExample;

import java.util.List;

public interface CarInfoMapper extends BaseMapper<CarInfo, CarInfoExample> {


    List<CarInfo> getAllBrandList();

    List<CarInfo> getSerialListByBrandId(Integer brandId);
}