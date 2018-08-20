package com.byebye.kzj.dao;

import com.byebye.kzj.model.CarInfo;
import com.byebye.kzj.model.CarInfoExample;

import java.util.List;

public interface CarInfoMapper extends BaseMapper<CarInfo, CarInfoExample> {


    List<CarInfo> getAllBrandList();

    List<CarInfo> getSerialListByBrandId(Integer brandId);
}