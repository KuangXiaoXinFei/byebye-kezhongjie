package com.cloudyoung.baic.service.adminservice;

import com.cloudyoung.baic.model.UserInfo;
import com.cloudyoung.baic.model.UserInfoExample;
import com.cloudyoung.baic.service.BaseService;
import com.cloudyoung.baic.vo.admin.UserQueryVo;
import com.github.pagehelper.PageInfo;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/13 上午10:27
 */
public interface UserService extends BaseService<UserInfo, UserInfoExample> {

    PageInfo getUserListByQuery(UserQueryVo vo, Integer pageIndex, Integer pageSize);

    /**
     * 查询是否已存在用户名、手机号
     *
     * @param value
     * @param type  1用户名  2手机号
     * @return
     */
    boolean isRepeatUser(String value, Integer type);
}
