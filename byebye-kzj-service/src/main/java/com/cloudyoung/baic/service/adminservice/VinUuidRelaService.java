package com.cloudyoung.baic.service.adminservice;

import com.cloudyoung.baic.model.VinUuidRela;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/2 11:25  by  李娜（lina@cloud-young.com）创建
 */
public interface VinUuidRelaService {
    /**
     * Description:批量新增
     *
     * @param
     * @return
     * @version 1.0  2018/8/2 11:26  by  李娜（lina@cloud-young.com）创建
     */

    int addList(List<VinUuidRela> list);

    /**
     * Description:判断当前vin是否存在
     * @version 1.0  2018/8/2 16:27  by  李娜（lina@cloud-young.com）创建
     * @param 
     * @return
     */

    VinUuidRela isExistVin(String vin);
    /**
     * Description:批量更新
     *
     * @param
     * @return
     * @version 1.0  2018/8/2 11:26  by  李娜（lina@cloud-young.com）创建
     */

    int updateList(List<VinUuidRela> list);
}
