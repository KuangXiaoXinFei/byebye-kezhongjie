package com.cloudyoung.baic.service.adminservice.impl;

import com.cloudyoung.baic.dao.VinUuidRelaMapper;
import com.cloudyoung.baic.service.adminservice.VinUuidRelaService;
import com.cloudyoung.baic.model.VinUuidRela;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/2 11:26  by  李娜（lina@cloud-young.com）创建
 */
@Service("vinUuidRelaService")
public class VinUuidRelaServiceImpl implements VinUuidRelaService {
    @Autowired
    private VinUuidRelaMapper vinUuidRelaMapper;

    @Override
    public int addList(List<VinUuidRela> list) {
        return vinUuidRelaMapper.addList(list);
    }

    @Override
    public VinUuidRela isExistVin(String vin) {
        List<VinUuidRela> list = vinUuidRelaMapper.selectByVinCode(vin);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public int updateList(List<VinUuidRela> list) {
        return vinUuidRelaMapper.updateList(list);
    }
}
