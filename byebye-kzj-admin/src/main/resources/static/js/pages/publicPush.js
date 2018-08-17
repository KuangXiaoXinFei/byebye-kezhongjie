var page = {
    basePath: baseUrlPath,
    app_vue: ""
};
$(function () {
    page.initTable();
    page.register();
});
page.register=function () {
    $("#pushContent").on('keyup', function() {
        if(this.value.length>200){
            $(".noteText").html(200);
        }else{
            $(".noteText").html(this.value.length);
        }
    })
}
page.initTable = function () {
    page.app_vue = new Vue({
        el: "#vue_mian",
        data: {
            list: [],
            total: 0,
            queryParam: {
                publicId: '',
                minCreateTime: '',
                maxCreateTime: '',
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
                var _param = vue.queryParam;
                _param.publicId = $.trim($("#publicId").val())
                _param.minCreateTime = $('#startDate').val();
                _param.maxCreateTime = $('#endDate').val();
                if (pageIndex && pageSize) {
                    _param.pageIndex = pageIndex;
                    _param.pageSize = pageSize;
                } else {
                    _param.pageIndex = 1;
                    _param.pageSize = 20;
                }
                vue.queryParam = _param;
                ajaxHelper.doPost({
                    url: page.basePath + '/publicPush/getList',
                    data: _param,
                    success: function (result) {
                        if(result.code == "200"){
                            vue.list = result.data.data;
                            vue.total = result.data.rows;
                        }else{
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
            cancleModal:function () {
                page.clearPush();
            },
            save: function () {
                var vue = this;
                var content = $.trim($("#pushContent").val());
                if(!content){
                    yui.toastTips.show('消息内容不能为空！');
                    return;
                }
                $("#saveBtn").attr('disabled', 'disabled');
                ajaxHelper.doPost({
                    url: page.basePath + '/publicPush/save',
                    data: {
                        "content":content
                    },
                    success: function (result) {
                        $("#saveBtn").removeAttr('disabled');
                        if(result.code == 200){
                            vue.cancleModal();
                            vue.getList();
                            yui.toastTips.show('推送成功！');
                        }else{
                            yui.toastTips.show("推送失败！");
                        }
                    },
                    error: function () {
                        $("#saveBtn").removeAttr('disabled');
                        yui.toastTips.show("推送失败！");
                    }
                });

            },
            addPush:function () {
                page.clearPush();
                $("#pushModal").modal("show");
            }
        }
    });
}
page.clearPush=function () {
    $("#pushModal").modal("hide");
    $("#pushContent").val("");
}
