package com.byebye.kzj.service.adminservice;

import com.byebye.kzj.model.UserInfo;
import com.byebye.kzj.model.UserInfoExample;
import com.byebye.kzj.service.BaseService;
import com.byebye.kzj.vo.admin.UserQueryVo;
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
