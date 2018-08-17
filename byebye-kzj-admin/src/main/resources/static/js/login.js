var page = {
    path: null,
    lastSeconds: 60 //倒计时
};
page.init = function () {
    page.path = baseUrlPath;
    //注册事件
    page.register();
};
page.register = function () {
    $('#loginBtn').click(function () {
        page.doLogin();
    });
    //回车
    $(this).keydown(function (e) {
        if (e.which == "13") {
            page.doLogin();
        }
    });
    // 清空登陆错误的信息
    $("#password").focus(function () {
        $(".loginErrorMsg").find("span").text("")
    });
    //忘记密码
    $(".forgetPassword").on('click', function () {
        page.clearError();
        $(".tan").css("display", "block");
        $(".tan_mima").css("display", "block");
    });
    // 关闭所有的弹框幕布--`X`
    $(".shut").click(function () {
        $(".tan_mima2").css("display", "none");
        $(".tan_mima").css("display", "none");
        $(".tan").css("display", "none");
    })
};
page.doLogin = function () {
    $(".loginErrorMsg").find("span").text("");
    $('#loginBtn').attr('disabled','disabled');
    ajaxHelper.doPost({
        url: page.path + '/dologin',
        data: $("#loginForm").serialize(),
        success: function (obj) {
            $('#loginBtn').removeAttr('disabled');
            if (obj.code == '200') {
                window.location.href = page.path + obj.data
            } else {
                $(".loginErrorMsg").find("span").text(obj.msg)
            }
        },
        error:function (obj) {
            $(".loginErrorMsg").find("span").text(obj.msg)
        }
    });
};
// 登陆表单
page.initLoginFormValid = function () {
    formValidateHelper.init({
        formId: "loginForm",
        rules: {
            "userName": {
                required: true,
                maxlength: 45
            },
            "password": {
                required: true,
                maxlength: 45
            }
        },
        messages: {
            "userName": {
                required: '用户名不为空',
                maxlength: ''
            },
            "password": {
                required: '密码不为空',
                maxlength: ''
            }
        },
        errorPlacement: function (error, element) { //错误信息位置设置方法
            error.appendTo(element.parent().next(".log-error")); //这里的element是录入数据的对象
        },
        submitHandler: function (form) {
            //清空之前的错误
            if (page.validLogin()) {
                form.submit();
            }
        }
    });
};
$(function () {
    //初始化
    page.init();
});