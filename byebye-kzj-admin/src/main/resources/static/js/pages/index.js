(function ($) {
    var page = {};

    page.init = function () {
        page.getUser();
        $('#btnmodifypwd').click(function () {
            $('#modifyPwd').modal('show');
        });

        $('#btnSavePWD').click(function () {
            page.saveUserPwd();
        });
    };
    page.getUser = function () {
        ajaxHelper.doPost({
            url: baseUrlPath + '/getUser',
            success: function (res) {
                if (res && res.code == 200) {
                    var data = res.data;
                    $('.page-header').find('span.username-hide-on-mobile').text(data.showName);
                }
            },
            error: function (ex) {
                console.log(ex);
            }
        });
    };
    page.saveUserPwd = function () {

        var er = page.pwdCheck();
        if (!(er.length == 0)) {
            $("#errorPlace").find('p').text(er);
            $("#errorPlace").show();
            return;
        }
        $("#errorPlace").hide();
        $('#btnSavePWD').attr('disabled','disabled');
        ajaxHelper.doPost({
            url: baseUrlPath + '/authAccount/updatePassword',
            async: false,
            data: {
                oldpassword: $("#oldPassword").val(),
                newPassword: $("#newPassword").val()
            },
            success: function (obj) {
                $('#btnSavePWD').removeAttr('disabled');
                if (obj.code != 200) {
                    $("#errorPlace").find('p').text(obj.msg);
                    $("#errorPlace").show();
                } else {
                    $("#errorPlace").find('p').text('修改成功，3秒后跳转登录页重新登录');
                    $("#errorPlace").show();
                    setTimeout(function () {
                        // 修改成功 退出系统
                        window.location.href = baseUrlPath + "/logout";
                    }, 3000);
                }
            },error:function () {
                $('#btnSavePWD').removeAttr('disabled');
            }
        });
    };
    page.pwdCheck = function () {
        var oldPwd = $("#oldPassword").val();
        var newPwd = $("#newPassword").val();
        var rptPwd = $("#renewPassword").val();
        var error = "";
        if (!oldPwd || oldPwd.length < 6 || oldPwd.length > 45) {
            error = "旧密码不合法";
            return error;
        }
        if (!newPwd || newPwd.length < 6 || newPwd.length > 45) {
            error = "新密码不合法";
            return error;
        }
        if (newPwd === oldPwd) {
            error = "新密码不可与旧密码相同";
            return error;
        }
        if (newPwd !== rptPwd) {
            error = "两次密码不一致";
            return error;
        }
        return error;
    };

    page.init();
})(jQuery);