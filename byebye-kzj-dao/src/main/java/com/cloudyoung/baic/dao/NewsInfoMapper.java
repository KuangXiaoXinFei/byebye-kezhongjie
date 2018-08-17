package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.NewsInfo;
import com.cloudyoung.baic.model.NewsInfoExample;
import com.cloudyoung.baic.vo.admin.NewsDetailVo;
import com.cloudyoung.baic.vo.admin.NewsInfoVo;
import com.cloudyoung.baic.vo.admin.NewsListQueryVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NewsInfoMapper extends BaseMapper<NewsInfo, NewsInfoExample> {

    /**
     * 根据条件获取资讯列表
     *
     * @return NewsInfoVo 集合
     * @author 2018-07-05 by 刘风栓
     */
    List<NewsInfoVo> getNewsListByQuery(NewsListQueryVo query);

    /**
     * 获取资讯详情
     *
     * @return NewsDetailVo
     * @author 2018-07-05 by 刘风栓
     */
    NewsDetailVo getNewsDetailByNewsId(Integer newsId);

    /**
     * 根据资讯集合，设置资讯上下架或者关闭评论
     *
     * @return 影响的行数
     * @author 2018-04-28 by 刘风栓
     */
    int setNewsStatusAndCommentStatusByNewsIdList(@Param("newsIdList") List<Integer> newsIdList, @Param("status") Integer status
            , @Param("unStatus") Integer unStatus, @Param("isComment") Integer isComment);

    /**
     * 根据条件获取资讯列表
     *
     * @return NewsInfoVo 集合
     * @author 2018-07-05 by 刘风栓
     */
    @MapKey("newsId")
    Map<Integer,NewsInfoVo> getListByQuery();
}