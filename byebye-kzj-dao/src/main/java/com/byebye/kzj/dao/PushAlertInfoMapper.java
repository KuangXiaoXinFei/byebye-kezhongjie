package com.byebye.kzj.dao;

import com.byebye.kzj.model.PushAlertInfo;
import com.byebye.kzj.model.PushAlertInfoExample;
import com.byebye.kzj.vo.admin.PushAlertInfoVo;
import com.byebye.kzj.vo.admin.PushAlertQueryVo;

import java.util.List;

public interface PushAlertInfoMapper extends BaseMapper<PushAlertInfo, PushAlertInfoExample> {
    List<PushAlertInfoVo> getPageList(PushAlertQueryVo query);
}