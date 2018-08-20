package com.byebye.kzj.service.adminservice;

import com.byebye.kzj.model.BannerInfo;
import com.github.pagehelper.PageInfo;


/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/10 14:19
 */
public interface AdImagesService {

    Integer insertData(BannerInfo model);

    Integer updateData(BannerInfo model);

    Integer deleteByPrimaryKey(Integer adId);

    PageInfo<BannerInfo> getSearch(Integer status, String beginTime, String endTime, Integer pageIndex, Integer pageSize);

    BannerInfo getDetailById(Integer adId);

}
