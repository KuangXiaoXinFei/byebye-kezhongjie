package com.cloudyoung.baic.service.adminservice.impl;

import com.cloudyoung.baic.dao.UserCarInfoMapper;
import com.cloudyoung.baic.service.adminservice.UserCarInfoService;
import com.cloudyoung.baic.model.UserCarInfo;
import com.cloudyoung.baic.model.UserCarInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/16 11:55  by  侯春春（houcc@cloud-young.com）创建
 */
@Service("userCarInfoService")
public class UserCarInfoServiceImpl implements UserCarInfoService {
    @Autowired
    private UserCarInfoMapper userCarInfoMapper;

    @Override
    public UserCarInfo getByVinCode(String vinCode) {
        UserCarInfoExample example = new UserCarInfoExample();
        UserCarInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo(1);
        criteria.andVinCodeEqualTo(vinCode);
        List<UserCarInfo> list = userCarInfoMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
