package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.NewsComment;
import com.cloudyoung.baic.model.NewsCommentExample;
import com.cloudyoung.baic.vo.admin.CommentQueryVo;
import com.cloudyoung.baic.vo.admin.NewsCommentVo;

import java.util.List;

public interface NewsCommentMapper extends BaseMapper<NewsComment, NewsCommentExample> {
    List<NewsCommentVo> getQueryList(CommentQueryVo query);
}