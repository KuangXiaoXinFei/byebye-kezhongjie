<#include "../freemarker/layout.ftl">
<@layoutHead title="评论管理">
<style>
    #listTable tr td {
        text-align: center;
    }
</style>
</@layoutHead>
<@layoutBody>
<!-- 主体页 -->
<div class="page-content-wrapper" id="vue_mian">
    <div class="page-content">
        <!-- 路径块 -->
        <div class="page-bar">
            <ul class="page-breadcrumb">
                <li>
                    <i class="fa fa-home"></i>
                    <i class="fa fa-angle-right"></i>
                    <a href="">评论管理</a>
                </li>
            </ul>
        </div>
        <!-- 搜索块 -->
        <div class="portlet-body form page-bar">
            <form class="form-horizontal form-row-sepe" id="selectForm">
                <div class="form-body">
                    <div class="form-group  margin-top-20">
                        <div class="col-md-4">
                            <label class="control-label col-md-3  pad-top-7">评论ID：</label>
                            <div class="col-md-9">
                                <input id="select_commentId" type="text" class="form-control"
                                       onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label class="control-label col-md-4 pad-top-7">评论内容：</label>
                            <div class="col-md-8">
                                <input id="commentContent" type="text" class="form-control" placeholder="请输入">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label class="control-label col-md-4 pad-top-7">用户ID：</label>
                            <div class="col-md-8">
                                <input id="userId" type="text" class="form-control"
                                       onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="control-label col-md-3  pad-top-7">用户昵称：</label>
                            <div class="col-md-9">
                                <input id="userName" type="text" class="form-control" placeholder="请输入">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label class="control-label col-md-4 pad-top-7">关联评论ID：</label>
                            <div class="col-md-8">
                                <input id="relaCommentId" type="text" class="form-control"
                                       onkeyup="value=value.replace(/[^\d]/g,'')"  placeholder="请输入">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label class="control-label col-md-4  pad-top-7">资讯ID：</label>
                            <div class="col-md-8">
                                <input id="newsId" type="text" class="form-control"
                                       onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="control-label col-md-3  pad-top-7">资讯标题：</label>
                            <div class="col-md-9">
                                <input id="title" type="text" class="form-control" placeholder="请输入">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label class="control-label col-md-3">创建日期：</label>
                            <div class="col-md-9 pad-top-0">
                                <div class="input-group date-picker input-daterange input-icon right"
                                     data-date="10/11/2012" data-date-format="yyyy-mm-dd">
                                    <div class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="startTime" type="text"
                                               class="form-control input-icon"
                                               placeholder="请输入开始时间">
                                    </div>
                                    <span class="input-group-addon"><i class="border-attr"></i></span>
                                    <div class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="endTime" type="text" class="form-control"
                                               placeholder="请输入结束时间">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-4 col-md-offset-8 text-right">
                                    <button type="reset" class="btn default">清空</button>&nbsp;&nbsp;
                                    <button @click="getList()" type="button" class="btn btn-primary">搜索</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!-- 表格块 -->
        <div class="portlet-body">
            <div class="bootstrap-table">
                <div class="fixed-table-toolbar">
                    <div class="bs-bars-btn pull-right"></div>
                    <p class="total">共 {{total}} 数据</p></div>
                <div class="fixed-table-container">
                    <div class="fixed-table-body">
                        <div class="fixed-table-loading" style="top: 50px; display: none;">正在努力地加载数据中，请稍候……</div>
                        <table id="listTable" class="table table-striped table-bordered  table-hover"
                               data-show-columns="true">
                            <thead>
                            <tr>
                                <th>
                                    <div class="th-inner ">评论ID</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">评论内容</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">用户ID</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">用户昵称</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">资讯ID</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">资讯标题</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">关联评论ID</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">创建时间</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
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
                                <td>{{info.commentId}}</td>
                                <td>{{info.commentContent}}</td>
                                <td>{{info.userId}}</td>
                                <td>{{info.userName}}</td>
                                <td>{{info.newsId}}</td>
                                <td>{{info.title}}</td>
                                <td>{{info.relaCommentId}}</td>
                                <td>{{formatDate(info.createTime)}}</td>
                                <td>
                                    <a href="javascript:;" v-on:click="deleteModal(info.commentId);">删除</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="fixed-table-pagination">
                        <div class="pull-right pagination">
                        <#--分页-->
                            <v-pagination :total="total" :currentpage="queryParams.pageIndex"
                                          :size="queryParams.pageSize"
                                          @pagechange="getList"
                                          v-show="total>0"></v-pagination>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <input id="commentId" hidden="hidden">
    <!-- 删除弹层 -->
    <div class="modal fade bs-modal-md" id="deleteModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body text-center">
                    <label id="deleteLabel">确认对该评论进行删除吗？</label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn default" data-dismiss="modal" @click="cancle()">取消</button>
                    <button type="button" class="btn btn-primary" @click="deleteComment()">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>


</@layoutBody>
<@layoutFooter>
<script type="text/javascript" src="${path}/static/js/vue.js"></script>
<script type="text/javascript" src="${path}/static/js/vue.Pagination.js"></script>
<script type="text/javascript" src="${path}/static/js/pages/commentList.js"></script>
</@layoutFooter>

