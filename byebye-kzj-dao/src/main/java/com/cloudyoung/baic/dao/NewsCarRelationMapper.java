package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.NewsCarRelation;
import com.cloudyoung.baic.model.NewsCarRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsCarRelationMapper extends BaseMapper<NewsCarRelation, NewsCarRelationExample> {

    /**
     * 根据资讯Id获取资讯的关联车系信息
     *
     * @return NewsCarRelation集合
     * @author 2018-05-02 by 刘风栓
     */
    List<NewsCarRelation> getListByNewsId(@Param("newsId") Integer newsId, @Param("isActive") Integer isActive);

    /**
     * 批量插入资讯的关联车系信息
     *
     * @return
     * @author 2018-05-02 by 刘风栓
     */
    int insertNewsCarRelationByBatch(@Param("list") List<NewsCarRelation> list);

    /**
     * 批量更新资讯的关联车系信息
     *
     * @return
     * @author 2018-05-02 by 刘风栓
     */
    int updateNewsCarRelationByBatch(@Param("list") List<NewsCarRelation> list);
}