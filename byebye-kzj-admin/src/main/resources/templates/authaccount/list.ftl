<#include "../freemarker/layout.ftl">
<@layoutHead title="账户管理">
<link href="${path}/static/css/authAccount.css" rel="stylesheet" type="text/css"/>
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
                        <a href="">账户管理</a>
                    </li>
                </ul>
            </div>
            <!-- 搜索块 -->
            <div class="portlet-body form page-bar">
                <form class="form-horizontal form-row-sepe">
                    <div class="form-body">
                        <div class="form-group  margin-top-20">
                            <div class="col-md-4">
                                <label class="control-label col-md-4 pad-top-7">用户名：</label>
                                <div class="col-md-8">
                                    <input type="text" v-model="queryParam.accountName"
                                           class="form-control" placeholder="请输入">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label col-md-4 pad-top-7">手机号：</label>
                                <div class="col-md-8">
                                    <input type="text" v-model="queryParam.mobile"
                                           class="form-control"  placeholder="请输入">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label col-md-4 pad-top-7" for="searchApplication">邮箱：</label>
                                <div class="col-md-8">
                                    <input type="text" v-model="queryParam.email" class="form-control"  placeholder="请输入">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <label class="control-label col-md-4 pad-top-7">真实姓名：</label>
                                <div class="col-md-8">
                                    <input type="text" v-model="queryParam.realName" class="form-control"  placeholder="请输入">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label col-md-4 pad-top-7">所属角色：</label>
                                <div class="col-md-8">
                                    <select id="txtRole" name="txtRole" class="form-control select2me">
                                        <option value="0">全部</option>
                                        <option v-for="item in roleItems" v-bind:value="item.roleId">{{item.roleName}}
                                        </option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-4 text-right">
                                <input type="button" @click="resetValue()" id="btnReset" class="btn default"
                                       value="清空"></input>&nbsp;&nbsp;
                                <input type="button" @click="getList(1,20)" id="btnSearch" class="btn btn-primary"
                                       value="搜索"></input>
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
                            <a href="#" class="cus-a-add" ><button class="btn default"  @click="addAccount()"><i class="fa-plu"></i>添加账户</button></a>
                        </div>
                        <p class="total">共 {{total}} 数据</p></div>

                    <div class="fixed-table-container">
                        <div class="fixed-table-body">
                            <div class="fixed-table-loading" style="top: 50px; display: none;">正在努力地加载数据中，请稍候……</div>
                            <table id="listTable" class="table table-striped table-bordered  table-hover"
                                   data-show-columns="true">
                                <thead>
                                <tr>
                                    <th>
                                        <div class="th-inner ">用户名</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">真实姓名</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">所属角色</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">Email地址</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">手机号</div>
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
                                    <td>{{info.accountName}}</td>
                                    <td>{{info.realName}}</td>
                                    <td>{{info.roleName}}</td>
                                    <td>{{info.email}}</td>
                                    <td>{{info.mobile}}</td>
                                    <td v-if="info.isAdmin!=1">
                                        <a href="javascript:;" v-on:click="editData(info.accountId);">编辑</a>&nbsp;&nbsp;
                                        <a href="javascript:;"
                                           v-on:click="confimDelete(info.accountId,info.accountName);">删除</a>&nbsp;&nbsp;
                                        <a href="javascript:;"
                                           v-on:click="confimResetPassword(info.accountId,info.accountName);">密码初始化</a>
                                    </td>
                                    <td v-else></td>
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
        <!-- BEGIN FOOTER -->
        <!-- 新建账户 -->
        <div class="modal fade bs-modal-md" id="addAccount" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="txtTitle">账户数据</h4>
                    </div>
                    <div class="modal-body">
                        <form id="addAccountForm" class="form-horizontal form-row-sepe" novalidate="novalidate">
                            <div class="form-group margin-top-15">
                                <label class="control-label col-md-4">
                                    <span class="required" aria-required="true">*</span>用户名：
                                </label>
                                <div class="col-md-6">
                                    <input v-model="accountInfo.accountName" type="text" name="txtAccountName"
                                           id="txtAccountName"
                                           class="form-control"
                                           placeholder="请输入">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4">
                                    <span class="required" aria-required="true">*</span>真实姓名：
                                </label>
                                <div class="col-md-6">
                                    <input v-model="accountInfo.realName" type="text" name="txtRealName"
                                           id="txtRealName"
                                           class="form-control"
                                           placeholder="请输入">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4">
                                    <span class="required" aria-required="true">*</span>手机号：
                                </label>
                                <div class="col-md-6">
                                    <input v-model="accountInfo.mobile" type="text" name="txtMobile"
                                           id="txtMobile" class="form-control"
                                           placeholder="请输入">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-4">
                                    <span class="required" aria-required="true"></span>邮箱：
                                </label>
                                <div class="col-md-6">
                                    <input v-model="accountInfo.email" type="text" name="txtEmail"
                                           id="txtEmail" class="form-control"
                                           placeholder="请输入">
                                </div>
                            </div>

                            <div class="form-group" name="div-category" id="div-category">
                                <label class="control-label col-md-4">
                                    <span class="required" aria-required="true">*</span>所属角色：
                                </label>
                                <div class="col-md-6">
                                    <select class="form-control select2me" id="selRoleId" name="selRoleId">
                                        <option value="0">请选择</option>
                                        <option v-for="item in roleItems" v-bind:value="item.roleId">{{item.roleName}}
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <input type="button" @click="cancelAccount()" class="btn default" data-dismiss="modal"
                               value="取消"></input>
                        <input type="button" @click="saveAccount()" id="btnSave" class="btn btn-primary"
                               value="确认"></input>
                    </div>
                </div>
            </div>
            <input type="hidden" v-model="accountInfo.accountId" id="accountId">
            <input type="hidden" id="accountName">
            <div id="div_toast" hidden="hidden" class="toast">保存成功</div>
        </div>
        <!-- 密码初始化 -->
        <div class="modal fade bs-modal-md" id="resetPasswordModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">密码初始化</h4>
                    </div>
                    <div class="modal-body text-center fs-14">
                        <h5 id="resetText">确定对该账户进行密码初始化操作吗？</h5>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn default" data-dismiss="modal" value="取消"></input>
                        <input type="button" id="btnReset" @click="resetPassword()" class="btn btn-primary"
                               value="确认"></input>
                    </div>
                </div>
            </div>
        </div>
        <!-- 密码初始化成功弹层 -->
        <div class="modal fade bs-modal-md" id="resetSuccessModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">密码初始化</h4>
                    </div>
                    <div class="modal-body text-center fs-14">
                        <h5 id="resetSuccessText">已将账户xxx密码重置为123456</h5>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- 删除弹层 -->
        <div class="modal fade bs-modal-md" id="delAccount" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">提示</h4>
                    </div>
                    <div class="modal-body text-center fs-14">
                        <h5 id="deleteText">确认要删除该账户吗？</h5>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn default" data-dismiss="modal" value="取消"></input>
                        <input type="button" class="btn btn-primary" data-dismiss="modal" @click="deleteData()" value="确认"></input>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END CONTAINER -->
</@layoutBody>
<@layoutFooter>
<script type="text/javascript" src="${path}/static/js/jquery.validate.js"></script>
<script type="text/javascript" src="${path}/static/js/formValidateHelper.js"></script>
<script type="text/javascript" src="${path}/static/js/vue.js"></script>
<script type="text/javascript" src="${path}/static/js/vue-select.js?t=${.now?long}"></script>
<script type="text/javascript" src="${path}/static/js/vue.Pagination.js"></script>
<script type="text/javascript" src="${path}/static/js/pages/authAccount.js"></script>
</@layoutFooter>

