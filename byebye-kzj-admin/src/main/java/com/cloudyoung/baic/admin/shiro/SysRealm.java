package com.cloudyoung.baic.admin.shiro;

import com.cloudyoung.baic.service.adminservice.AuthAccountService;
import com.cloudyoung.baic.vo.admin.ResourceVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/4/25 10:45  by  李娜（lina@cloud-young.com）创建
 */
public class SysRealm extends AuthorizingRealm {

    @Autowired
    private AuthAccountService authAccountService;

    /**
     * Description:获取授权信息，即权限验证
     *
     * @param
     * @return
     * @version 1.0  2018/4/25 12:16  by  李娜（lina@cloud-young.com）创建
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String authName = (String) principalCollection.getPrimaryPrincipal();
        if (StringUtils.isBlank(authName)) {
            return null;
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<ResourceVo> resourceList = authAccountService.getResourceListByAccountName(authName);
        if (CollectionUtils.isNotEmpty(resourceList)) {
            List<String> permissionlist = new ArrayList<>(resourceList.size());
            for (ResourceVo item : resourceList) {
                String permission = item.getResourceKey();
                permissionlist.add(permission);
            }
            authorizationInfo.addStringPermissions(permissionlist);
        }
        return authorizationInfo;
    }

    /**
     * Description:获取认证信息，即登录验证
     *
     * @param
     * @return
     * @version 1.0  2018/4/25 12:15  by  李娜（lina@cloud-young.com）创建
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        char[] password1 = token.getPassword();
        String password = new String(password1);
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotBlank(password)) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(username, password, this.getClass().getSimpleName());
            return authcInfo;
        }
        return null;
    }
}
