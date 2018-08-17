package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.UserInfo;
import com.cloudyoung.baic.model.UserInfoExample;
import com.cloudyoung.baic.vo.admin.UserQueryVo;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo, UserInfoExample> {
    List<UserInfo> getUserListByQuery(UserQueryVo vo);
}