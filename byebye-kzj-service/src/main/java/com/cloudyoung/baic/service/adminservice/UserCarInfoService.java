package com.cloudyoung.baic.service.adminservice;

import com.cloudyoung.baic.model.UserCarInfo;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/16 11:54  by  侯春春（houcc@cloud-young.com）创建
 */
public interface UserCarInfoService {
    UserCarInfo getByVinCode(String vinCode);
}
