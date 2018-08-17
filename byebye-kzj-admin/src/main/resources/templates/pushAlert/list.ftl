<#include "../freemarker/layout.ftl">
<@layoutHead title="设备警告管理">

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
                    <a href="">设备告警管理</a>
                </li>
            </ul>
        </div>
        <!-- 搜索块 -->
        <div class="portlet-body form page-bar">
            <form class="form-horizontal form-row-sepe" style="position:relative">
                <div class="form-body">

                    <div class="form-group   margin-top-20">
                        <div class="col-md-4">
                            <label class="control-label col-md-4 pad-top-7">告警ID：</label>
                            <div class="col-md-8 pad-top-0 pad-right-15">
                                <input id="pushId" type="text" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')"
                                       placeholder="请输入">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label class="control-label col-md-4 pad-top-7">告警级别：</label>
                            <div class="col-md-8 pad-top-0 pad-right-15">
                                <select id="level" class="form-control select2me" data-placeholder="Select...">
                                    <option value="">全部</option>
                                    <option :value="e.dictionaryId" v-for="e in levelList">{{e.dictionaryName}}
                                </option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label class="control-label col-md-4 pad-top-7">VIN：</label>
                            <div class="col-md-8 pad-top-0 pad-right-15">
                                <input id="vin" type="text" class="form-control" placeholder="请输入">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="control-label col-md-4 pad-top-7">用户姓名：</label>
                            <div class="col-md-8 pad-top-0 pad-right-15">
                                <input id="userName" type="text" class="form-control" placeholder="请输入">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label class="control-label col-md-4 pad-top-7">用户手机号：</label>
                            <div class="col-md-8 pad-top-0 pad-right-15">
                                <input id="mobile" type="text" class="form-control" placeholder="请输入">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-6">
                            <label class="control-label col-md-3">发生日期：</label>
                            <div class="col-md-9 pad-top-0" style="margin-left: -17px;">
                                <div class="input-group date-picker input-daterange input-icon right" data-date="10/11/2012" data-date-format="yyyy-mm-dd">
                                    <div class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="minOccurTime" type="text" class="form-control input-icon" placeholder="请输入开始时间">
                                    </div>
                                    <span class="input-group-addon"><i class="border-attr"></i></span>
                                    <div  class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="maxOccurTime" type="text" class="form-control" placeholder="请输入结束时间">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label class="control-label col-md-3">创建日期：</label>
                            <div class="col-md-9 pad-top-0" style="margin-left: -17px;">
                                <div class="input-group date-picker input-daterange input-icon right" data-date="10/11/2012" data-date-format="yyyy-mm-dd">
                                    <div class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="minCreateTime" type="text" class="form-control input-icon" placeholder="请输入开始时间">
                                    </div>
                                    <span class="input-group-addon"><i class="border-attr"></i></span>
                                    <div  class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="maxCreateTime" type="text" class="form-control" placeholder="请输入结束时间">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-4 col-md-offset-8 text-right">
                                <button type="reset" class="btn default">清空</button>&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary" @click="getList()">查询</button>
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
                                    <div class="th-inner ">告警ID</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">VIN</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">用户姓名</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">用户手机号</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">告警级别</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">故障描述</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">发生时间</div>
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
                                <td class="bgColor" colspan="8" style="text-align:center !important;">没有找到匹配的记录</td>
                            </tr>
                            <tr v-for="info in list" v-if="list.length>0">
                                <td>{{info.pushId}}</td>
                                <td>{{info.vinCode}}</td>
                                <td>{{info.userName}}</td>
                                <td>{{info.mobile}}</td>
                                <td>{{info.levelText}}</td>
                                <td>{{info.pushContent}}</td>
                                <td>{{formatDate(info.occurTime)}}</td>
                                <td>{{formatDate(info.createTime)}}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="fixed-table-pagination" style="display: block;">
                        <div class="pull-right pagination">
                        <#--分页-->
                            <v-pagination :total="total" :currentpage="queryParams.pageIndex" :size="queryParams.pageSize" @pagechange="getList"
                                          v-show="total>0"></v-pagination>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>
</@layoutBody>
<@layoutFooter>
<script type="text/javascript" src="${path}/static/js/vue.js"></script>
<script type="text/javascript" src="${path}/static/js/vue.Pagination.js"></script>
<script type="text/javascript" src="${path}/static/js/pages/pushAlert.js"></script>
</@layoutFooter>