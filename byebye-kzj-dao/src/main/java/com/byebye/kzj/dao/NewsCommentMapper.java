package com.byebye.kzj.dao;

import com.byebye.kzj.model.NewsComment;
import com.byebye.kzj.model.NewsCommentExample;
import com.byebye.kzj.vo.admin.CommentQueryVo;
import com.byebye.kzj.vo.admin.NewsCommentVo;

import java.util.List;

public interface NewsCommentMapper extends BaseMapper<NewsComment, NewsCommentExample> {
    List<NewsCommentVo> getQueryList(CommentQueryVo query);
}