package com.cloudyoung.baic.admin.controller;

import com.cloudyoung.baic.admin.annotation.ResourceKey;
import com.cloudyoung.baic.model.UserInfo;
import com.cloudyoung.baic.service.adminservice.CosService;
import com.cloudyoung.baic.service.adminservice.UserService;
import com.cloudyoung.baic.vo.admin.ResponseVo;
import com.cloudyoung.baic.vo.admin.UserParamsVo;
import com.cloudyoung.baic.vo.admin.UserQueryVo;
import com.cloudyoung.baic.common.model.Result;
import com.cloudyoung.baic.common.utils.LogUtils;
import com.cloudyoung.baic.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author 王超（wangchao@cloud-young.com）创建
 * @date 1.0  2018/7/13 上午10:17
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final LogUtils logger = LogUtils.build(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CosService cosService;


    @RequestMapping("/list")
    @ResourceKey("USER")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/list");
        return mv;
    }

    /**
     * 获取用户列表
     *
     * @param vo
     * @param pageIndex
     * @param pageSize
     * @param response
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVo getList(UserQueryVo vo, @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize
            , HttpServletResponse response) {
        PageInfo pageInfo = userService.getUserListByQuery(vo, pageIndex, pageSize);
        Map map = new HashMap();
        map.put("rows", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return ResponseVo.getInstanceForOk(map);
    }

    /**
     * 账户信息保存
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo saveUser(UserParamsVo model, @RequestParam(value = "files", required = false) MultipartFile file) {
        if (model == null || StringUtils.isEmpty(model.getUserName())
                || StringUtils.isEmpty(model.getMobile())) {
            return ResponseVo.getInstanceForError("参数不能为空！");
        }

        if (file != null && file.getSize() > 0) {
            try {
                Result<String> cosResult = cosService.uploadFileByStream(file.getOriginalFilename(), file.getContentType(), "", file.getInputStream());
                if (!cosResult.isSuccess()) {
                    logger.error("UserController.saveUser", "上传文件报错", cosResult.getMessage());
                    return ResponseVo.getInstanceForError("文件上传失败");
                }
                model.setAvatar(cosResult.getResult());
            } catch (IOException e) {
                logger.error("UserController.save", "文件转换流失败", e);
                return ResponseVo.getInstanceForError("文件转换流失败");
            }
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(0);
        userInfo.setUserName(model.getUserName());
        userInfo.setMobile(model.getMobile());
        userInfo.setSex(model.getSex());
        userInfo.setAvatar(model.getAvatar());
        userInfo.setIsValidate(0);
        userInfo.setUserType(2);
        userInfo.setIsTalk(0);
        userInfo.setIsActive(1);
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        int resultId = userService.insert(userInfo);
        if (resultId <= 0) {
            return ResponseVo.getInstanceForError("保存失败！");
        }
        return ResponseVo.getInstanceForOk("保存成功！");
    }


    @RequestMapping(value = "/isRepeatUser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVo isRepeatUser(@RequestParam("value") String value,
                                   @RequestParam("type") Integer type) {
        if (value == null || value == "" || type == null) {
            return ResponseVo.getInstanceForError(-1, "参数不能为空！");
        }
        boolean bool = userService.isRepeatUser(value, type);
        return ResponseVo.getInstanceForOk(bool);
    }

    /**
     * 设置用户禁言状态
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/setUserTalk", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo setUserTalk(@RequestParam("userId") Integer userId,
                                  @RequestParam("isTalk") Integer isTalk) {
        if (userId == null || isTalk == null) {
            return ResponseVo.getInstanceForError("参数不能为空！");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setIsTalk(isTalk);
        int resultId = userService.updateByPrimaryKeySelective(userInfo);
        if (resultId > 0) {
            return ResponseVo.getInstanceForOk("设置成功！");
        }
        return ResponseVo.getInstanceForError("设置失败！");
    }
}
