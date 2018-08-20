package com.byebye.kzj.service.adminservice.impl;

import com.byebye.kzj.common.utils.DateUtil;
import com.byebye.kzj.dao.NewsCarRelationMapper;
import com.byebye.kzj.dao.NewsInfoMapper;
import com.byebye.kzj.model.NewsCarRelation;
import com.byebye.kzj.service.adminservice.NewsInfoService;
import com.byebye.kzj.vo.admin.NewsInfoVo;
import com.byebye.kzj.vo.admin.NewsListQueryVo;
import com.byebye.kzj.vo.admin.NewsDetailVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 1.0 刘风栓
 */
@Service("newsInfoService")
public class NewsInfoServiceImpl implements NewsInfoService {

    @Autowired
    private NewsInfoMapper newsInfoMapper;

    @Autowired
    private NewsCarRelationMapper newsCarRelationMapper;

    @Override
    public NewsDetailVo getNewsDetailByNewsId(Integer newsId) {
        return newsInfoMapper.getNewsDetailByNewsId(newsId);
    }

    @Override
    public PageInfo getNewsListByQuery(NewsListQueryVo query, Integer pageNumber, Integer pageSize) {
        if (query != null) {
            if (StringUtils.isNotEmpty(query.getUserName())) {
                query.setUserName(String.format("%%%s%%", query.getUserName().trim()));
            }
            if (StringUtils.isNotEmpty(query.getNewsTitle())) {
                query.setNewsTitle(String.format("%%%s%%", query.getNewsTitle().trim()));
            }
            if (query.getMinCreateTime() != null) {
                Date start = DateUtil.toDate(query.getMinCreateTime(), DateUtil.LONG_DATE_FORMAT);
                query.setMinCreateTime(DateUtil.formatDateTime(start, DateUtil.FORMAT_ONE));
            }
            if (query.getMaxCreateTime() != null) {
                Date end = DateUtil.toDate(query.getMaxCreateTime() + " 23:59:59", DateUtil.FORMAT_ONE);
                query.setMaxCreateTime(DateUtil.formatDateTime(end, DateUtil.FORMAT_ONE));
            }
        }
        PageHelper.startPage(pageNumber, pageSize);
        List<NewsInfoVo> list = newsInfoMapper.getNewsListByQuery(query);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int setNewsStatusByNewsIdList(List<Integer> newsIdList, Integer status) {
        Integer unStatus = Integer.valueOf(1).equals(status) ? 0 : 1;
        return setNewsStatusAndCommentStatusByNewsIdList(newsIdList, status, unStatus, null);
    }

    @Override
    public int closeCommentNewsByNewsIdList(List<Integer> newsIdList, Integer commontStatus) {
        return setNewsStatusAndCommentStatusByNewsIdList(newsIdList, null, null, commontStatus);
    }

    /**
     * 根据资讯Id获取资讯的关联车系信息
     */
    @Override
    public List<NewsCarRelation> getCarRelationListByNewsId(Integer newsId) {
        return getCarRelationListByNewsIdAndIsActive(newsId, 1);
    }

    /**
     * 保存资讯的关联车系信息
     */
    @Override
    public int saveNewsCarRelation(List<NewsCarRelation> list, Integer newsId) {
        int rows = 0;
        if (list != null && list.size() > 0) {
            List<NewsCarRelation> addList = new ArrayList<NewsCarRelation>();
            List<NewsCarRelation> updateList = new ArrayList<NewsCarRelation>();
            List<Integer> newIdList = list.stream().map(NewsCarRelation::getSerialId).collect(Collectors.toList());
            List<NewsCarRelation> oldExtList = this.getCarRelationListByNewsIdAndIsActive(newsId, null);
            List<Integer> oldIdList = new ArrayList<>();
            if (oldExtList != null && oldExtList.size() > 0) {
                oldIdList = oldExtList.stream().map(NewsCarRelation::getSerialId).collect(Collectors.toList());
                oldIdList.removeAll(newIdList);
                //删除
                if (oldIdList != null && oldIdList.size() > 0) {
                    oldIdList.forEach(o -> {
                        NewsCarRelation havObj = oldExtList.stream().filter(y -> y.getSerialId().equals(o)).findFirst().orElse(null);
                        if (havObj != null) {
                            //delete
                            NewsCarRelation editItem = new NewsCarRelation();
                            editItem.setRelaId(havObj.getRelaId())
                                    .setBrandId(havObj.getBrandId())
                                    .setSerialId(havObj.getSerialId())
                                    .setIsActive(0);
                            updateList.add(editItem);
                        }
                    });
                }
            }

            list.forEach(x -> {
                NewsCarRelation havObj = (oldExtList == null || oldExtList.size() == 0)
                        ? null : oldExtList.stream().filter(y -> y.getSerialId().equals(x.getSerialId())).findFirst().orElse(null);
                if (havObj != null && havObj.getRelaId() != null) {
                    //存在且无效 更新
                    if (Integer.valueOf(0).equals(havObj.getIsActive())) {
                        NewsCarRelation editItem = new NewsCarRelation();
                        editItem.setRelaId(havObj.getRelaId())
                                .setBrandId(x.getBrandId())
                                .setSerialId(x.getSerialId())
                                .setIsActive(1);
                        updateList.add(editItem);
                    }
                } else {
                    //不存在
                    NewsCarRelation addItem = new NewsCarRelation();
                    addItem.setNewsId(newsId)
                            .setBrandId(x.getBrandId())
                            .setSerialId(x.getSerialId())
                            .setIsActive(1);
                    addList.add(addItem);
                }
            });

            //todo:
            if (updateList.size() > 0) {
                rows += updateList.size();
                //批量更新
                newsCarRelationMapper.updateNewsCarRelationByBatch(updateList);
            }
            if (addList.size() > 0) {
                rows += addList.size();
                //批量插入
                newsCarRelationMapper.insertNewsCarRelationByBatch(addList);
            }
        }
        return rows;
    }

    private List<NewsCarRelation> getCarRelationListByNewsIdAndIsActive(Integer newsId, Integer isActive) {
        return newsCarRelationMapper.getListByNewsId(newsId, isActive);
    }

    private int setNewsStatusAndCommentStatusByNewsIdList(List<Integer> newsIdList, Integer status, Integer unStatus, Integer commentStatus) {
        return newsInfoMapper.setNewsStatusAndCommentStatusByNewsIdList(newsIdList, status, unStatus, commentStatus);
    }
}
