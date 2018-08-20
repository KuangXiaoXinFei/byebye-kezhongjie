package com.byebye.kzj.service.adminservice.impl;

import com.byebye.kzj.common.utils.DateUtil;
import com.byebye.kzj.common.utils.StringUtils;
import com.byebye.kzj.dao.BannerInfoMapper;
import com.byebye.kzj.model.BannerInfo;
import com.byebye.kzj.service.adminservice.AdImagesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/10 14:19
 */
@Service
public class AdImagesServiceImpl implements AdImagesService {

    @Autowired
    private BannerInfoMapper mapper;

    /**
     * @param
     * @return
     * @Descpription: 添加数据接口
     * @author 李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/10 14:25
     */
    @Override
    public Integer insertData(BannerInfo model) {
        return mapper.insert(model);
    }

    /**
     * @param
     * @return
     * @Descpription: 更新数据操作
     * @author 李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/10 14:29
     */
    @Override
    public Integer updateData(BannerInfo model) {
        return mapper.updateByPrimaryKeySelective(model);
    }

    /**
     * @param
     * @return
     * @Descpription:
     * @author 李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/16 15:56
     */
    @Override
    public Integer deleteByPrimaryKey(Integer adId) {
        return mapper.deleteByPrimaryKey(adId);
    }


    /**
     * @param
     * @return
     * @Descpription:
     * @author 李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/10 15:45
     */
    @Override
    public PageInfo<BannerInfo> getSearch(Integer status, String beginTime, String endTime, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        if (!StringUtils.isEmpty(beginTime)) {
            Date start = DateUtil.toDate(beginTime, DateUtil.LONG_DATE_FORMAT);
            beginTime = DateUtil.formatDateTime(start, DateUtil.FORMAT_ONE);
        }
        if (!StringUtils.isEmpty(endTime)) {
            Date end = DateUtil.toDate(endTime + " 23:59:59", DateUtil.FORMAT_ONE);
            endTime = DateUtil.formatDateTime(end, DateUtil.FORMAT_ONE);
        }
        List<BannerInfo> list = mapper.selectSearchByParam(status, beginTime, endTime);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * @param
     * @return
     * @Descpription:
     * @author 李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/14 10:57
     */
    @Override
    public BannerInfo getDetailById(Integer adId) {
        return mapper.selectByPrimaryKey(adId);
    }


}
