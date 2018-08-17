var page = {
    basePath: baseUrlPath,
    app_vue: ""
};
$(function () {
    page.initTable();
});
page.initTable = function () {
    page.app_vue = new Vue({
        el: "#vue_mian",
        data: {
            list: [],
            total: 0,
            queryParams: {
                commentId: "",
                commentContent: "",
                userId: "",
                userName: "",
                relaCommentId: "",
                newsId: "",
                title: "",
                minCreateTime: "",
                maxCreateTime: "",
                pageIndex: 1,
                pageSize: 20
            }

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
                var _params = vue.queryParams;
                if (pageIndex && pageSize) {
                    _params.pageIndex = pageIndex;
                    _params.pageSize = pageSize;
                } else {
                    _params.pageIndex = 1;
                    _params.pageSize = 20;
                }
                _params.commentId = $.trim($("#select_commentId").val());
                _params.commentContent = $.trim($("#commentContent").val());
                _params.userId = $.trim($("#userId").val());
                _params.userName = $.trim($("#userName").val());
                _params.relaCommentId = $.trim($("#relaCommentId").val());
                _params.newsId = $.trim($("#newsId").val());
                _params.title = $.trim($("#title").val());
                _params.minCreateTime = $('#startTime').val();
                _params.maxCreateTime = $('#endTime').val();
                ajaxHelper.doPost({
                    url: page.basePath + '/comment/getList',
                    data: _params,
                    success: function (result) {
                        if (result.code == 200) {
                            vue.list = result.data.rows;
                            vue.total = result.data.total;
                        } else {
                            yui.toastTips.show("获取列表数据失败！");
                        }
                    },
                    error: function () {
                        yui.toastTips.show("获取列表数据失败！");
                    }
                });
            },
            formatDate: function (value) {
                if (!value) return '';
                return dataUtil.changeDateFormat(value);
            },
            deleteModal:function (commentId) {
                $("#commentId").val(commentId);
                $("#deleteLabel").text("确认对评论"+commentId+"进行删除吗？");
                $("#deleteModal").modal("show");
            },
            deleteComment:function () {
                var vue = this;
                ajaxHelper.doPost({
                    url: page.basePath + '/comment/deleteComment',
                    data: {
                        "commentId":$.trim($("#commentId").val())
                    },
                    success: function (result) {
                        if (result.code == 200) {
                            vue.cancle();
                            vue.getList();
                            yui.toastTips.show("删除成功！");
                        } else {
                            yui.toastTips.show("删除失败！");
                        }
                    },
                    error: function () {
                        yui.toastTips.show("删除失败！");
                    }
                });
            },
            cancle:function () {
                $("#commentId").val("");
                $("#deleteLabel").text("确认对该评论进行删除吗？");
                $("#deleteModal").modal("hide");
            }
        }
    });
}
