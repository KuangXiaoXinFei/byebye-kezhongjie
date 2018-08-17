package com.cloudyoung.baic.service.adminservice.impl;

import com.cloudyoung.baic.dao.PushAlertInfoMapper;
import com.cloudyoung.baic.model.PushAlertInfo;
import com.cloudyoung.baic.service.adminservice.PushAlertService;
import com.cloudyoung.baic.vo.admin.PushAlertInfoVo;
import com.cloudyoung.baic.vo.admin.PushAlertQueryVo;
import com.cloudyoung.baic.common.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/13 14:42  by  李娜（lina@cloud-young.com）创建
 */
@Service("pushAlertService")
public class PushAlertServiceImpl implements PushAlertService {
    @Autowired
    private PushAlertInfoMapper pushAlertInfoMapper;
    @Override
    public PageInfo getPageList(PushAlertQueryVo query, Integer pageIndex, Integer pageSize) {
        if(query!=null){
            if(query.getMinCreateTime() !=null){
                Date start = DateUtil.toDate(query.getMinCreateTime(), DateUtil.LONG_DATE_FORMAT);
                query.setMinCreateTime(DateUtil.formatDateTime(start, DateUtil.FORMAT_ONE));
            }
            if (query.getMaxCreateTime() != null) {
                Date end = DateUtil.toDate(query.getMaxCreateTime() + " 23:59:59", DateUtil.FORMAT_ONE);
                query.setMaxCreateTime(DateUtil.formatDateTime(end, DateUtil.FORMAT_ONE));
            }
            if(query.getMinOccurTime() !=null){
                Date start = DateUtil.toDate(query.getMinOccurTime(), DateUtil.LONG_DATE_FORMAT);
                query.setMinOccurTime(DateUtil.formatDateTime(start, DateUtil.FORMAT_ONE));
            }
            if (query.getMaxOccurTime() != null) {
                Date end = DateUtil.toDate(query.getMaxOccurTime() + " 23:59:59", DateUtil.FORMAT_ONE);
                query.setMaxOccurTime(DateUtil.formatDateTime(end, DateUtil.FORMAT_ONE));
            }
        }
        PageHelper.startPage(pageIndex,pageSize);
        List<PushAlertInfoVo> list = pushAlertInfoMapper.getPageList(query);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int add(PushAlertInfo info) {
        return pushAlertInfoMapper.insert(info);
    }
}
