package com.byebye.kzj.service.adminservice;

import com.byebye.kzj.model.AuthAccount;
import com.byebye.kzj.service.BaseService;
import com.byebye.kzj.vo.admin.AuthAccountQueryVo;
import com.byebye.kzj.vo.admin.ResourceVo;
import com.byebye.kzj.model.AuthAccountExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/5 下午5:46
 */
public interface AuthAccountService extends BaseService<AuthAccount, AuthAccountExample> {
    /**
     * 获取账户分页列表
     *
     * @param vo
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo getAuthAccountListByQuery(AuthAccountQueryVo vo, Integer pageNumber, Integer pageSize);

    /**
     * Description:获取账号信息
     *
     * @param
     * @return
     * @version 1.0  2018/7/6 16:46  by  李娜（lina@cloud-young.com）创建
     */

    AuthAccount getAccountByName(String name);

    /**
     * Description:获取当前账号下的资源
     *
     * @param
     * @return
     * @version 1.0  2018/7/6 15:41  by  李娜（lina@cloud-young.com）创建
     */

    List<ResourceVo> getResourceListByAccountName(String name);

    /**
     * 查询是否已存在用户名、手机号
     *
     * @param accountId
     * @param value
     * @param type  1用户名  2手机号
     * @return
     */
    boolean isRepeatAccount(Integer accountId, String value, Integer type);
}
