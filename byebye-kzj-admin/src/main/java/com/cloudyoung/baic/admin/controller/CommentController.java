package com.cloudyoung.baic.admin.controller;

import com.cloudyoung.baic.admin.annotation.ResourceKey;
import com.cloudyoung.baic.service.adminservice.NewsCommentService;
import com.cloudyoung.baic.vo.admin.CommentQueryVo;
import com.cloudyoung.baic.vo.admin.ResponseVo;
import com.cloudyoung.baic.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：
 * 版权所有。
 *
 * @version 1.0 2018-5-16 16:10 by 李浩（lihao@cloud-young.com）创建
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private NewsCommentService newsCommentService;

    @RequestMapping("/list")
    @ResourceKey("COMMENT")
    public String toList() {
        return "/comment/list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public ResponseVo getList(CommentQueryVo query,
                              @RequestParam("pageIndex") Integer pageIndex,
                              @RequestParam("pageSize") Integer pageSize) {
        if (StringUtils.isEmpty(query.getMinCreateTime())) {
            query.setMinCreateTime(null);
        }
        if (StringUtils.isEmpty(query.getMaxCreateTime())) {
            query.setMaxCreateTime(null);
        }
        PageInfo pageInfo = newsCommentService.getQueryList(query, pageIndex, pageSize);
        Map map = new HashMap<>();
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return ResponseVo.getInstanceForOk(map);
    }

    @RequestMapping("/deleteComment")
    @ResponseBody
    public ResponseVo deleteComment(@RequestParam("commentId") Integer commentId) {
        if (commentId == null) {
            return ResponseVo.getInstanceForError("-1", "评论Id不能为空");
        }
        newsCommentService.deleteByCommentId(commentId);
        return ResponseVo.getInstanceForOk("删除成功");
    }
}
