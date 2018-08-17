var page = {
    basePath: baseUrlPath,
    vue: null
};

$(function () {
    page.init();
});
page.init = function () {
    page.initVue();
    page.ValidInput();
};

page.initVue = function () {
    page.vue = new Vue({
        el: "#vue_main",
        data: {
            list: [],
            queryParam: {
                userId: '',
                userName: '',
                isTalk: -1,
                userType: -1,
                startTime: '',
                endTime: '',
                pageIndex: 1,
                pageSize: 20
            },
            userInfo: {userId: '0', sex: '1'},
            total: 0
        },
        mounted: function () {
            this.getList();
        },
        methods: {
            getList: function (pageIndex, pageSize) {
                var vue = this;
                var param = vue.queryParam;
                if (pageIndex && pageSize) {
                    param.pageIndex = pageIndex;
                    param.pageSize = pageSize;
                } else {
                    param.pageIndex = 1;
                    param.pageSize = 20;
                }
                param.userName = $.trim(param.userName);
                param.isTalk = $("#txtTalk").val();
                param.userType = $("#txtUserType").val();
                param.startTime = $('#startTime').val();
                param.endTime = $('#endTime').val();
                ajaxHelper.doGet({
                    url: page.basePath + '/user/getList',
                    data: param,
                    success: function (result) {
                        vue.list = result.data.data;
                        vue.total = result.data.rows;
                    },
                    error: function () {

                    }
                });
            },
            formatDate: function (value) {
                if (!value) return '';
                return dataUtil.changeDateFormat(value);
            },
            resetValue: function () {
                var vue = this;
                vue.queryParam.userId = "";
                vue.queryParam.userName = "";
                $("#txtTalk").select2("val", -1);
                $("#txtUserType").select2("val", -1);
                vue.queryParam.startTime = "";
                vue.queryParam.endTime = "";
            }
            ,
            addUser: function () {
                var vue = this;
                vue.cancelUser();
                $("#addUser").modal("show");
            }
            ,
            saveUser: function () {
                var vue = this;
                var mainValid = $("#addUserForm").valid();
                if (!mainValid) {
                    return;
                }
                var value = $("#files").val();
                if (value == "" || $("#picUrl").val() == "") {
                    yui.toastTips.show('请上传头像！');
                    return;
                }

                var params = new FormData();
                params.append("userId", vue.userInfo.userId);
                params.append("userName", $.trim(vue.userInfo.userName));
                params.append("mobile", vue.userInfo.mobile);
                params.append("sex", vue.userInfo.sex);
                params.append("files", $("#files").get(0).files[0]);
                $("#btnSave").attr("disabled", "disabled");
                ajaxHelper.doPost({
                    data: params,
                    url: page.basePath + '/user/saveUser',
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (result) {
                        if (result.code == '200') {
                            yui.toastTips.show(result.data);
                            $("#btnSave").removeAttrs("disabled");
                        } else {
                            yui.toastTips.show(result.msg);
                            $("#btnSave").removeAttrs("disabled");
                            return;
                        }
                        vue.getList();
                        vue.cancelUser();
                    },
                    error: function () {
                        yui.toastTips.show("保存失败！");
                    }
                })
            }

            ,
            cancelUser: function () {
                var vue = this;
                vue.userInfo.userId = 0;
                vue.userInfo.userName = '';
                vue.userInfo.mobile = '';
                vue.userInfo.sex = 1;
                vue.userInfo.avatar = '';
                $("#addUser").modal("hide");
                $("#addUserForm").find('.form-group').removeClass('has-error');
                $("#addUserForm").validate().resetForm();
                $("#addUserForm").find('input').val('');
                $("#setTalkModal").modal("hide");
                $("#userId").val(0);
                $("#userName").val('');
                $('#img_id').css('background-image', '');
                $('#img_id').css('background-repeat', '');
                $("#picUrl").val('');
                $("#files").val('');
            }
            ,
            confimSetTalk: function (userId, userName, isTalk) {
                if (isTalk == "1") {
                    $("#txtTitle").text("禁言提示");
                    $("#txtConfirmTile").text("确定对用户" + userName + "进行禁言操作吗?");
                }
                else {
                    $("#txtTitle").text("取消禁言提示");
                    $("#txtConfirmTile").text("确定对用户" + userName + "进行取消禁言操作吗?");
                }
                $("#userId").val(userId);
                $("#userName").val(userName);
                $("#isTalk").val(isTalk);
                $("#setTalkModal").modal("show");
            }
            ,
            setTalk: function () {
                page.setTalk();
            }
            ,
            toMyNews: function (userId) {
                window.location.href = baseUrlPath + "/news/list?userId=" + userId;
            }
        }
    });
};

jQuery.validator.addMethod("isRepeatUserName", function (value, element) {
    var istrue = false;
    ajaxHelper.doGet({
        data: {value: value, type: 1},
        url: page.basePath + '/user/isRepeatUser',
        async: false,
        success: function (result) {
            if (result.code == 200 && result.data == false) {
                istrue = true;
            }
        }
    });
    return istrue;
}, "用户名已存在");
jQuery.validator.addMethod("isMobile", function (value, element) {
    var length = value.length;
    var mobile = /^1[34578]\d{9}$/;
    /*/^1(3|4|5|7|8)\d{9}$/*/
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请输入正确的手机号码");
jQuery.validator.addMethod("isRepeatMobile", function (value, element) {
    var istrue = false;
    ajaxHelper.doGet({
        data: {value: value, type: 2},
        url: page.basePath + '/user/isRepeatUser',
        async: false,
        success: function (result) {
            if (result.code == 200 && result.data == false) {
                istrue = true;
            }
        }
    })
    return istrue;
}, "手机号已存在");

//验证
page.ValidInput = function () {
    formValidateHelper.init({
        formId: "addUserForm",
        rules: {
            "txtUserName": {
                required: true,
                maxlength: 20,
                isRepeatUserName: true
            },
            "txtMobile": {
                required: true,
                minlength: 11,
                maxlength: 11,
                digits: true,
                number: true,
                isMobile: true,
                isRepeatMobile: true
            }
        },
        messages: {
            "txtUserName": {
                required: '请输入用户名',
                maxlength: '不能超过20个字符',
                isRepeatAccountName: '用户名已存在',
            },
            "txtMobile": {
                required: '请输入手机号',
                minlength: '请输入正确的手机号',
                maxlength: '请输入正确的手机号',
                digits: '必须是数字',
                number: '请输入有效数字',
                isMobile: '请输入正确的手机号',
                isRepeatMobile: '手机号已存在'
            }
        }
    });
}

page.setTalk = function () {
    ajaxHelper.doPost({
            url: page.basePath + '/user/setUserTalk',
            data: {
                "userId": $("#userId").val(),
                "isTalk": $("#isTalk").val(),
            },
            success: function (result) {
                if (result.code == '200') {
                    var talk = $("#isTalk").val();
                    if (talk == 1) {
                        yui.toastTips.show("已将用户" + $("#userName").val() + "禁言。");
                    }
                    else {
                        yui.toastTips.show("已将用户" + $("#userName").val() + "取消禁言。");
                    }
                    page.vue.getList();
                }
                else {
                    yui.toastTips.show("操作失败");
                }
                $("#setTalkModal").modal("hide");
            },
            error: function () {
                yui.toastTips.show("操作失败");
            }
        }
    );
}

function uploadImg(obj) {
    var file = obj.files[0];
    var filename = file.name;
    $("#picUrl").val(filename);
    var fileTArr = filename.split(".");
    var filetype = fileTArr[fileTArr.length - 1];
    //切割出后缀文件名
    if (filetype != "jpg" && filetype != "png") {
        $("#picUrl").val('');
        $("#files").val('');
        yui.toastTips.show("上传图片格式不适合");
        return;
    }
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function (e) {
        $('#img_id').css('background-image', 'url(' + this.result + ')')
        $('#img_id').css('background-repeat', 'no-repeat')
    }
}