package com.byebye.kzj.dao;

import com.byebye.kzj.vo.admin.PublicPushVo;
import com.byebye.kzj.model.PublicPush;
import com.byebye.kzj.model.PublicPushExample;

import java.util.List;

public interface PublicPushMapper extends BaseMapper<PublicPush, PublicPushExample> {
    List<PublicPush> getPageList(PublicPushVo query);
}