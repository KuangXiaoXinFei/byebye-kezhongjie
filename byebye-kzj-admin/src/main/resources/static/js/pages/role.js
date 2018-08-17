var page = {
    basePath: baseUrlPath,
    app_vue: ""
};
$(function () {
    page.initTable();
    page.ValidInput();
});
page.initTable = function () {
    page.app_vue = new Vue({
        el: "#vue_mian",
        data: {
            roleList: [],
            total: 0,
            pageIndex: 1,
            pageSize: 20
        },
        mounted: function () {
            this.init_dom();
        },
        methods: {
            init_dom: function () {
                this.getList();
            },
            getList: function (pageIndex, pageSize) {
                var vue = this;
                if (pageIndex && pageSize) {
                    vue.pageIndex = pageIndex;
                    vue.pageSize = pageSize;
                } else {
                    vue.pageIndex = 1;
                    vue.pageSize = 20;
                }
                ajaxHelper.doPost({
                    url: page.basePath + '/role/getList',
                    data: {
                        pageIndex: vue.pageIndex,
                        pageSize: vue.pageSize
                    },
                    success: function (result) {
                        if (result.code == "200") {
                            vue.roleList = result.data.data;
                            vue.total = result.data.rows;
                        } else {
                            yui.toastTips.show("获取列表数据失败！");
                        }
                    },
                    error: function () {
                        yui.toastTips.show("获取列表数据失败！");
                    }
                });
            },
            getAllCkId: function () {
                var ids = [];
                $.each($(".modal_ul .li_checked"), function (i, item) {
                    var id = item.id;
                    ids.push(id);
                })
                return ids;
            },
            editRole: function (roleId) {
                page.clear();
                $("#roleId").val(roleId);
                page.getDatas();
            },
            confimDelete: function (roleId, roleName) {
                $("#deleteText").text("确认对" + roleName + "角色进行删除操作吗?");
                $("#roleId").val(roleId);
                $("#deleteModal").modal("show");
            },
            deleteRole: function () {
                var vue = this;
                ajaxHelper.doPost({
                    data: {
                        "roleId": $("#roleId").val()
                    },
                    url: page.basePath + '/role/delete',
                    success: function (result) {
                        if (result.code == 200) {
                            yui.toastTips.show("删除成功！");
                            vue.cancleRole();
                            vue.getList();
                        } else {
                            yui.toastTips.show(result.msg);
                        }
                    },
                    error: function () {
                        yui.toastTips.show("删除失败！");
                    }
                });
            },
            addRole: function () {
                page.clear();
                page.getDatas();
            },
            cancleRole: function () {
                $("#roleModal").modal("hide");
                $("#deleteModal").modal("hide");
                page.clear();
            },
            saveOrUpdate: function () {
                var vue = this;
                var mainValid = $("#addRoleForm").valid();
                if (!mainValid) {
                    return;
                }
                var ck = $(".modal_ul .li_checked").length;
                if (ck <= 0) {
                    yui.toastTips.show("请至少选择一个资源！");
                    return;
                }
                var ids = this.getAllCkId();
                $("#saveBtn").attr('disabled', 'disabled');
                ajaxHelper.doPost({
                    data: {
                        "roleId": $("#roleId").val(),
                        "roleName": $.trim($("#roleName").val()),
                        "ids": ids.join(",")
                    },
                    url: page.basePath + '/role/saveOrUpdate',
                    success: function (result) {
                        $("#saveBtn").removeAttr('disabled');
                        if (result.code == 200) {
                            yui.toastTips.show(result.data);
                            var roleId = $("#roleId").val();
                            if (roleId != null && roleId > 0) {
                                vue.getList(vue.pageIndex, vue.pageSize);
                            } else {
                                vue.getList();
                            }
                            vue.cancleRole();
                        } else {
                            yui.toastTips.show(result.msg);
                        }
                    },
                    error: function () {
                        $("#saveBtn").removeAttr('disabled');
                        yui.toastTips.show("保存失败！");
                    }
                });
            }
        }
    });
}
page.ckAll = function (obj) {
    var tag = $(obj).is(":checked");
    $(obj).parents().siblings("#ulDiv").find(":checkbox").prop("checked", tag);
    if (tag) {
        $(obj).parents().siblings("#ulDiv").find(":checkbox").addClass("li_checked");
    } else {
        $(obj).parents().siblings("#ulDiv").find(":checkbox").removeClass("li_checked");
    }
}
page.ckOne = function (obj) {
    var tag = $(obj).is(":checked");
    if (tag) {
        $(obj).addClass("li_checked");
    } else {
        $(obj).removeClass("li_checked");
    }
    var isQuan = true;
    $(obj).parents(".modal_ul").find(":checkbox").each(function (i, e) {
        if ($(e).is(":checked") === false) {
            isQuan = false;
        }
    });
    $(obj).parents().find(".allAuth").prop("checked", isQuan);
}
page.ValidInput = function () {
    formValidateHelper.init({
        formId: "addRoleForm",
        rules: {
            "roleName": {
                required: true,
                maxlength: 10
            }
        },
        messages: {
            "roleName": {
                required: '请输入角色名称',
                maxlength: '角色名称长度不能超过10'
            }
        }
    });
}
page.createResourceHtml = function (allResource, ckResource) {
    $.each(allResource, function (i, item) {
        $("#auth_ul").append('<li>' +
            '   <label class="checkbox-inline">' +
            '       <input class="auth_li ' + (page.isCkResource(item.resourceId, ckResource) ? 'li_checked' : "") + '"' +
            (page.isCkResource(item.resourceId, ckResource) ? 'checked="checked"' : '') +
            '       onclick="page.ckOne(this)" type="checkbox" id="' + item.resourceId + '" name="auth_li" />' + item.resourceName +
            '   </label>' +
            '</li>');
    });
    if (ckResource != null && ckResource.length == allResource.length) {
        $("#allAuth").prop("checked", true);
    }
}
page.isCkResource = function (id, ckList) {
    if (ckList == null || ckList.length == 0) {
        return false
            ;
    }
    for (var i = 0; i < ckList.length; i++) {
        if (ckList[i].resourceId === id) {
            return true;
        }
    }
    return false;
}
page.getDatas = function () {
    ajaxHelper.doPost({
        url: page.basePath + '/role/getDatas',
        data: {
            "roleId": $("#roleId").val()
        },
        success: function (result) {
            if (result.data.ckResource) {
                page.createResourceHtml(result.data.allResource, result.data.ckResource.authList);
                $("#roleName").val(result.data.ckResource.roleName);
            } else {
                page.createResourceHtml(result.data.allResource, null);
            }
            $("#roleModal").modal("show");
        },
        error: function () {
            yui.toastTips.show("获取资源列表失败！");
        }
    });
}

page.clear = function () {
    $("#roleId").val("0");
    $("#roleName").val("");
    $(".modal_ul").html('');
    $("#allAuth").prop("checked", false);
    $("#addRoleForm").find('.form-group').removeClass('has-error');
    $("#addRoleForm").validate().resetForm();
}