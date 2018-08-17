package com.cloudyoung.baic.admin.controller;

import com.cloudyoung.baic.admin.annotation.ResourceKey;
import com.cloudyoung.baic.model.AuthAccount;
import com.cloudyoung.baic.model.AuthRole;
import com.cloudyoung.baic.service.adminservice.AuthAccountService;
import com.cloudyoung.baic.service.adminservice.AuthRoleService;
import com.cloudyoung.baic.admin.shiro.LoginUser;
import com.cloudyoung.baic.admin.shiro.UserUtil;
import com.cloudyoung.baic.vo.admin.AuthAccountParamsVo;
import com.cloudyoung.baic.vo.admin.AuthAccountQueryVo;
import com.cloudyoung.baic.vo.admin.ResponseVo;
import com.cloudyoung.baic.common.utils.MD5Util;
import com.cloudyoung.baic.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/5 下午5:41
 */
@Controller
@RequestMapping("/authAccount")
public class AuthAccountController {
    @Autowired
    private AuthAccountService authAccountService;
    @Autowired
    private AuthRoleService authRoleService;

    @Autowired
    private UserUtil userUtil;

    @Value("${md5.password}")
    private String password;
    @Value("${md5.salt}")
    private String salt;

    @RequestMapping("/list")
    @ResourceKey("ACCOUNT")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/authaccount/list");
        return mv;
    }

    /**
     * 获取账户列表
     *
     * @param vo
     * @param pageIndex
     * @param pageSize
     * @param response
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVo getList(AuthAccountQueryVo vo, @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize
            , HttpServletResponse response) {
        PageInfo pageInfo = authAccountService.getAuthAccountListByQuery(vo, pageIndex, pageSize);
        Map map = new HashMap();
        map.put("rows", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return ResponseVo.getInstanceForOk(map);
    }

    /**
     * 获取角色列表信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVo getRoleList() {
        List<AuthRole> roleList = authRoleService.getRoleList();
        return ResponseVo.getInstanceForOk(roleList);
    }

    /**
     * 获取账户信息
     *
     * @param accountId
     * @return
     */
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVo getDetail(Integer accountId) {
        AuthAccount authAccount = new AuthAccount();
        authAccount.setAccountId(0);
        authAccount.setRoleId(0);
        if (accountId != null && accountId > 0) {
            authAccount = authAccountService.selectByPrimaryKey(accountId);
        }
        return ResponseVo.getInstanceForOk(authAccount);
    }

    /**
     * 账户信息保存
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo saveData(AuthAccountParamsVo model) {
        if (model == null || StringUtils.isEmpty(model.getAccountName())
                || StringUtils.isEmpty(model.getRealName())
                || StringUtils.isEmpty(model.getMobile())
                || model.getRoleId() == null) {
            return ResponseVo.getInstanceForError(-1, "参数不能为空！");
        }
        AuthAccount authAccount = new AuthAccount();
        authAccount.setAccountId(0);
        authAccount.setAccountName(model.getAccountName());
        authAccount.setRealName(model.getRealName());
        authAccount.setRoleId(model.getRoleId());
        authAccount.setEmail(model.getEmail());
        authAccount.setMobile(model.getMobile());
        authAccount.setUpdateTime(new Date());
        int resultId = 0;
        Integer accountId = null;
        if (model.getAccountId() != null) {
            accountId = Integer.valueOf(model.getAccountId());
        }
        if (accountId != null && accountId.intValue() > 0) {
            authAccount.setAccountId(accountId);
            resultId = authAccountService.updateByPrimaryKeySelective(authAccount);
        } else {
            String encode = MD5Util.md5Encrypt(password, salt);
            authAccount.setPassword(encode);
            authAccount.setIsInital(0);
            authAccount.setIsActive(1);
            authAccount.setCreateTime(new Date());
            resultId = authAccountService.insert(authAccount);
        }
        if (resultId <= 0) {
            return ResponseVo.getInstanceForError(-1, "保存失败！");
        }
        return ResponseVo.getInstanceForOk("保存成功！");
    }

    @RequestMapping(value = "/isRepeatAccount", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVo isRepeatAccount(@RequestParam("accountId") Integer accountId,
                                      @RequestParam("value") String value,
                                      @RequestParam("type") Integer type) {
        if (value == null || value == "" || type == null) {
            return ResponseVo.getInstanceForError(-1, "参数不能为空！");
        }
        boolean bool = authAccountService.isRepeatAccount(accountId, value, type);
        return ResponseVo.getInstanceForOk(bool);
    }

    /**
     * 删除账户
     *
     * @param accountId
     * @return
     */
    @RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo deleteAccount(Integer accountId) {
        if (accountId == null) {
            return ResponseVo.getInstanceForError("-1", "参数不能为空！");
        }
        AuthAccount authAccount = new AuthAccount();
        authAccount.setAccountId(accountId);
        authAccount.setIsActive(0);
        authAccount.setUpdateTime(new Date());
        int resultId = authAccountService.updateByPrimaryKeySelective(authAccount);
        if (resultId > 0) {
            return ResponseVo.getInstanceForOk("删除账户成功！");
        }
        return ResponseVo.getInstanceForError("删除账户失败！");
    }

    /**
     * 密码重置
     *
     * @param accountId
     * @return
     */
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo resetPassword(Integer accountId) {
        if (accountId == null) {
            return ResponseVo.getInstanceForError("-1", "参数不能为空！");
        }
        String encode = MD5Util.md5Encrypt(password, salt);
        AuthAccount authAccount = new AuthAccount();
        authAccount.setAccountId(accountId);
        authAccount.setPassword(encode);
        authAccount.setIsInital(1);
        authAccount.setUpdateTime(new Date());
        int resultId = authAccountService.updateByPrimaryKeySelective(authAccount);
        if (resultId > 0) {
            return ResponseVo.getInstanceForOk("密码初始化成功！");
        }
        return ResponseVo.getInstanceForError("密码初始化失败！");
    }

    /**
     * 登录用户名和密码验证
     *
     * @param accountId
     * @param accountName
     * @param password
     * @return
     */
    @RequestMapping(value = "/validatePassword", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo validatePassword(Integer accountId, String accountName, String password) {
        AuthAccount authAccount = authAccountService.selectByPrimaryKey(accountId);
        if (authAccount == null) {
            return ResponseVo.getInstanceForError("用户信息不存在");
        }
        String encode = MD5Util.md5Encrypt(password, salt);
        if (!authAccount.getAccountName().equals(accountName) || !encode.equals(authAccount.getPassword())) {
            return ResponseVo.getInstanceForError("用户名或者密码错误");
        }
        return ResponseVo.getInstanceForOk(authAccount);
    }

    /**
     * 修改密码
     *
     * @param oldpassword
     * @param newPassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public ResponseVo updatePassword(String oldpassword, String newPassword, HttpServletRequest request) {
        LoginUser user = userUtil.getLoginUser(request);
        if (user == null || user.getUserId() == null) {
            return ResponseVo.getInstanceForError("用户信息不存在");
        }
        Integer accountId = user.getUserId();
        AuthAccount authAccount = authAccountService.selectByPrimaryKey(accountId);
        if (authAccount == null) {
            return ResponseVo.getInstanceForError("用户信息不存在");
        }
        String encode = MD5Util.md5Encrypt(oldpassword, salt);
        if (!encode.equals(authAccount.getPassword())) {
            return ResponseVo.getInstanceForError("旧密码错误");
        }
        encode = MD5Util.md5Encrypt(newPassword, salt);
        authAccount = new AuthAccount();
        authAccount.setAccountId(accountId);
        authAccount.setPassword(encode);
        authAccount.setIsInital(0);
        authAccount.setUpdateTime(new Date());
        authAccountService.updateByPrimaryKeySelective(authAccount);
        return ResponseVo.getInstanceForOk("密码修改成功");
    }
}
