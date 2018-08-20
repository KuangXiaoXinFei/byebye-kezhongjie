package com.byebye.kzj.dao;

import com.byebye.kzj.model.UserInfo;
import com.byebye.kzj.model.UserInfoExample;
import com.byebye.kzj.vo.admin.UserQueryVo;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo, UserInfoExample> {
    List<UserInfo> getUserListByQuery(UserQueryVo vo);
}