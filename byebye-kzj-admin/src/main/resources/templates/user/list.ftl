<#include "../freemarker/layout.ftl">
<@layoutHead title="用户管理">
<link rel="stylesheet" href="${path}/static/css/fileupload.css">
<link href="${path}/static/css/public.css" rel="stylesheet" type="text/css"/>
<link href="${path}/static/css/user.css" rel="stylesheet" type="text/css"/>
<style>
    #listTable tr td {
        text-align: center;
    }
</style>
</@layoutHead>
<@layoutBody>
<!-- 主体页 -->
<div class="page-content-wrapper" id="vue_main">
    <div class="page-content">
        <!-- 路径块 -->
        <div class="page-bar">
            <ul class="page-breadcrumb">
                <li>
                    <i class="fa fa-home"></i>
                    <i class="fa fa-angle-right"></i>
                    <a href="">用户管理</a>
                </li>
            </ul>
        </div>
        <!-- 搜索块 -->
        <div class="portlet-body form page-bar">
            <form class="form-horizontal form-row-sepe">
                <div class="form-body">
                    <div class="form-group  margin-top-20">
                        <div class="col-md-5">
                            <label class="control-label col-md-3 pad-top-7">用户ID：</label>
                            <div class="col-md-9">
                                <input type="text" v-model="queryParam.userId" class="form-control"
                                       onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入用户ID">
                            </div>
                        </div>
                        <div class="col-md-5">
                            <label class="control-label col-md-3 pad-top-7" for="searchApplication">用户昵称：</label>
                            <div class="col-md-9">
                                <input type="text" v-model="queryParam.userName" class="form-control"
                                       placeholder="请输入用户昵称">
                            </div>
                        </div>
                    </div>
                    <div class="form-group  margin-top-10">
                        <div class="col-md-5">
                            <label class="control-label col-md-3 pad-top-7">用户状态：</label>
                            <div class="col-md-9">
                                <select id="txtTalk" v-model="queryParam.isTalk" class="form-control select2me"
                                        data-placeholder="Select...">
                                    <option value="-1">全部</option>
                                    <option value="0">正常</option>
                                    <option value="1">已禁言</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <label class="control-label col-md-3 pad-top-7" for="searchApplication">用户类型：</label>
                            <div class="col-md-9">
                                <select id="txtUserType" v-model="queryParam.userType" class="form-control select2me">
                                    <option value="-1">全部</option>
                                    <option value="1">真实用户</option>
                                    <option value="2">手动创建</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-8 pad-top-0">
                            <label class="control-label col-md-2 pad-top-7">创建日期：</label>
                            <div class="col-md-8">
                                <div class="input-group date-picker input-daterange" data-date="10/11/2012"
                                     data-date-format="yyyy-mm-dd">
                                    <div class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input type="text" id="startTime" v-model="queryParam.startTime"
                                               class="form-control"
                                               name="from" placeholder="请选择开始时间">
                                    </div>
                                    <span class="input-group-addon"><span class="border-attr"></span></span>
                                    <div class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input type="text" id="endTime" v-model="queryParam.endTime"
                                               class="form-control" name="to"
                                               placeholder="请选择结束时间">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 text-right">
                            <input type="button" @click="resetValue()" class="btn default" data-dismiss="modal"
                                   value="清空"></input>&nbsp;&nbsp;
                            <input type="button" @click="getList(1,20)" class="btn btn-primary" value="搜索"></input>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!-- 表格块 -->
        <div class="portlet-body margin-top-10">
            <div class="bootstrap-table">
                <div class="fixed-table-toolbar">
                    <div class="bs-bars-btn pull-right">
                        <a href="#" class="cus-a-add">
                            <button class="btn default" @click="addUser()"><i class="fa-plu"></i>添加用户</button>
                        </a>
                    </div>
                    <p class="total">共 {{total}} 数据</p></div>

                <div class="fixed-table-container">
                    <div class="fixed-table-body">
                        <div class="fixed-table-loading" style="top: 50px; display: none;">正在努力地加载数据中，请稍候……</div>
                        <table id="listTable" class="table table-striped table-bordered  table-hover"
                               data-show-columns="true" style="table-layout:fixed; word-break: break-all; word-wrap: break-word;">
                            <thead>
                            <tr>
                                <th>
                                    <div class="th-inner ">用户ID</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">用户昵称</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">用户性别</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">用户头像</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th style="width:100px;">
                                    <div class="th-inner " >创建时间</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">用户状态</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">用户类型</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">是否认证</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">姓名</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">身份证号</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">VIN码</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">发帖数</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th  style="width:80px;">
                                    <div class="th-inner ">操作</div>
                                    <div class="fht-cell"></div>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="no-records-found" v-show="total<=0">
                                <td class="bgColor" colspan="11" style="text-align:center !important">没有找到匹配的记录</td>
                            </tr>
                            <tr v-for="info in list" v-if="list.length>0">
                                <td>{{info.userId}}</td>
                                <td>{{info.userName}}</td>
                                <td v-if="info.sex==1">男</td>
                                <td v-else="info.sex==2">女</td>
                                <td v-else>未知</td>
                                <td><img :src="info.avatar+'?imageView2/2/w/100/h/100/q/80'"></td>
                                <td>{{formatDate(info.createTime)}}</td>
                                <td v-if="info.isTalk==1">已禁言</td>
                                <td v-else>正常</td>
                                <td v-if="info.userType==1">真实用户</td>
                                <td v-else="info.userType==2">手动创建</td>
                                <td v-else></td>
                                <td v-if="info.isValidate==1">是</td>
                                <td v-else>否</td>
                                <td v-if="info.isValidate==1">{{info.realName}}</td>
                                <td v-else>-</td>
                                <td v-if="info.isValidate==1">{{info.idCode}}</td>
                                <td v-else>-</td>
                                <td v-if="info.isValidate==1">{{info.vinCode}}</td>
                                <td v-else>-</td>
                                <td>{{info.articleCount}}</td>
                                <td>
                                    <a href="javascript:;" v-on:click="confimSetTalk(info.userId,info.userName,0);"
                                       v-if="info.isTalk==1">解除禁言</a>
                                    <a href="javascript:;" v-on:click="confimSetTalk(info.userId,info.userName,1);"
                                       v-else>禁言</a>&nbsp;&nbsp;
                                    <a href="javascript:;"
                                       v-on:click="toMyNews(info.userId);">Ta发布的</a>&nbsp;&nbsp;
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="fixed-table-pagination" style="display: block;">
                        <div class="pull-right pagination">
                        <#--分页-->
                            <v-pagination :total="total" :currentpage="queryParam.pageIndex"
                                          :size="queryParam.pageSize" @pagechange="getList"
                                          v-show="total>0"></v-pagination>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 禁言弹层 -->
    <div class="modal fade bs-modal-md" id="setTalkModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="txtTitle">禁言提示</h4>
                </div>
                <div class="modal-body text-center fs-14">
                    <h5 id="txtConfirmTile">确定对账户xxx进行禁言操作吗？</h5>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn default" data-dismiss="modal" value="取消"></input>
                    <input type="button" @click="setTalk()" class="btn btn-primary" data-dismiss="modal"
                           value="确认"></input>
                </div>
            </div>
        </div>
    </div>
    <!-- 新建用户 -->
    <div class="modal fade bs-modal-md" id="addUser" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">新建用户</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal form-row-sepe" id="addUserForm" novalidate="novalidate">
                        <div class="form-group margin-top-15">
                            <label class="control-label col-md-4">
                                <span class="required" aria-required="true">*</span>用户昵称：
                            </label>
                            <div class="col-md-6">
                                <input type="text" id="txtUserName" name="txtUserName" v-model="userInfo.userName"
                                       class="form-control"
                                       placeholder="请输入用户昵称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">
                                <span class="required" aria-required="true">*</span>用户手机号：
                            </label>
                            <div class="col-md-6">
                                <input type="text" id="txtMobile" name="txtMobile" v-model="userInfo.mobile"
                                       class="form-control"
                                       placeholder="请输入用户手机号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">
                                <span class="required" aria-required="true"></span>性别：
                            </label>
                            <div class="col-md-6">
                                <input type="radio" v-model="userInfo.sex" value="1" name="sex"/>&nbsp;男&nbsp;&nbsp;
                                <input type="radio" v-model="userInfo.sex" value="2" name="sex"/>&nbsp;女
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">
                                <span class="required" aria-required="true">*</span>上传头像：
                            </label>
                            <div class="col-md-6">
                                <div role="presentation">
                                    <div class="files fileinput-button" id="img_id">
                                        <input type="file" id="files" name="files"
                                               accept="image/jpeg,image/jpg,image/png"
                                               style="width: 100%; height: 100%;" onchange="uploadImg(this)">
                                    </div>
                                </div>

                            </div>
                        </div>
                        <input name="picUrl" id="picUrl" hidden="hidden"/>
                    </form>
                </div>
                <div class="modal-footer">
                    <input type="button" @click="cancelUser()" class="btn default" value="取消"></input>
                    <input id="btnSave" type="button" @click="saveUser()" class="btn btn-primary"
                           value="确认"></input>
                </div>
            </div>
        </div>
        <input type="hidden" v-model="userInfo.userId" id="userId">
        <input type="hidden" id="userName">
        <input type="hidden" id="isTalk">
        <div id="div_toast" hidden="hidden" class="toast">保存成功</div>
    </div>
    <!-- 头像设置 -->
    <!-- 图片裁剪弹层 -->
    <div class="modal fade bs-modal-md" id="tailoring" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title">头像设置</h4>
                </div>
                <div class="modal-body text-center">
                    <form class="form-horizontal form-row-sepe" id="mainForm">
                        <div class="form-group">
                            <div class="col-md-12 tailoring_margin" id="pDiv">

                            </div>
                            <label class="control-label col-md-9 col-md-offset-3  text-Acenter margin-bottom-20">
                                <span class="rota_text">上传图片比例为1:1，拖拽调整头像显示区域</span>
                            </label>
                            <div class="col-md-12 text-left">
                                <div style="float:left">
                                    <div class="fileinput-button btn default">
                                        重新选择
                                        <input id="up_img" name="up_img" type="file" multiple="" style="width: 100%
                                            ;height: 100%;">
                                    </div>
                                </div>
                                <div class="text-right" style="float:right;margin-right:10px">
                                    <input type="button" class="btn btn-primary" id="saveImage" value="保存"></input>
                                    <input type="button" class="btn default" value="取消" id="catCancleBtn"></input>
                                </div>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END CONTAINER -->
</@layoutBody>
<@layoutFooter>
<script type="text/javascript" src="${path}/static/js/uploadPreview.js"></script>
<script type="text/javascript" src="${path}/static/js/jquery.Jcrop.js"></script>
<script type="text/javascript" src="${path}/static/js/jquery.validate.js"></script>
<script type="text/javascript" src="${path}/static/js/formValidateHelper.js"></script>
<script type="text/javascript" src="${path}/static/js/vue.js"></script>
<script type="text/javascript" src="${path}/static/js/vue.Pagination.js"></script>
<script type="text/javascript" src="${path}/static/js/pages/user.js"></script>
</@layoutFooter>