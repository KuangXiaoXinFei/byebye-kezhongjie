package com.byebye.kzj.service.adminservice.impl;

import com.byebye.kzj.dao.AuthAccountMapper;
import com.byebye.kzj.model.AuthAccount;
import com.byebye.kzj.model.AuthAccountExample;
import com.byebye.kzj.vo.admin.AuthAccountQueryVo;
import com.byebye.kzj.vo.admin.AuthAccountVo;
import com.byebye.kzj.vo.admin.ResourceVo;
import com.byebye.kzj.service.adminservice.AuthAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/5 下午5:46
 */
@Service("authAccountService")
public class AuthAccountServiceImpl extends BaseServiceImpl<AuthAccount, AuthAccountExample> implements AuthAccountService {
    @Autowired
    private AuthAccountMapper mapper;

    @Override
    public PageInfo getAuthAccountListByQuery(AuthAccountQueryVo vo, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<AuthAccountVo> authAccountList = mapper.getAuthAccountListByQuery(vo);
        PageInfo<AuthAccountVo> pageInfo = new PageInfo(authAccountList);
        return pageInfo;
    }

    @Override
    public AuthAccount getAccountByName(String name) {
        if(name==null||name.isEmpty()){
            return null;
        }
        AuthAccountExample example = new AuthAccountExample();
        AuthAccountExample.Criteria criteria = example.createCriteria();
        criteria.andAccountNameEqualTo(name)
                .andIsActiveEqualTo(1);
        List<AuthAccount> list = mapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
    }

    @Override
    public List<ResourceVo> getResourceListByAccountName(String name) {
        return mapper.getResourceListByAccountName(name);
    }

    @Override
    public boolean isRepeatAccount(Integer accountId, String value, Integer type) {
        AuthAccountExample example = new AuthAccountExample();
        AuthAccountExample.Criteria criteria = example.createCriteria();
        if (type == 1) {
            criteria.andAccountNameEqualTo(value);
        } else {
            criteria.andMobileEqualTo(value);
        }
        criteria.andAccountIdNotEqualTo(accountId);
        criteria.andIsActiveEqualTo(1);
        List<AuthAccount> list = mapper.selectByExample(example);
        return list != null && list.size() > 0;
    }
}
