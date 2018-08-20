package com.byebye.kzj.service.adminservice;

import com.byebye.kzj.model.NewsCarRelation;
import com.byebye.kzj.vo.admin.NewsDetailVo;
import com.byebye.kzj.vo.admin.NewsListQueryVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Description:
 * All Rights Reserved.
 */
public interface NewsInfoService {

    /**
     * 根据资讯Id获取资讯详情
     *
     * @return NewsDetailVo
     * @author 2018-07-05 by 刘风栓
     */
    NewsDetailVo getNewsDetailByNewsId(Integer newsId);

    /**
     * 根据查询条件获取资讯列表
     *
     * @return 资讯的集合
     * @author 2018-07-03 by 刘风栓
     */
    PageInfo getNewsListByQuery(NewsListQueryVo query, Integer pageNumber, Integer pageSize);

    /**
     * 根据资讯集合，设置资讯上下架
     *
     * @return 影响的行数
     * @author 2018-07-03 by 刘风栓
     */
    int setNewsStatusByNewsIdList(List<Integer> newsIdList, Integer status);

    /**
     * 根据资讯集合，关闭资讯的评轮
     *
     * @return 影响的行数
     * @author 2018-07-03 by 刘风栓
     */
    int closeCommentNewsByNewsIdList(List<Integer> newsIdList, Integer commontStatus);

    /**
     * 根据资讯Id获取资讯的关联车系信息
     *
     * @return NewsCarRelation集合
     * @author 2018-07-06 by 刘风栓
     */
    List<NewsCarRelation> getCarRelationListByNewsId(Integer newsId);

    /**
     * 保存资讯的关联车系信息
     *
     * @return 影响的行数
     * @author 2018-07-06 by 刘风栓
     */
    int saveNewsCarRelation(List<NewsCarRelation> list,Integer newsId);
}
