package com.cloudyoung.baic.service.adminservice.impl;

import com.cloudyoung.baic.dao.CarInfoMapper;
import com.cloudyoung.baic.service.adminservice.CarInfoService;
import com.cloudyoung.baic.model.CarInfo;
import com.cloudyoung.baic.model.CarInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/19 下午3:02
 */
@Service("carInfoService")
public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    private CarInfoMapper carInfoMapper;

    @Override
    public List<CarInfo> getCarList() {
        CarInfoExample example = new CarInfoExample();
        CarInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1);
        return carInfoMapper.selectByExample(example);
    }

    @Override
    public List<CarInfo> getAllBrandList() {
        return carInfoMapper.getAllBrandList();
    }

    @Override
    public List<CarInfo> getSerialListByBrandId(Integer brandId) {
        return carInfoMapper.getSerialListByBrandId(brandId);
    }
}
