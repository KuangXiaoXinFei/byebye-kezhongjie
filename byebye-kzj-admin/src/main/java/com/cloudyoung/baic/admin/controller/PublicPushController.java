package com.cloudyoung.baic.admin.controller;

import com.cloudyoung.baic.admin.annotation.ResourceKey;
import com.cloudyoung.baic.model.PublicPush;
import com.cloudyoung.baic.service.adminservice.PublicPushService;
import com.cloudyoung.baic.vo.admin.PublicPushVo;
import com.cloudyoung.baic.vo.admin.ResponseVo;
import com.cloudyoung.baic.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/8 12:20  by  李娜（lina@cloud-young.com）创建
 */
@Controller
@RequestMapping("/publicPush")
public class PublicPushController {
    @Autowired
    private PublicPushService publicPushService;

    @RequestMapping("/list")
    @ResourceKey("PUBLICPUSH")
    public String toList() {
        return "/publicPush/list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public ResponseVo getList(PublicPushVo query,
            @RequestParam("pageIndex") Integer pageIndex,
            @RequestParam("pageSize") Integer pageSize) {
        if (StringUtils.isEmpty(query.getMinCreateTime())) {
            query.setMinCreateTime(null);
        }
        if (StringUtils.isEmpty(query.getMaxCreateTime())) {
            query.setMaxCreateTime(null);
        }
        PageInfo pageInfo = publicPushService.getPushPageList(query,pageIndex, pageSize);
        Map map = new HashMap();
        map.put("data", pageInfo.getList());
        map.put("rows", pageInfo.getTotal());
        return ResponseVo.getInstanceForOk(map);
    }


    @RequestMapping("/save")
    @ResponseBody
    public ResponseVo savePushInfo(@RequestParam("content") String content){
        if(StringUtils.isEmpty(content)){
            return ResponseVo.getInstanceForError("-1","推送消息不能为空！");
        }
        PublicPush publicPush = new PublicPushVo();
        publicPush.setPushContent(content)
                .setIsActive(1)
                .setPushStatus(0)
                .setUpdateTime(new Date())
                .setCreateTime(new Date());
        publicPushService.insert(publicPush);
        return ResponseVo.getInstanceForOk("保存成功！");
    }
}
