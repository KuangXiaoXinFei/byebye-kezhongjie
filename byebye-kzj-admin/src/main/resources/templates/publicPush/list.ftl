<#include "../freemarker/layout.ftl">
<@layoutHead title="消息推送">
<link href="${path}/static/css/publicPush.css" rel="stylesheet" type="text/css"/>
<style>
    #mainTable tr td {
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
                    <a href="">消息推送</a>
                </li>
            </ul>
        </div>

        <!-- 搜索块 -->
        <div class="portlet-body form page-bar">
            <form class="form-horizontal form-row-sepe" style="position:relative">
                <div class="form-body">
                    <div class="form-group margin-top-20">
                        <div class="col-md-4">
                            <label class="control-label col-md-3 pad-top-7">消息Id：</label>
                            <div class="col-md-9 pad-top-0 pad-right-15">
                                <input id="publicId" type="text" class="form-control"
                                       onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入消息Id">
                            </div>
                        </div>
                        <div class="col-md-5 pad-top-0">
                            <label class="control-label col-md-3 pad-top-7">创建日期：</label>
                            <div class="col-md-9 pad-top-0">
                                <div class="input-group date-picker input-daterange input-icon right"
                                     data-date="10/11/2012" data-date-format="yyyy-mm-dd">
                                    <div class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="startDate" type="text"
                                               class="form-control input-icon"
                                               placeholder="请输入开始时间">
                                    </div>
                                    <span class="input-group-addon"><i class="border-attr"></i></span>
                                    <div class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="endDate" type="text" class="form-control"
                                               placeholder="请输入结束时间">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="col-md-12 text-right">
                                <button id="btnReset" type="reset" class="btn default">清空</button>&nbsp;&nbsp;
                                <button @click="getList" type="button" class="btn btn-primary">搜索</button>
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
                    <div class="bs-bars-btn pull-right">
                    <#--<input @click="addPush()" type="button" class="btn btn-success" value="新建消息推送"/>-->
                        <a href="#">
                            <button @click="addPush()" type="button" class="btn default"><i class="fa-plu"></i>新建消息推送
                            </button>
                        </a>
                    </div>
                    <p class="total">共 {{total}} 数据</p></div>
                <div class="fixed-table-container">
                    <div class="fixed-table-body">
                        <div class="fixed-table-loading" style="top: 50px; display: none;">正在努力地加载数据中，请稍候……</div>
                        <table id="mainTable" class="table table-striped table-bordered  table-hover"
                               data-show-columns="true">
                            <thead>
                            <tr>

                                <th>
                                    <div class="th-inner ">消息ID</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">消息内容</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">创建时间</div>
                                    <div class="fht-cell"></div>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="no-records-found" v-show="total<=0">
                                <td class="bgColor" colspan="3" style="text-align:center !important">没有找到匹配的记录</td>
                            </tr>
                            <tr v-for="info in list" v-if="list.length>0">
                                <td>{{info.publicId}}</td>
                                <td>{{info.pushContent}}</td>
                                <td>{{formatDate(info.createTime)}}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="fixed-table-pagination" style="display: block;">
                        <div class="pull-right pagination">
                        <#--分页-->
                            <v-pagination :total="total" :currentpage="queryParam.pageIndex" :size="queryParam.pageSize"
                                          @pagechange="getList"
                                          v-show="total>0"></v-pagination>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<#--添加角色弹层-->
    <div class="modal fade bs-modal-md" id="pushModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">消息推送</h4>
                </div>
                <form class="form-horizontal form-row-sepe" novalidate="novalidate" style="margin-top: 50px;"
                      id="pushForm">
                    <div class="form-group noteGroup">
                        <label class="control-label col-md-4">
                            <span class="required">*</span>消息内容:
                        </label>
                        <div class="col-md-6 note-div">
                            <div class="">
                                <textarea id="pushContent" name="pushContent"
                                          style="width:100%;height:158px;resize:none;" rows="5"
                                          maxlength="200"> </textarea>
                            </div>
                            <p><span class="noteText">0</span>/200</p>
                        </div>
                    </div>
                </form>

                <div class="modal-footer">
                    <input type="button" @click="cancleModal()" class="btn default" value="取消"></input>
                    <input type="button" @click="save()" class="btn btn-primary" value="确定" id="saveBtn"></input>
                </div>

            </div>
        </div>
    </div>

</div>

</@layoutBody>
<@layoutFooter>
<script type="text/javascript" src="${path}/static/js/vue.js"></script>
<script type="text/javascript" src="${path}/static/js/vue.Pagination.js"></script>
<script type="text/javascript" src="${path}/static/js/pages/publicPush.js"></script>
</@layoutFooter>