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
                pushId: "",
                vin: "",
                level: "",
                mobile:"",
                userName: "",
                minCreateTime: "",
                maxCreateTime: "",
                minOccurTime:"",
                maxOccurTime:"",
                pageIndex: 1,
                pageSize: 20
            },
            levelList:[]
        },
        mounted: function () {
            this.init_dom();
            this.getLevelList();
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
                _params.pushId = $.trim($("#pushId").val());
                _params.vin = $.trim($("#vin").val());
                _params.mobile = $.trim($("#mobile").val());
                _params.userName = $.trim($("#userName").val());
                _params.level = $.trim($("#level").val());
                _params.minOccurTime = $.trim($("#minOccurTime").val());
                _params.maxOccurTime = $.trim($("#maxOccurTime").val());
                _params.minCreateTime = $('#minCreateTime').val();
                _params.maxCreateTime = $('#maxCreateTime').val();
               ajaxHelper.doPost({
                    url: page.basePath + '/pushAlert/getList',
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
            getLevelList:function () {
                var vue = this;
                ajaxHelper.doPost({
                    url: page.basePath + '/pushAlert/getLevel',
                    success: function (result) {
                        if (result.code == 200) {
                            vue.levelList = result.data;
                        } else {
                            yui.toastTips.show("获取告警级别数据失败！");
                        }
                    },
                    error: function () {
                        yui.toastTips.show("获取告警级别数据失败！");
                    }
                });
            }
        }
    });
}
