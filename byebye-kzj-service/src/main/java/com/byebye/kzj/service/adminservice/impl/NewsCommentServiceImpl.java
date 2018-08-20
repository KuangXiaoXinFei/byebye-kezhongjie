package com.byebye.kzj.service.adminservice.impl;

import com.byebye.kzj.common.utils.DateUtil;
import com.byebye.kzj.dao.NewsCommentMapper;
import com.byebye.kzj.model.NewsComment;
import com.byebye.kzj.model.NewsExter;
import com.byebye.kzj.service.adminservice.NewsCommentService;
import com.byebye.kzj.vo.admin.CommentQueryVo;
import com.byebye.kzj.vo.admin.NewsCommentVo;
import com.byebye.kzj.dao.NewsExterMapper;
import com.byebye.kzj.model.NewsCommentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/10 14:21  by  李娜（lina@cloud-young.com）创建
 */
@Service("newsCommentService")
public class NewsCommentServiceImpl implements NewsCommentService {
    @Autowired
    private NewsCommentMapper newsCommentMapper;

    @Autowired
    private NewsExterMapper newsExterMapper;

    @Override
    public PageInfo getQueryList(CommentQueryVo query, Integer pageIndex, Integer pageSize) {
        if (query != null) {
            if (query.getMinCreateTime() != null) {
                Date start = DateUtil.toDate(query.getMinCreateTime(), DateUtil.LONG_DATE_FORMAT);
                query.setMinCreateTime(DateUtil.formatDateTime(start, DateUtil.FORMAT_ONE));
            }
            if (query.getMaxCreateTime() != null) {
                Date end = DateUtil.toDate(query.getMaxCreateTime() + " 23:59:59", DateUtil.FORMAT_ONE);
                query.setMaxCreateTime(DateUtil.formatDateTime(end, DateUtil.FORMAT_ONE));
            }
        }
        PageHelper.startPage(pageIndex, pageSize);
        List<NewsCommentVo> list = newsCommentMapper.getQueryList(query);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public boolean deleteByCommentId(Integer commentId) {
        NewsComment comment = new NewsComment();
        comment.setCommentId(commentId)
                .setIsActive(0)
                .setUpdateTime(new Date());
        boolean flag = newsCommentMapper.updateByPrimaryKeySelective(comment) > 0 ? true : false;
        if (flag) {
            //设置资讯的评论数
            setNewsExterCommentCount(commentId);
        }
        return flag;
    }

    ////设置资讯的评论数
    private void setNewsExterCommentCount(Integer commentId) {
        NewsComment newsComment = this.newsCommentMapper.selectByPrimaryKey(commentId);
        if (newsComment == null) {
            return;
        }
        Integer newsId = newsComment.getNewsId();
        if (newsId == null) {
            return;
        }
        NewsCommentExample commentExample = new NewsCommentExample();
        NewsCommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andNewsIdEqualTo(newsId).andIsActiveEqualTo(1);
        Long count = this.newsCommentMapper.countByExample(commentExample);
        NewsExter newsExter = new NewsExter().setNewsId(newsId)
                .setCommentCount(count.intValue());
        newsExterMapper.updateByPrimaryKeySelective(newsExter);
    }
}
