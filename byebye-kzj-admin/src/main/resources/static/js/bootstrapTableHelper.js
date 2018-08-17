/**
 * Description:bootstraphelper帮助类
 * All Rights Reserved.
 *
 * @version 1.0  2017-9-13 16:51:31  by  zhangcz（zhangcz@cloud-young.com）创建
 */

(function ($) {

    /*默认参数*/
    var defaults = {
        tableId: 'listTable',
        height: undefined,
        url: '',
        method: 'POST',
        cache: false,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        toolbarId: 'toolbarId',
        idField: 'id',
        striped: true,
        showColumns: false,//是否显示 内容列下拉框
        pagination: true,
        paginationLoop: false,
        escape: true,
        sidePagination: 'server',
        showPaginationSwitch: false,//是否显示 数据条数选择框
        maintainSelected: true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
        clickToSelect: true,
        queryParamsType: 'pageNumber',
        pageNumber: 1,
        pageSize: 20,
        pageList: [10, 20, 30, 50],
        paginationHAlign: 'right',
        paginationPreText: '上页',
        paginationNextText: '下页',
        paginationFirstText: '首页',
        paginationLastText: '末页',
        columns: [],
        toolButtons: {
            formatter: undefined,
            events: undefined,
            buttons: []
        },//表格右上角新增或者添加按钮{buttonText:'新增',buttionClass:'btn'} 样式可改
        batchButtons: {
            formatter: undefined,
            events: undefined,
            buttons: []
        },//左下角 批量处理按钮
        queryParams: function (params) {
            return params;
        },
        responseHandler: function (obj) {

            if (obj.resultCode && obj.resultCode == 100005) {
                window.location.href = obj.data.redirect;
                return false;
            }
            else if (obj.resultCode && obj.resultCode == 100006) {
                return false;
            }
            else if (obj.result == false) {
                bootbox.alert({
                    message: obj.resultMessage,
                    buttons: {ok: {label: '确认', className: 'btn default'}}
                });
                return false;
            }
            // return obj.data;
            return {
                "rows": obj.data.rows,
                "total": obj.data.total
            }
        }
    };

    var btHelper = function () {
        this.options = {};
        this.tableDom = null;

        return {
            init: function (option) {
                var self = this;
                // 合并参数设置
                self.options = $.extend(true, {}, defaults, option);
                self.tableDom = $('#' + self.options.tableId);
                // bootstrap table初始化
                self.tableDom.bootstrapTable(self.options);
            },
            reload: function () {
                var self = this;
                self.tableDom.bootstrapTable('refresh');
            },
            uncheckAll: function () {
                var self = this;
                self.tableDom.bootstrapTable('uncheckAll');
            },
            destroy: function (tableId) {
                $("#" + tableId).bootstrapTable('destroy');
            },
            getSelections: function (tableId) {
                var rows = $("#" + tableId).bootstrapTable('getSelections');
                return rows;
            }
        };
    };

    window.bootStrapTableHelper = btHelper();

})(jQuery);