package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.AuthAccount;
import com.cloudyoung.baic.model.AuthAccountExample;
import com.cloudyoung.baic.vo.admin.AuthAccountQueryVo;
import com.cloudyoung.baic.vo.admin.AuthAccountVo;
import com.cloudyoung.baic.vo.admin.ResourceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthAccountMapper extends BaseMapper<AuthAccount, AuthAccountExample> {
    List<AuthAccountVo> getAuthAccountListByQuery(AuthAccountQueryVo vo);

    /**
     * Description:获取当前账号下的资源
     *
     * @param
     * @return
     * @version 1.0  2018/7/6 15:41  by  李娜（lina@cloud-young.com）创建
     */

    List<ResourceVo> getResourceListByAccountName(@Param("name") String name);
}