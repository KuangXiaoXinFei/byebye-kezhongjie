package com.cloudyoung.baic.service.adminservice.impl;

import com.cloudyoung.baic.dao.DictionaryInfoMapper;
import com.cloudyoung.baic.model.DictionaryInfo;
import com.cloudyoung.baic.model.DictionaryInfoExample;
import com.cloudyoung.baic.service.adminservice.DictionaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/13 16:37  by  李娜（lina@cloud-young.com）创建
 */
@Service("dictionaryInfoService")
public class DictionaryInfoServiceImpl implements DictionaryInfoService {
    @Autowired
    private DictionaryInfoMapper dictionaryInfoMapper;

    @Override
    public List<DictionaryInfo> getDictionaryInfoByClassId(Integer classId) {
        DictionaryInfoExample example = new DictionaryInfoExample();
        DictionaryInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsActiveEqualTo((byte) 1)
                .andDictionaryClassIdEqualTo(classId);
        return dictionaryInfoMapper.selectByExample(example);
    }
}
