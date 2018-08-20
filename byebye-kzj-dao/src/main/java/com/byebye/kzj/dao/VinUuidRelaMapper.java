package com.byebye.kzj.dao;

import com.byebye.kzj.model.VinUuidRela;
import com.byebye.kzj.model.VinUuidRelaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VinUuidRelaMapper extends BaseMapper<VinUuidRela, VinUuidRelaExample> {
    /**
     * Description:批量新增
     *
     * @param
     * @return
     * @version 1.0  2018/8/2 11:26  by  李娜（lina@cloud-young.com）创建
     */

    int addList(@Param("list") List<VinUuidRela> list);
    /**
     * Description:批量更新
     *
     * @param
     * @return
     * @version 1.0  2018/8/2 11:26  by  李娜（lina@cloud-young.com）创建
     */

    int updateList(@Param("list") List<VinUuidRela> list);

    /**
     * Description:根据vin查询
     * @version 1.0  2018/8/8 16:50  by  李娜（lina@cloud-young.com）创建
     * @param 
     * @return
     */
    
    List<VinUuidRela> selectByVinCode(@Param("vin") String vin);
}