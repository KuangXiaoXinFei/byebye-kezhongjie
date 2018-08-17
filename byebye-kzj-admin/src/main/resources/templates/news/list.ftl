<#include "../freemarker/layout.ftl">
<@layoutHead title="资讯管理">
<link href="${path}/static/css/news.css" rel="stylesheet" type="text/css"/>
<style>
    #listTable tr td {
        text-align: center;
    }
</style>
</@layoutHead>
<@layoutBody>
<div id="vue_main">
    <!-- 主体页 -->
    <div class="page-content-wrapper">
        <div class="page-content">
            <!-- 路径块 -->
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <i class="fa fa-angle-right"></i>
                        <a href="">资讯管理</a>
                    </li>
                </ul>
            </div>
            <!-- 搜索块 -->
            <div class="portlet-body form page-bar">
                <form class="form-horizontal form-row-sepe" style="position:relative">
                    <input type="hidden" id="uid" value="${userId}"/>
                    <div class="form-body">
                        <div class="form-group margin-top-20">
                            <div class="col-md-4">
                                <label class="control-label col-md-3 pad-top-7">品牌车型：</label>
                                <div class="col-md-4 pad-top-0">
                                <#--<v-select v-model="queryParam.brandId"-->
                                <#--code="brandId"-->
                                <#--label="brandName"-->
                                <#--@change="searchBrandChange"-->
                                <#--:options="brands"></v-select>-->
                                    <select id="brandId" class="form-control select2">
                                        <option value="">品牌</option>
                                        <option :value="b.brandId" v-for="b in brands">{{b.brandName}}</option>
                                    </select>
                                </div>
                                <div class="col-md-5">
                                    <select id="serialId" class="form-control select2">
                                        <option value="">车系</option>
                                        <option :value="ser.serialId" v-for="ser in searchSerials">{{ser.serialName}}
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label col-md-3 pad-top-7">来源：</label>
                                <div class="col-md-9">
                                    <v-select v-model="queryParam.source" width="89" :options="sourceItems"></v-select>
                                <#--<select id="searchsource" class="form-control select2me"-->
                                <#--data-placeholder="Select...">-->
                                <#--<option value="">全部</option>-->
                                <#--<option value="1">官方</option>-->
                                <#--<option value="2">发帖</option>-->
                                <#--</select>-->
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label col-md-3 pad-top-7">资讯类型：</label>
                                <div class="col-md-9">
                                    <v-select v-model="queryParam.newsType" width="89"
                                              :options="newsTypeItems"></v-select>
                                <#--<select id="searchType" class="form-control select2">-->
                                <#--<option value="">全部</option>-->
                                <#--<option value="1">文章</option>-->
                                <#--<option value="2">微文</option>-->
                                <#--</select>-->
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <label class="control-label col-md-3 pad-top-7">资讯ID：</label>
                                <div class="col-md-9 pad-top-0 pad-right-15">
                                    <input v-model="queryParam.newsId" type="text" class="form-control"
                                           onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label col-md-3 pad-top-7">资讯标题：</label>
                                <div class="col-md-9">
                                    <input v-model="queryParam.newsTitle" type="text" class="form-control"
                                           placeholder="请输入">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label col-md-3 pad-top-7">资讯状态：</label>
                                <div class="col-md-9">
                                    <select id="searchStatus" class="form-control select2">
                                        <option value="">全部</option>
                                        <option value="1">上架</option>
                                        <option value="0">下架</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <label class="control-label col-md-3 pad-top-7">用户昵称：</label>
                                <div class="col-md-9 pad-top-0 pad-right-15">
                                    <input v-model="queryParam.userName" type="text" class="form-control"
                                           placeholder="请输入">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label class="control-label col-md-3 pad-top-7">用户ID：</label>
                                <div class="col-md-9">
                                    <input v-model="queryParam.userId" type="text" class="form-control"
                                           onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <label class="control-label col-md-2 pad-top-7">创建日期：</label>
                                <div class="col-md-8 pad-top-0">
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
                            <div class="col-md-4 col-md-offset-2 text-right">
                                <div class="col-md-12">
                                    <button @click="clearSearch" type="reset" class="btn default">清空</button>&nbsp;&nbsp;
                                    <button @click="getNewsList" type="button" class="btn btn-primary">搜索</button>
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
                                    <th class="bs-checkbox " style="text-align: center; width: 36px; " data-field="ck">
                                        <div class="th-inner ">
                                            <input name="btSelectAll" type="checkbox" v-model="isCheckAll"
                                                   @change="ckAllChange"/>
                                        </div>
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
                                        <div class="th-inner ">用户ID</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">用户昵称</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">资讯类型</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">创建时间</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">关联车系</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">来源</div>
                                        <div class="fht-cell"></div>
                                    </th>
                                    <th>
                                        <div class="th-inner ">资讯状态</div>
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
                                    <td class="bs-checkbox ">
                                        <input name="btSelectItem" type="checkbox" v-model="selectIds"
                                               :value="info.newsId">
                                    </td>
                                    <td>{{info.newsId}}</td>
                                    <td>{{info.title}}</td>
                                    <td>{{info.userId}}</td>
                                    <td>{{info.userName}}</td>
                                    <td v-if="info.newsType==1">
                                        文章
                                    </td>
                                    <td v-else>
                                        微文
                                    </td>
                                    <td>{{formatDate(info.createTime)}}</td>
                                    <td>{{info.serialCount}}</td>
                                    <td v-if="info.source==1">
                                        官方
                                    </td>
                                    <td v-else>
                                        发帖
                                    </td>
                                    <td v-if="info.status==1">
                                        上架
                                    </td>
                                    <td v-else>
                                        下架
                                    </td>
                                    <td>
                                        <a href="javascript:;" v-on:click="showDetail(info.newsId);">查看</a>&nbsp;&nbsp;
                                        <a href="javascript:;" v-on:click="setStatusConfirm(info.newsId,1);"
                                           v-if="info.status==1">下架</a>
                                        <a href="javascript:;" v-on:click="setStatusConfirm(info.newsId,0);"
                                           v-else>上架</a> &nbsp;&nbsp;
                                    <#--<a class="setIsComment" href="javascript:;">关闭评论</a> &nbsp;&nbsp;-->
                                        <a href="javascript:;" v-on:click="showCarRelaModal(info.newsId);">关联车系</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="fixed-table-pagination">
                            <div class="pull-left pagination-detail" v-show="total>0">
                                <span class="pagination-info">
                                    <span class="bs-footer-batch-btn">
                                        <button v-on:click="batchStatusConfirm(0);" type="button"
                                                class="btn default">批量上架</button>
                                        <button v-on:click="batchStatusConfirm(1);" type="button"
                                                class="btn default">批量下架</button>
                                    </span>
                                </span>
                            </div>
                            <div class="pull-right pagination">
                            <#--分页-->
                                <v-pagination :total="total" :currentpage="queryParam.pageNumber"
                                              :size="queryParam.pageSize"
                                              @pagechange="getNewsList" v-show="total>0"></v-pagination>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 下架弹层 -->
    <div class="modal fade bs-modal-md" id="upStatus" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" v-if="confirmItem.status==1">下架提示</h4>
                    <h4 class="modal-title" v-else>上架提示</h4>
                </div>
                <div class="modal-body text-center fs-14" v-if="confirmItem.isBatch">
                    <h5 v-if="confirmItem.status==1">确定进行下架操作吗？</h5>
                    <h5 v-else>确定进行上架操作吗？</h5>
                </div>
                <div class="modal-body text-center fs-14" v-else>
                    <h5 v-if="confirmItem.status==1">确定对资讯 {{confirmItem.newsId}} 进行下架操作吗？</h5>
                    <h5 v-else>确定对资讯 {{confirmItem.newsId}} 进行上架操作吗？</h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn default" data-dismiss="modal">取消</button>
                    <template v-if="confirmItem.isBatch">
                        <button type="button" class="btn btn-primary"
                                v-on:click="doSetStatus(confirmItem.newsIds,false);" v-if="confirmItem.status==1">确认
                        </button>
                        <button type="button" class="btn btn-primary"
                                v-on:click="doSetStatus(confirmItem.newsIds,true);" v-else>确认
                        </button>
                    </template>
                    <template v-else>
                        <button type="button" class="btn btn-primary"
                                v-on:click="doSetStatus([confirmItem.newsId],false);" v-if="confirmItem.status==1">确认
                        </button>
                        <button type="button" class="btn btn-primary"
                                v-on:click="doSetStatus([confirmItem.newsId],true);" v-else>确认
                        </button>
                    </template>
                </div>
            </div>
        </div>
    </div>
    <!-- 关闭评论 -->
    <div class="modal fade bs-modal-md" id="setCommentModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">关闭评论</h4>
                </div>
                <div class="modal-body text-center fs-14">
                    <h5>确定对资讯2993进行关闭评论操作吗？</h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn default" data-dismiss="modal">取消</button>
                    <button id="btnSetCommentStatus" type="button" class="btn btn-primary">确认</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 品牌车型关联 -->
    <div class="modal fade bs-modal-md" id="associatedCars" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">品牌车系关联</h4>
                </div>
                <div class="modal-body text-center fs-14">
                    <form class="form-horizontal form-row-sepe" novalidate="novalidate">
                        <div class="form-group margin-top-15" v-for="(sinfo,index) in relaCars.relaCarItems">
                            <label class="control-label col-md-2 fs-14 color_4e">
                                关联车系
                            </label>
                            <div class="col-md-4">
                                <select class="form-control" v-model="sinfo.selBrandId"
                                        v-on:change="brandChange(index)">
                                    <option value="-1">品牌</option>
                                    <option :value="b.brandId" v-for="b in sinfo.brands">{{b.brandName}}</option>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <select class="form-control" v-model="sinfo.selSerialId">
                                    <option value="-1">车系</option>
                                    <option :value="b.serialId" v-for="b in sinfo.serials">{{b.serialName}}</option>
                                </select>
                            </div>
                            <div class="col-md-2 text-left">
                                <a class="pad-top-7" v-on:click="addCarItem()"
                                   v-if="index==(relaCars.relaCarItems.length-1)">添加</a>
                                <a class="text-red pad-top-7" v-on:click="delCarItem(index,this);" v-else>删除</a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn default" data-dismiss="modal">取消</button>
                    <button v-on:click="setNewsRelaCar" type="button" class="btn btn-primary">确认</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 预览 -->
    <div class="modal fade bs-modal-md" id="previewModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-phone modal-md">
            <div class="modal-content modal-dialog-phone-content">
                <div class="phone_box">
                    <div class="phone-content">
                        <h2>{{detailItem.title}}</h2>
                    <#--<dl><dt><img src=""/></dt><dd><p>%s</p><p>1</p></dd></dl>-->
                        <div class="n_content">
                            <template v-for="p in detailItem.newsContent" v-if="detailItem.newsContent!=null">
                                <p v-if="p.type==1">{{p.value}}</p>
                                <p v-else-if="p.type==2"><img :src="p.value"/></p>
                            </template>
                        </div>
                    </div>
                </div>
                <div class="phone-btn">
                    <p v-if="detailItem.status==1">
                        <button v-on:click="doSetStatus([detailItem.newsId],false,true);"
                                type="button">下架
                        </button>
                    </p>
                    <p v-else>
                        <button v-on:click="doSetStatus([detailItem.newsId],true,true);"
                                type="button">上架
                        </button>
                    </p>
                    <p>
                        <button v-on:click="closeModal('previewModal');" type="button">关闭</button>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</@layoutBody>
<@layoutFooter>
<script type="text/javascript" src="${path}/static/js/vue.js?t=${.now?long}"></script>
<script type="text/javascript" src="${path}/static/js/vue-select.js?t=${.now?long}"></script>
<script type="text/javascript" src="${path}/static/js/vue.Pagination.js?t=${.now?long}"></script>
<script type="text/javascript" src="${path}/static/js/pages/newsList.js?t=${.now?long}"></script>
</@layoutFooter>