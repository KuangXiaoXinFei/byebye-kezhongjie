package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.BannerInfo;
import com.cloudyoung.baic.model.BannerInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerInfoMapper extends BaseMapper<BannerInfo, BannerInfoExample> {

    /**
     * @Descpription: 轮播图查询
     * @author    李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/10 15:40
     * @param
     * @return
     */
    List<BannerInfo> selectSearchByParam(@Param("status") Integer status, @Param("beginTime") String BeginTime, @Param("endTime") String EndTime);


}