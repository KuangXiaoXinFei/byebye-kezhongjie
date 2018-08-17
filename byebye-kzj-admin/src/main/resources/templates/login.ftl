<!DOCTYPE html>
<html lang="en">
<head>
<#assign path=request.contextPath />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
    <link rel="stylesheet" href="${path}/static/css/login.css"/>
    <script type="text/javascript">
        baseUrlPath = '${path}';
    </script>
</head>
<body>
<div class="wrap">
    <div class="content">
        <div class="content-title">
            <div class="title-bold">北汽运营</div>
            <div class="title-weak">
                <div class="line"></div>
                <div>北汽运营管理系统</div>
            </div>
        </div>
        <form id="loginForm" method="post">
            <label>用户名</label>
            <p>
                <input name="userName" maxlength="26" type="text" placeholder="请输入用户名"/>
            </p>
            <label></label>
            <label>密码</label>
            <p class="login_pass">
                <input id="password" name="password" maxlength="26" type="password" placeholder="请输入密码"/>
            </p>
            <label class="loginErrorMsg"><span></span></label>
        <#--<div class="c_password">-->
        <#--<input type="checkbox"/><span>下次自动登录</span>-->
        <#--<a href="javascript:;" class="forgetPassword">忘记密码？</a>-->
        <#--</div>-->
            <div class="login-box">
                <input type="button" class="login" id="loginBtn" value="登录"/>
            </div>
        </form>
    </div>
</div>
<div class="footer">
    <p>
        <a href="#">著作权与商标声明</a href="#">
        <a href="#">法律声明</a href="#">
        <a href="#">服务条款</a href="#">
        <a href="#">隐私政策</a href="#">
        <a href="#">关于北汽运营管理系统</a href="#">
        <a href="#">联系我们</a href="#">
    </p>
    <p>
        2018 © 北京云漾信息科技有限公司
    </p>
</div>
</body>
<script type="text/javascript" src="${path}/static/plugins/js/jquery.min.js"></script>
<script src="${path}/static/js/ajaxHelper.js" type="text/javascript"></script>
<script type="text/javascript" src="${path}/static/js/login.js"></script>
</html>