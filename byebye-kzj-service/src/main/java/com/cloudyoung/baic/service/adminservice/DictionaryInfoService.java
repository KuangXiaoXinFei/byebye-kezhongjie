package com.cloudyoung.baic.service.adminservice;

import com.cloudyoung.baic.model.DictionaryInfo;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/13 16:35  by  李娜（lina@cloud-young.com）创建
 */
public interface DictionaryInfoService {
    /**
     * Description:根据dictionaryClassId获取DictionaryInfo
     * @version 1.0  2018/7/13 16:36  by  李娜（lina@cloud-young.com）创建
     * @param 
     * @return
     */
    
    List<DictionaryInfo> getDictionaryInfoByClassId(Integer classId);
}
