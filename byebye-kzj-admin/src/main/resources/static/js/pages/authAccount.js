var page = {
    basePath: baseUrlPath,
    vue: null
};
$(function () {
    page.initVue();
    page.ValidInput();
});

page.initVue = function () {
    page.vue = new Vue({
        el: "#vue_main",
        data: {
            list: [],
            queryParam: {
                accountName: '',
                mobile: '',
                email: '',
                realName: '',
                roleId: 0,
                pageIndex: 1,
                pageSize: 20
            },
            roleItems: [],
            accountInfo: {},
            total: 0
        },
        mounted: function () {
            this.getRoleList();
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
                var role = $("#txtRole").val();
                param.roleId = role;
                param.accountName = $.trim(param.accountName);
                param.realName= $.trim(param.realName);
                param.email= $.trim(param.email);
                param.mobile= $.trim(param.mobile);
                ajaxHelper.doGet({
                    url: page.basePath + '/authAccount/getList',
                    data: param,
                    success: function (result) {
                        vue.list = result.data.data;
                        vue.total = result.data.rows;
                    },
                    error: function () {

                    }
                });
            },
            resetValue: function () {
                var vue = this;
                vue.queryParam.accountName = "";
                vue.queryParam.mobile = "";
                vue.queryParam.email = "";
                vue.queryParam.realName = "";
                $("#txtRole").select2("val", 0);
            }
            ,
            getRoleList: function () {
                var vue = this;
                ajaxHelper.doGet({
                    url: page.basePath + '/authAccount/getRoleList',
                    success: function (result) {
                        vue.roleItems = result.data;
                    }
                });
            }
            ,
            addAccount: function () {
                $("#txtTitle").text("添加账户");
                page.clearAccount();
                page.getData();
            }
            ,
            editData: function (accountId) {
                page.clearAccount();
                $("#accountId").val(accountId);
                page.getData();
                $("#txtTitle").text("修改账户");
            },
            saveAccount: function () {
                var vue = this;
                var mainValid = $("#addAccountForm").valid();
                if (!mainValid) {
                    return;
                }
                var roleId = $("#selRoleId").select2("val");
                vue.accountInfo.roleId = roleId;
                vue.accountInfo.accountName = $.trim(vue.accountInfo.accountName);
                vue.accountInfo.realName = $.trim(vue.accountInfo.realName);
                ajaxHelper.doPost({
                    data: vue.accountInfo,
                    url: page.basePath + '/authAccount/saveData',
                    success: function (result) {
                        if (result.code == '200') {
                            yui.toastTips.show(result.data);
                        } else {
                            yui.toastTips.show(result.msg);
                            return;
                        }

                        var accountId = $("#accountId").val();
                        if (accountId != null && accountId > 0) {
                            vue.getList(vue.pageIndex, vue.pageSize);
                        } else {
                            vue.getList();
                        }
                        vue.cancelAccount();
                    },
                    error: function () {
                        yui.toastTips.show("保存失败！");
                    }
                })
            },
            cancelAccount: function () {
                page.clearAccount();
            }
            ,
            confimDelete: function (accountId, accountName) {
                $("#deleteText").text("确认对账户" + accountName + "进行删除操作吗?");
                $("#accountId").val(accountId);
                $("#delAccount").modal("show");
            }
            ,
            deleteData: function () {
                page.deleteData();
            }
            ,
            confimResetPassword: function (accountId, accountName) {
                $("#resetText").text("确认对账户" + accountName + "密码进行重置操作吗?");
                $("#accountId").val(accountId);
                $("#accountName").val(accountName);
                $("#resetPasswordModal").modal("show");
            }
            ,
            resetPassword: function () {
                page.resetData();
            }
        }
    });
};

jQuery.validator.addMethod("isMobile", function (value, element) {
    var length = value.length;
    var mobile = /^1[34578]\d{9}$/;
    /*/^1(3|4|5|7|8)\d{9}$/*/
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请输入正确的手机号码");
jQuery.validator.addMethod("isRepeatAccountName", function (value, element) {
    var istrue = false;
    ajaxHelper.doGet({
        data: {accountId: $("#accountId").val(), value: $.trim(value), type: 1},
        url: page.basePath + '/authAccount/isRepeatAccount',
        async: false,
        success: function (result) {
            if (result.code == 200 && result.data == false) {
                istrue = true;
            }
        }
    });
    return istrue;
}, "用户名已存在");
jQuery.validator.addMethod("isRepeatMobile", function (value, element) {
    var istrue = false;
    ajaxHelper.doGet({
        data: {accountId: $("#accountId").val(), value: value, type: 2},
        url: page.basePath + '/authAccount/isRepeatAccount',
        async: false,
        success: function (result) {
            if (result.code == 200 && result.data == false) {
                istrue = true;
            }
        }
    })
    return istrue;
}, "手机号已存在");
jQuery.validator.addMethod("isSelectRole", function () {
    var roleId = $("#selRoleId").select2("val");
    return roleId > 0;
}, "请选择角色");

//验证
page.ValidInput = function () {
    formValidateHelper.init({
        formId: "addAccountForm",
        rules: {
            "txtAccountName": {
                required: true,
                maxlength: 20,
                isRepeatAccountName: true
            },
            "txtRealName": {
                required: true,
                maxlength: 20
            },
            "txtMobile": {
                required: true,
                minlength: 11,
                maxlength: 11,
                digits: true,
                number: true,
                isMobile: true,
                isRepeatMobile: true
            },
            "txtEmail": {
                email: true,
                maxlength: 100
            },
            "selRoleId": {
                isSelectRole: true
            }
        },
        messages: {
            "txtAccountName": {
                required: '请输入用户名',
                maxlength: '不能超过20个字符',
                isRepeatAccountName: '用户名已存在',
            },
            "txtRealName": {
                required: '请输入真实姓名',
                maxlength: '不能超过20个字'
            },
            "txtMobile": {
                required: '请输入手机号',
                minlength: '请输入正确的手机号',
                maxlength: '请输入正确的手机号',
                digits: '必须是数字',
                number: '请输入有效数字',
                isMobile: '请输入正确的手机号',
                isRepeatMobile: '手机号已存在'
            },
            "txtEmail": {
                email: '请输入正确的邮箱',
                maxlength: '不能超过100个字符'
            },
            "selRoleId": {
                isSelectRole: '请选择角色'
            }
        }
    });
}

page.getData = function () {
    ajaxHelper.doGet({
        url: page.basePath + '/authAccount/getDetail',
        data: {
            "accountId": $("#accountId").val()
        },
        async: false,
        success: function (result) {
            var vue = page.vue;
            vue.accountInfo = result.data;
            $("#selRoleId").select2("val", vue.accountInfo.roleId);
            $("#addAccount").modal("show");
        },
        error: function () {
        }
    });
}

page.deleteData = function () {
    ajaxHelper.doPost({
        url: page.basePath + '/authAccount/deleteAccount',
        data: {
            "accountId": $("#accountId").val()
        },
        success: function (result) {
            if (result.code == '200') {
                yui.toastTips.show(result.msg);
                page.vue.getList();
            }
            $("#delAccount").modal("hide");
        },
        error: function () {
            yui.toastTips.show("删除账户失败！");
        }
    });
}

page.resetData = function () {
    ajaxHelper.doPost({
            url: page.basePath + '/authAccount/resetPassword',
            data: {
                "accountId": $("#accountId").val()
            },
            success: function (result) {
                if (result.code == '200') {
                    $("#resetSuccessText").text("已将账户" + $("#accountName").val() + "密码重置为123456。");
                    $("#resetSuccessModal").modal("show");
                }
                else {
                    yui.toastTips.show("密码初始化失败");
                }
                $("#resetPasswordModal").modal("hide");
            },
            error: function () {
                yui.toastTips.show("密码初始化失败");
            }
        }
    );
}

page.clearAccount=function () {
    var vue = page.vue;
    vue.accountInfo.accountId = 0;
    vue.accountInfo.accountName = '';
    vue.accountInfo.realName = '';
    vue.accountInfo.mobile = '';
    vue.accountInfo.roleId = 0;
    $("#addAccount").modal("hide");
    $("#addAccountForm").find('.form-group').removeClass('has-error');
    $("#addAccountForm").validate().resetForm();
    $("#resetPasswordModal").modal("hide");
    $("#delAccount").modal("hide");
    $("#accountId").val(0);
    $("#accountName").val('');
}