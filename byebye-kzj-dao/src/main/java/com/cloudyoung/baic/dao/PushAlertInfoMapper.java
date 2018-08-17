package com.cloudyoung.baic.dao;

import com.cloudyoung.baic.model.PushAlertInfo;
import com.cloudyoung.baic.model.PushAlertInfoExample;
import com.cloudyoung.baic.vo.admin.PushAlertInfoVo;
import com.cloudyoung.baic.vo.admin.PushAlertQueryVo;

import java.util.List;

public interface PushAlertInfoMapper extends BaseMapper<PushAlertInfo, PushAlertInfoExample> {
    List<PushAlertInfoVo> getPageList(PushAlertQueryVo query);
}