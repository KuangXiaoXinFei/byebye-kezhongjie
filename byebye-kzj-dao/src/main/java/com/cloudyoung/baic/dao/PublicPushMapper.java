package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.PublicPush;
import com.cloudyoung.baic.model.PublicPushExample;
import com.cloudyoung.baic.vo.admin.PublicPushVo;

import java.util.List;

public interface PublicPushMapper extends BaseMapper<PublicPush, PublicPushExample> {
    List<PublicPush> getPageList(PublicPushVo query);
}