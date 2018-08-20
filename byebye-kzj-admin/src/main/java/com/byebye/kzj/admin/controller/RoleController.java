package com.byebye.kzj.admin.controller;

import com.byebye.kzj.admin.annotation.ResourceKey;
import com.byebye.kzj.model.AuthAccount;
import com.byebye.kzj.model.AuthResource;
import com.byebye.kzj.model.AuthRole;
import com.byebye.kzj.service.adminservice.AuthResourceService;
import com.byebye.kzj.service.adminservice.AuthRoleService;
import com.byebye.kzj.vo.admin.ResponseVo;
import com.byebye.kzj.vo.admin.RoleListVo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/3 20:14  by  李娜（lina@cloud-young.com）创建
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private AuthRoleService authRoleService;

    @Autowired
    private AuthResourceService authResourceService;

    @RequestMapping("/list")
    @ResourceKey("ROLE")
    public String toList() {
        return "/role/list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public ResponseVo getList(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageIndex") Integer pageIndex) {
        if (pageSize == null || pageSize == 0 || pageIndex == null || pageIndex == 0) {
            pageIndex = 1;
            pageSize = 20;
        }
        PageInfo pageInfo = authRoleService.getRolePageList(pageIndex, pageSize);
        Map map = new HashMap();
        map.put("data", pageInfo.getList());
        map.put("rows", pageInfo.getTotal());
        return ResponseVo.getInstanceForOk(map);
    }

    @RequestMapping("/getDatas")
    @ResponseBody
    public ResponseVo getResourceList(@RequestParam("roleId") Integer roleId) {
        Map map = new HashMap();
        List<AuthResource> list = authResourceService.getResourceList();
        map.put("allResource", list);
        RoleListVo ckResource = null;
        if (roleId != null && roleId > 0) {
            ckResource = authRoleService.getResourceListByRoleId(roleId);
        }
        map.put("ckResource", ckResource);
        return ResponseVo.getInstanceForOk(map);
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public ResponseVo saveOrupdateRole(@RequestParam("roleId") Integer roleId,
                                       @RequestParam("roleName") String roleName,
                                       @RequestParam("ids") String ids) {
        if (StringUtils.isEmpty(roleName) || StringUtils.isEmpty(ids)) {
            return ResponseVo.getInstanceForError("-1", "参数不能为空!");
        }
        //判重
        Boolean isExist = authRoleService.isExistRole(roleName, roleId);
        if (isExist) {
            return ResponseVo.getInstanceForError("2", "该角色已存在！");
        }
        String msg = "添加成功！";
        List<Integer> idList = new ArrayList<>();
        if (StringUtils.isNotBlank(ids)) {
            String[] split = ids.split(",");
            for (String s : split) {
                idList.add(Integer.parseInt(s));
            }
        }
        AuthRole role = new AuthRole();
        role.setRoleName(roleName);
        if (roleId > 0) {
            //编辑角色
            msg = "更新成功！";
            authRoleService.updateRole(roleId, roleName, idList);
        } else {
            //新增角色
            role.setIsActive(1);
            authRoleService.addRole(role, idList);
        }
        return ResponseVo.getInstanceForOk(msg);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseVo deleteRole(@RequestParam("roleId") Integer roleId) {
        if(roleId == null || roleId == 0){
            return ResponseVo.getInstanceForError("-1","参数不能为空！");
        }
        //如果角色没有绑定有效账号，进行删除
        List<AuthAccount> list = authRoleService.getAccountInfoByRoleId(roleId);
        if(CollectionUtils.isNotEmpty(list)){
            return ResponseVo.getInstanceForError("2","该角色还有用户绑定无法删除！");
        }
        // 角色删除
        authRoleService.deleteRole(roleId);
        return ResponseVo.getInstanceForOk("删除成功！");
    }

}
