<#macro layoutHead title="" name="-北汽车联网">
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <#assign path=request.contextPath />
    <script type="text/javascript">
        baseUrlPath = '${basePath}';
    </script>
    <title>${title!""}${name!""}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="北汽车联网" name="description"/>
    <link rel="shortcut icon" href="${path}/static/images/favicon.ico"/>

    <link href="${path}/static/plugins/bootstrap/css/bootstrap.css?t=${.now?long}" rel="stylesheet" type="text/css"/>
    <link href="${path}/static/plugins/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="${path}/static/plugins/bootstrap-table/css/bootstrap-table.css" rel="stylesheet" type="text/css"/>
    <!--select2-->
    <link href="${path}/static/plugins/select2/select2.css" rel="stylesheet" type="text/css"/>
    <link href="${path}/static/plugins/jquery-multi-select/css/multi-select.css" rel="stylesheet" type="text/css"/>
    <!--plugins-->
    <link href="${path}/static/plugins/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="${path}/static/plugins/layout/css/layout.css" rel="stylesheet" type="text/css"/>
    <link href="${path}/static/plugins/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css"/>
    <!-- 日历 -->
    <link href="${path}/static/plugins/bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet"
          type="text/css"/>

    <link href="${path}/static/css/public.css?t=${.now?long}" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="${path}/static/plugins/js/jquery.min.js"></script>

    <#nested>

</head>
</#macro>

<#macro layoutBody>
<body class="page-header-fixed page-quick-sidebar-over-content">
<!--header-->
<div class="page-header navbar navbar-fixed-top">
    <div class="page-header-inner">
        <div class="page-logo">
            <a href="#">
                <div class="logo-block">
                    <div class="logo-bold">北汽运营</div>
                    <div class="logo-weak">
                        <div class="logo-line"></div>
                        <div>北汽运营管理系统</div>
                    </div>
                </div>
            </a>
        </div>
        <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
                <li class="dropdown dropdown-user open2">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                       data-close-others="true">
                        <img alt="" class="img-circle" src="${path}/static/images/touxiang.png">
                        <span class="username username-hide-on-mobile">管理员</span>
                        <i class="icon icon-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-default">
                        <li><a id="btnmodifypwd" href="#">更改密码</a></li>
                        <li><a href="${path}/logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="page-container">

    <#include "menu.ftl" >
    <@menu></@menu>

    <!--main start-->

    <#nested>
</div>
<!--main end-->
</#macro>

<#macro layoutFooter>
<div class="page-footer text-center">
    <div class="page-footer-inner text-center" style="float: none;display: block;">
        2018 © 北京云漾信息科技有限公司
    </div>
    <div class="scroll-to-top">
        <i class="icon-arrow-up"></i>
    </div>
</div>

<!-- 更改密码 -->
<div class="modal fade bs-modal-md" id="modifyPwd" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">更改密码</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal form-row-sepe" novalidate="novalidate">
                    <div class="form-group margin-top-15">
                        <label class="control-label col-md-4">
                            <span class="required" aria-required="true">*</span>旧密码：
                        </label>
                        <div class="col-md-6">
                            <input id="oldPassword" autocomplete="off" maxlength="=45" type="password" class="form-control" placeholder="请输入">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4">
                            <span class="required" aria-required="true">*</span>新密码：
                        </label>
                        <div class="col-md-6">
                            <input id="newPassword" maxlength="=45" type="password"  autocomplete="off" class="form-control"
                                   placeholder="请输入">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4">
                            <span class="required" aria-required="true">*</span>重复新密码：
                        </label>
                        <div class="col-md-6">
                            <input id="renewPassword" maxlength="=45" type="password"  autocomplete="off" class="form-control" placeholder="请输入">
                        </div>
                    </div>
                    <div class="form-group vali" id="errorPlace" style="display: none;">
                        <div class="col-md-6 col-md-offset-3">
                            <p class="form-control index-vali"></p>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn default" data-dismiss="modal">取消</button>
                <input id="btnSavePWD" type="button" class="btn btn-primary" value="确认"/>
            </div>
        </div>
    </div>
</div>

<!--[if lt IE 9]>
<script src="${path}/static/plugins/js/respond.min.js"></script>
<script src="${path}/static/plugins/js/excanvas.min.js"></script>
<![endif]-->
<script src="${path}/static/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${path}/static/plugins/js/moment.min.js" type="text/javascript"></script>
<script src="${path}/static/plugins/js/metronic.js" type="text/javascript"></script>
<script src="${path}/static/plugins/layout/scripts/layout.js" type="text/javascript"></script>
<script src="${path}/static/plugins/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<!-- select2 -->
<script src="${path}/static/plugins/select2/select2.min.js" type="text/javascript"></script>
<script src="${path}/static/plugins/jquery-multi-select/js/jquery.multi-select.js" type="text/javascript"></script>
<#--表格-->
<script src="${path}/static/plugins/bootstrap-table/js/bootstrap-table.js" type="text/javascript"></script>
<script src="${path}/static/plugins/bootstrap-table/js/bootstrap-table-zh-CN.js" type="text/javascript"></script>
<!-- 日期  -->
<script src="${path}/static/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"
        type="text/javascript"></script>
<script src="${path}/static/plugins/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"
        type="text/javascript"></script>
<script src="${path}/static/plugins/js/components-pickers.js" type="text/javascript"></script>
<#--弹框-->
<#--<script src="${path}/static/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>-->
<script src="${path}/static/js/common.js" type="text/javascript"></script>
<script src="${path}/static/js/bootstrapTableHelper.js" type="text/javascript"></script>
<script src="${path}/static/js/ajaxHelper.js" type="text/javascript"></script>
<script src="${path}/static/js/yui.js" type="text/javascript"></script>
<script src="${path}/static/js/pages/index.js?t=${.now?long}" type="text/javascript"></script>
<!--自定义部分-->
    <#nested>
<!-- END PAGE LEVEL SCRIPTS -->
<script type="text/javascript">
    jQuery(document).ready(function () {
        Metronic.init(); // init metronic core componets
        Layout.init(); // init layout
        yui.init();
    });
</script>
</body>
</html>
</#macro>
