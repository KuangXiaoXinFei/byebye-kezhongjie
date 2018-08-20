package com.byebye.kzj.dao;

import com.byebye.kzj.model.AuthAccount;
import com.byebye.kzj.model.AuthAccountExample;
import com.byebye.kzj.vo.admin.AuthAccountQueryVo;
import com.byebye.kzj.vo.admin.AuthAccountVo;
import com.byebye.kzj.vo.admin.ResourceVo;
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