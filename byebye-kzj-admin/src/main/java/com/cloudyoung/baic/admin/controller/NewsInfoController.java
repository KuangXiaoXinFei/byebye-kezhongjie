package com.cloudyoung.baic.admin.controller;

import com.alibaba.fastjson.JSON;
import com.cloudyoung.baic.admin.annotation.ResourceKey;
import com.cloudyoung.baic.model.CarInfo;
import com.cloudyoung.baic.model.NewsCarRelation;
import com.cloudyoung.baic.service.adminservice.CarInfoService;
import com.cloudyoung.baic.service.adminservice.NewsInfoService;
import com.cloudyoung.baic.vo.admin.NewsDetailVo;
import com.cloudyoung.baic.vo.admin.NewsListQueryVo;
import com.cloudyoung.baic.vo.admin.ResponseCode;
import com.cloudyoung.baic.vo.admin.ResponseVo;
import com.cloudyoung.baic.common.utils.LogUtils;
import com.cloudyoung.baic.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 资讯管理
 */
@Controller
@RequestMapping("/news")
public class NewsInfoController {

    private static final LogUtils loggerUtils = LogUtils.build(NewsInfoController.class);

    @Autowired
    private NewsInfoService newsInfoService;

    @Autowired
    private CarInfoService carInfoService;

    //资讯管理页面
    @ResourceKey("NEWS")
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "userId", required = false, defaultValue = "") String userId) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("userId", userId == null ? "" : userId);
        mv.setViewName("/news/list");
        return mv;
    }

    //获取资讯列表
    @ResponseBody
    @RequestMapping(value = "/getlist", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVo getList(NewsListQueryVo query,
                              @RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
            , HttpServletResponse response) {

        if (StringUtils.isEmpty(query.getMinCreateTime())) {
            query.setMinCreateTime(null);
        }
        if (StringUtils.isEmpty(query.getMaxCreateTime())) {
            query.setMaxCreateTime(null);
        }

        Map map = new HashMap(2);
        PageInfo vo = newsInfoService.getNewsListByQuery(query, pageNumber, pageSize);
        if (vo != null) {
            map.put("total", vo.getTotal());
            map.put("rows", vo.getList());
            return ResponseVo.getInstanceForOk(map);
        }
        map.put("total", 0);
        map.put("rows", new ArrayList());
        return ResponseVo.getInstanceForOk(map);
    }

    //资讯详情
    @ResponseBody
    @RequestMapping(value = "/detail", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVo getDetail(Integer newsId) {
        NewsDetailVo detailVo = newsInfoService.getNewsDetailByNewsId(newsId);
        if (detailVo != null) {
            return ResponseVo.getInstanceForOk(detailVo);
        }
        return ResponseVo.getInstanceForError(ResponseCode.ERROR.getCode(), "获取资讯详情失败");
    }

    //修改资讯上下架状态
    @ResponseBody
    @RequestMapping(value = "/editstatus", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVo editStatus(@RequestParam(value = "ids", required = false) List<Integer> ids, @RequestParam(value = "status", required = false) Integer status) {
        int rowsCount = newsInfoService.setNewsStatusByNewsIdList(ids, status);
        return ResponseVo.getInstanceForOk(rowsCount);
    }

    //关闭评论
    @ResponseBody
    @RequestMapping(value = "/closecomment", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVo closeComment(@RequestParam(value = "ids", required = false) List<Integer> ids, @RequestParam(value = "status", required = false) Integer status) {
        int rowsCount = newsInfoService.closeCommentNewsByNewsIdList(ids, status);
        return ResponseVo.getInstanceForOk(rowsCount);
    }

    //设置资讯关联车系
    @ResponseBody
    @RequestMapping(value = "/editCarRelation", method = RequestMethod.POST)
    public ResponseVo editNewsCarRelation(@RequestParam(value = "newsId", required = false) Integer newsId, @RequestParam(value = "body", defaultValue = "0") String body) {
        if (StringUtils.isEmpty(body) || newsId == null) {
            return ResponseVo.getInstanceForError(ResponseCode.ERROR.getCode(), "参数不完整");
        }
        List<NewsCarRelation> list = JSON.parseArray(body, NewsCarRelation.class);
        if (list == null) {
            return ResponseVo.getInstanceForError(ResponseCode.ERROR.getCode(), "资讯关联的车系信息解析错误");
        }
        int rowCount = newsInfoService.saveNewsCarRelation(list, newsId);
        return ResponseVo.getInstanceForOk(rowCount);
    }

    //获取资讯关联车系
    @ResponseBody
    @RequestMapping(value = "/getCarRelations", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseVo getNewsCarRelationList(Integer newsId) {
        List<NewsCarRelation> list = newsInfoService.getCarRelationListByNewsId(newsId);
        if (list != null) {
            return ResponseVo.getInstanceForOk(list);
        }
        return ResponseVo.getInstanceForError(ResponseCode.ERROR.getCode(), "获取资讯关联车系失败");
    }

    @ResponseBody
    @RequestMapping("/brands")
    public ResponseVo getBrands() {
        List<CarInfo> carInfoList = carInfoService.getAllBrandList();
        if (carInfoList == null || carInfoList.size() == 0) {
            return ResponseVo.getInstanceForOk(new ArrayList());
        }
        List<Map> list = carInfoList.stream().map(m -> {
            Map map = new HashMap(2);
            map.put("brandId", m.getBrandId());
            map.put("brandName", m.getBrandName());
            return map;
        }).collect(Collectors.toList());
        return ResponseVo.getInstanceForOk(list);
    }

    @ResponseBody
    @RequestMapping("/serials")
    public ResponseVo getSerials(Integer brandId) {
        List<CarInfo> carInfoList = carInfoService.getSerialListByBrandId(brandId);
        if (carInfoList == null || carInfoList.size() == 0) {
            return ResponseVo.getInstanceForOk(new ArrayList());
        }
        List<Map> list = carInfoList.stream().map(m -> {
            Map map = new HashMap(2);
            map.put("serialId", m.getSerialId());
            map.put("serialName", m.getSerialName());
            return map;
        }).collect(Collectors.toList());
        return ResponseVo.getInstanceForOk(list);
    }


}
