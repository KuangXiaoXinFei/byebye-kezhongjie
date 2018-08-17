package com.cloudyoung.baic.service.adminservice.impl;

import com.cloudyoung.baic.common.utils.DateUtil;
import com.cloudyoung.baic.dao.UserInfoMapper;
import com.cloudyoung.baic.service.adminservice.UserService;
import com.cloudyoung.baic.model.UserInfo;
import com.cloudyoung.baic.model.UserInfoExample;
import com.cloudyoung.baic.vo.admin.UserQueryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/13 上午10:27
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserInfo, UserInfoExample> implements UserService {
    @Autowired
    private UserInfoMapper mapper;

    @Override
    public PageInfo getUserListByQuery(UserQueryVo vo, Integer pageIndex, Integer pageSize) {
        if (!StringUtils.isEmpty(vo.getStartTime())) {
            Date start = DateUtil.toDate(vo.getStartTime(), DateUtil.LONG_DATE_FORMAT);
            vo.setStartTime(DateUtil.formatDateTime(start, DateUtil.FORMAT_ONE));
        }
        if (!StringUtils.isEmpty(vo.getEndTime())) {
            Date end = DateUtil.toDate(vo.getEndTime() + " 23:59:59", DateUtil.FORMAT_ONE);
            vo.setEndTime(DateUtil.formatDateTime(end, DateUtil.FORMAT_ONE));
        }

        PageHelper.startPage(pageIndex, pageSize);
        List<UserInfo> userInfoList = mapper.getUserListByQuery(vo);
        PageInfo<UserInfo> pageInfo = new PageInfo(userInfoList);
        return pageInfo;
    }


    @Override
    public boolean isRepeatUser(String value, Integer type) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        if (type == 1) {
            criteria.andUserNameEqualTo(value);
        } else {
            criteria.andMobileEqualTo(value);
        }
        criteria.andIsActiveEqualTo(1);
        List<UserInfo> list = mapper.selectByExample(example);
        return list != null && list.size() > 0;
    }
}
