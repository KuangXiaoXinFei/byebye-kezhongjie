package com.cloudyoung.baic.admin.controller;

import com.cloudyoung.baic.admin.annotation.ResourceKey;
import com.cloudyoung.baic.model.DictionaryInfo;
import com.cloudyoung.baic.service.adminservice.DictionaryInfoService;
import com.cloudyoung.baic.service.adminservice.PushAlertService;
import com.cloudyoung.baic.vo.admin.PushAlertQueryVo;
import com.cloudyoung.baic.vo.admin.ResponseVo;
import com.cloudyoung.baic.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/13 14:53  by  李娜（lina@cloud-young.com）创建
 */
@RequestMapping("/pushAlert")
@Controller
public class PushAlertController {
    @Autowired
    private PushAlertService pushAlertService;
    @Autowired
    private DictionaryInfoService dictionaryInfoService;

    @RequestMapping("/list")
    @ResourceKey("PUSHALERT")
    public String toList() {
        return "/pushAlert/list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public ResponseVo getList(PushAlertQueryVo query,
                              @RequestParam("pageIndex") Integer pageIndex,
                              @RequestParam("pageSize") Integer pageSize) {
        if (StringUtils.isEmpty(query.getMinCreateTime())) {
            query.setMinCreateTime(null);
        }
        if (StringUtils.isEmpty(query.getMaxCreateTime())) {
            query.setMaxCreateTime(null);
        }
        if (StringUtils.isEmpty(query.getMinOccurTime())) {
            query.setMinOccurTime(null);
        }
        if (StringUtils.isEmpty(query.getMaxOccurTime())) {
            query.setMaxOccurTime(null);
        }
        PageInfo pageInfo = pushAlertService.getPageList(query, pageIndex, pageSize);
        Map map = new HashMap<>();
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return ResponseVo.getInstanceForOk(map);
    }

    @RequestMapping("/getLevel")
    @ResponseBody
    public ResponseVo getLevelList() {
        List<DictionaryInfo> list = dictionaryInfoService.getDictionaryInfoByClassId(1);
        return ResponseVo.getInstanceForOk(list);
    }
}
