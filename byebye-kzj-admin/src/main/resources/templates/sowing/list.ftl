<#include "../freemarker/layout.ftl">
<@layoutHead title="轮播图管理">
<link href="${path}/static/css/public.css" rel="stylesheet" type="text/css"/>
<link href="${path}/static/css/sowing.css" rel="stylesheet" type="text/css"/>
<link href="${path}/static/plugins/jquery-file-upload/css/jquery.fileupload.css" rel="stylesheet" type="text/css"/>
<link href="${path}/static/plugins/jquery-file-upload/css/jquery.fileupload-ui.css" rel="stylesheet" type="text/css"/>
<link href="${path}/static/css/fileupload.css" rel="stylesheet" type="text/css"/>
<link href="${path}/static/css/cropper.css" rel="stylesheet" type="text/css"/>
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
                    <a href="">轮播图管理</a>
                </li>
            </ul>
        </div>
        <!-- 搜索块 -->
        <div class="portlet-body form page-bar">
            <form class="form-horizontal form-row-sepe">
                <div class="form-body">
                    <div class="form-group">
                        <div class="col-md-4">
                            <label class="control-label col-md-4 pad-top-7">轮播图状态：</label>
                            <div class="col-md-8 pad-top-0 pad-right-15">
                                <select id="searchStatus" class="form-control">
                                    <option value="0">全部</option>
                                    <option value="1">上架</option>
                                    <option value="2">下架</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-5 pad-top-0">
                            <label class="control-label col-md-2 pad-top-7">创建日期：</label>
                            <div class="col-md-10 pad-top-0">
                                <div class="input-group date-picker input-daterange input-icon right" data-date="10/11/2012" data-date-format="yyyy-mm-dd">
                                    <div class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="startDate"  type="text" class="form-control input-icon" placeholder="请输入开始时间">
                                    </div>
                                    <span class="input-group-addon"><i class="border-attr"></i></span>
                                    <div  class="input-icon right">
                                        <i class="fa fa-calendar"></i>
                                        <input id="endDate"  type="text" class="form-control" placeholder="请输入结束时间">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="col-md-12 text-right">
                                <button type="reset" class="btn default">清空</button>&nbsp;&nbsp;
                                <button type="button" class="btn btn-primary" @click="getAdList()">查询</button>
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
                        <a class="btn default" @click="addModel()"><i class="fa-plu"></i>添加轮播图</a>
                    </div>
                    <p class="total">共 {{total}} 数据</p>
                </div>
                <div class="fixed-table-container">
                    <div class="fixed-table-body">
                        <div class="fixed-table-loading" style="top: 50px; display: none;">正在努力地加载数据中，请稍候……</div>
                        <table id="listTable" class="table table-striped table-bordered  table-hover"
                               data-show-columns="true">
                            <thead>
                            <tr>
                                <th>
                                    <div class="th-inner ">ID</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">图片</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">跳转地址</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">描述</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">权重</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th>
                                    <div class="th-inner ">状态</div>
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
                                <td colspan="11" style="text-align:center !important">没有找到匹配的记录</td>
                            </tr>
                            <tr v-for="info in list" v-if="list.length>0">
                                <td>{{info.bannerId}}</td>
                                <td><img :src="info.imagePath+'?imageView2/2/w/100/h/100/q/80'"></td>
                                <td>{{info.url}}</td>
                                <td>{{info.description}}</td>
                                <td>{{info.weight}}</td>
                                <td v-if="info.status == 1">
                                    上架
                                </td>
                                <td v-else>
                                    下架
                                </td>
                                <td>{{formatDate(info.createTime)}}</td>
                                <td>
                                    <a href="javascript:void(0)" v-on:click="editAd(info.bannerId)">编辑</a>&nbsp;&nbsp;
                                    <a href="javascript:;"  v-if="info.status==1" v-on:click="updown(info.bannerId)" >下架</a>
                                    <a href="javascript:;"  v-else v-on:click="upward(info.bannerId)">上架</a> &nbsp;&nbsp;
                                    <a v-if="info.status==2" v-on:click="del(info.bannerId)" >删除</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="fixed-table-pagination">
                        <div class="pull-left pagination-detail">
                            <span class="pagination-info">
                            </span>
                        </div>
                        <div class="pull-right pagination">
                        <#--分页-->
                            <v-pagination :total="total" :currentpage="queryParam.pageNumber" :size="queryParam.pageSize"
                                          @pagechange="getAdList"
                                          v-show="total>0"></v-pagination>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 添加轮播图 -->
    <div  class="modal  fade  bs-modal-md"  id="add"  tabindex="-1"  role="dialog"  aria-hidden="true">
        <div  class="modal-dialog  modal-md">
            <div  class="modal-content">
                <div  class="modal-header">
                    <h4  class="modal-title">添加轮播图</h4>
                </div>
                <div  class="modal-body">
                    <form  id="addBannerForm"  class="form-horizontal  form-row-sepe"  novalidate="novalidate">
                        <div  class="form-group">
                            <label  class="col-md-2">
                                <span  class="required"  aria-required="true">*</span>封面：
                            </label>
                            <div  class="col-md-6 form-group">
                                <div    role="presentation">
                                    <div  class="files  fileinput-button">
                                        <div class="imgUp">
                                            <img id="element_id" style="max-height: 100%;max-width: 100%;"/>
                                        </div>
                                        <input type="file" id="files" accept="image/jpeg,image/jpg,image/png"  name="files" onchange="uploadImg(this)">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <p  class="rota_text">图片规格：750*420</p>

                        <div  class="form-group  margin-top-15">
                            <label  class="col-md-2">
                                <span  class="required"  aria-required="true">*</span>链接：
                            </label>
                            <div  class="col-md-10">
                                <input  v-model="txtUrl"  name="txtUrl" autocomplete="off"  type="text"  maxlength="256"  class="form-control"  placeholder="请输入链接">
                            </div>
                        </div>
                        <div  class="form-group">
                            <label  class="col-md-2">
                                <span  class="required"  aria-required="true">*</span>权重：
                            </label>
                            <div  class="col-md-6">
                                <select  class="form-control"  v-model="weight">
                                    <option  value="1">1</option>
                                    <option  value="2">2</option>
                                    <option  value="3">3</option>
                                    <option  value="4">4</option>
                                    <option  value="5">5</option>
                                    <option  value="6">6</option>
                                    <option  value="7">7</option>
                                    <option  value="8">8</option>
                                    <option  value="9">9</option>
                                </select>
                            </div>
                        </div>
                        <div  class="form-group  margin-top-15">
                            <label  class="col-md-2">
                                <span  class="required"  aria-required="true">*</span>描述：
                            </label>
                            <div  class="col-md-6">
                                <input v-model="txtDesctript" autocomplete="off" name="txtDescription" maxlength="32" type="text" class="form-control">
                            </div>
                        </div>
                        <p class="col-md-12 text-red">*注意：前端只能显示5条轮播信息，轮播条数大于5条时隐藏优先级最低的信息</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn default" @click="addCancel()">取消</button>
                    <button name="btn_sure"  type="button" class="btn btn-primary"  @click="add(1)">确认并上架</button>
                    <button name="btn_sure" type="button" class="btn btn-primary"   @click="add(2)">确认</button>
                </div>
                <input type="hidden" v-model="adId" value="0">
                </form>
            </div>
        </div>
    </div>
    <!-- 下架弹层 -->
    <div class="modal fade bs-modal-md" id="shelves" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">下架提示</h4>
                </div>
                <div class="modal-body text-center fs-14">
                    <h5>您是要下架该轮播图吗？</h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn default" @click="shelvesCancel()">取消</button>
                    <button type="button" class="btn btn-primary" @click="shelvesSure()">确认</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 上架弹层 -->
    <div class="modal fade bs-modal-md" id="shelvesUp" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">上架提示</h4>
                </div>
                <div class="modal-body text-center fs-14">
                    <h5>您是要上架该轮播图吗？</h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn default" @click="upCancel()">取消</button>
                    <button type="button" class="btn btn-primary"   @click="upSure()">确认</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 删除弹层 -->
    <div class="modal fade bs-modal-md" id="delete" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">删除提示</h4>
                </div>
                <div class="modal-body text-center fs-14">
                    <h5>您是要删除该轮播图吗？</h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn default" @click="delCancel()">取消</button>
                    <button type="button" class="btn btn-primary"  @click="delSure()">确认</button>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="page-footer text-center">
    <div class="page-footer-inner text-center" style="float:none;display:block">
    </div>
    <div class="scroll-to-top" style="display:block">
        <i class="icon-arrow-up"></i>
    </div>
</div>

</@layoutBody>
<@layoutFooter>
<script type="text/javascript" src="${path}/static/js/cropper.js"></script>
<script type="text/javascript" src="${path}/static/js/jquery.validate.js"></script>
<script type="text/javascript" src="${path}/static/js/formValidateHelper.js"></script>
<script type="text/javascript" src="${path}/static/js/vue.js?t=${.now?long}"></script>
<script type="text/javascript" src="${path}/static/js/vue.Pagination.js?t=${.now?long}"></script>
<script type="text/javascript" src="${path}/static/js/pages/adList.js?t=${.now?long}"></script>
<script type="text/javascript">
    function uploadImg(obj) {
        var file = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            $("#element_id").attr('src',e.target.result);
        }
        reader.readAsDataURL(file)
    }
</script>

</@layoutFooter>

