package com.byebye.kzj.service.adminservice.impl;

import com.byebye.kzj.common.utils.DateUtil;
import com.byebye.kzj.dao.PublicPushMapper;
import com.byebye.kzj.model.PublicPush;
import com.byebye.kzj.service.adminservice.PublicPushService;
import com.byebye.kzj.vo.admin.PublicPushVo;
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
 * @version 1.0  2018/7/9 14:39  by  李娜（lina@cloud-young.com）创建
 */
@Service("publicPushService")
public class PublicPushServiceImpl implements PublicPushService {
    @Autowired
    PublicPushMapper publicPushMapper;

    @Override
    public PageInfo getPushPageList(PublicPushVo query, Integer pageIndex, Integer pageSize) {
        if (query != null) {
            if (query.getMinCreateTime() != null) {
                Date start = DateUtil.toDate(query.getMinCreateTime(), DateUtil.LONG_DATE_FORMAT);
                query.setMinCreateTime(DateUtil.formatDateTime(start, DateUtil.FORMAT_ONE));
            }
            if (query.getMaxCreateTime() != null) {
                Date end = DateUtil.toDate(query.getMaxCreateTime() + " 23:59:59", DateUtil.FORMAT_ONE);
                query.setMaxCreateTime(DateUtil.formatDateTime(end, DateUtil.FORMAT_ONE));
            }
        }
        PageHelper.startPage(pageIndex, pageSize);
        List<PublicPush> list = publicPushMapper.getPageList(query);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public boolean insert(PublicPush publicPush) {
        return publicPushMapper.insert(publicPush) > 0 ? true : false;
    }
}
