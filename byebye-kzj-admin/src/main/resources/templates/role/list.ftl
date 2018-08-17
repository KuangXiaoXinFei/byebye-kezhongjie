<#include "../freemarker/layout.ftl">
<@layoutHead title="角色管理">
<link href="${path}/static/css/role.css" rel="stylesheet" type="text/css"/>
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
                    <a href="">角色管理</a>
                </li>
            </ul>
        </div>
        <!-- 表格块 -->
        <div class="portlet-body">
            <div class="bootstrap-table">
                <div class="fixed-table-toolbar">
                    <div class="bs-bars-btn pull-right">
                        <a href="#" class="cus-a-add" ><button class="btn default"  @click="addRole()"><i class="fa-plu"></i>添加角色</button></a>
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
                                    <div class="th-inner ">角色编号</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">角色名称</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">所属权限</div>
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
                            <tr v-for="info in roleList" v-if="roleList.length>0">
                                <td>{{info.roleId}}</td>
                                <td>{{info.roleName}}</td>
                                <td>{{info.authContent}}</td>
                                <td>
                                    <a v-show="info.isAdmin!=1" href="javascript:void(0)"
                                       v-on:click="editRole(info.roleId)">编辑</a>&nbsp;&nbsp;
                                    <a v-show="info.isAdmin!=1" href="javascript:void(0)"
                                       v-on:click="confimDelete(info.roleId,info.roleName)">删除</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="fixed-table-pagination" style="display: block;">
                        <div class="pull-right pagination">
                        <#--分页-->
                            <v-pagination :total="total" :currentpage="pageIndex" :size="pageSize" @pagechange="getList"
                                          v-show="total>0"></v-pagination>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<#--添加角色弹层-->
    <div class="modal fade bs-modal-md" id="roleModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">添加角色</h4>
                </div>
                <div class="modal-body text-center">
                    <form class="form-horizontal form-row-sepe" id="addRoleForm">
                        <div class="form-group margin-top-10">
                            <label class="control-label col-md-3">
                                <span class="required">*</span>角色名称:
                            </label>
                            <div class="col-md-7">
                                <input id="roleName" name="roleName" class="form-control" maxlength="10"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4">
                                <span class="required" aria-required="true">*</span>权限分配：
                            </label>
                            <div class="col-md-6 margin-top-7">
                                <input type="checkbox" class="allAuth" id="allAuth" onclick="page.ckAll(this)"/>全部
                            </div>
                            <div id="ulDiv" class="col-md-6" style="margin-left: 170px;">
                                <ul class="modal_ul" id="auth_ul">
                                </ul>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn default" @click="cancleRole()" value="取消"></input>
                    <input type="button" @click="saveOrUpdate()" class="btn btn-primary" value="确定" id="saveBtn"></input>
                </div>

            </div>
        </div>
    </div>
    <input id="roleId" value="0" hidden="hidden">
<#--确认删除弹层-->
    <div class="modal fade bs-modal-md" id="deleteModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">删除角色</h4>
                </div>
                <div class="modal-body text-center">
                    <h5 id="deleteText">确认对该角色进行删除操作吗?</h5>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn default" @click="cancleRole()" value="取消"></input>
                    <input type="button" @click="deleteRole()" class="btn btn-primary" value="确定"></input>
                </div>

            </div>
        </div>
    </div>
</div>

</@layoutBody>
<@layoutFooter>
<script type="text/javascript" src="${path}/static/js/jquery.validate.js"></script>
<script type="text/javascript" src="${path}/static/js/formValidateHelper.js"></script>
<script type="text/javascript" src="${path}/static/js/vue.js"></script>
<script type="text/javascript" src="${path}/static/js/vue.Pagination.js"></script>
<script type="text/javascript" src="${path}/static/js/pages/role.js"></script>
</@layoutFooter>