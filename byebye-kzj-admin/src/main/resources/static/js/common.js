/**
 * 字符串格式化
 * 占位符 '%s', 当参数为undefined返回 ''
 * 用法: sprintf('this is %s word, %s ','hello',1);
 */
var sprintf = function (str) {
    var args = arguments,
        flag = true,
        i = 1;

    str = str.replace(/%s/g, function () {
        var arg = args[i++];

        if (typeof arg === 'undefined') {
            flag = false;
            return '';
        }
        return arg;
    });
    return flag ? str : '';
};

/**
 * 下拉框数据绑定帮助类
 * by 刘风栓(liufs@cloud-young.com)
 */
(function ($) {

    var defaults = {
        selector: '',
        method: 'post',
        url: '',
        data: {},
        optionText: '',
        optionValue: '',
        placeholderText: '请选择',
        placeholderValue: '',
        loadSuccess: function (data) {
            return true;
        },
        loadError: function (status) {
            return true;
        }
    };

    var selectHelper = function () {
        this.options = {};
        this.$element = undefined;

        return {
            init: function (option) {
                // 合并参数设置
                this.options = $.extend(true, {}, defaults, option);
                this.$element = $(this.options.selector);
                if (this.options.url.length == 0
                    || this.options.selector.length == 0) {
                    return;
                }
                this.initServer(this.options, this.$element);
            },
            empty: function () {
                this.$element.empty();
            },
            initServer: function (option, element) {
                var that = this;
                var $options = option;
                var $element = element;
                if ($element == undefined || $options.url == undefined) {
                    return;
                }
                $element.empty();

                ajaxHelper.doPost({
                    url: that.options.url,
                    data: that.options.data,
                    success: function (res) {
                        if (res && res.result) {
                            that.createOption(res.data, $options, $element);
                            that.trigger('loadSuccess', $options, $element, res);
                        }
                    },
                    error: function (dataR) {
                        that.trigger('loadError', $options, $element, dataR);
                    }
                });
            },
            createOption: function (data, options, element) {
                var that = this;
                var $element = element;
                var $options = options;
                $element.empty();
                var $optionHtml = [];
                $optionHtml.push('<option value="', $options.placeholderValue, '">', $options.placeholderText, '</option>');
                $.each(data, function (i, item) {

                    $optionHtml.push('<option value="');
                    if (item.hasOwnProperty($options.optionValue)) {
                        $optionHtml.push(item[$options.optionValue]);
                    }
                    $optionHtml.push('">');
                    if (item.hasOwnProperty($options.optionText)) {
                        var text = item[$options.optionText];
                        $optionHtml.push(text);
                    }
                    //$optionHtml.push(item.applicationName);
                    $optionHtml.push('</option>');
                });

                $element.append($optionHtml.join(''));
            },
            trigger: function (name, option, element) {
                var $element = element;
                var $options = option;
                var args = Array.prototype.slice.call(arguments, 3);
                $options[name].apply($options, args);
                $element.trigger($.Event(name), args);
            }
        };
    };

    var select = selectHelper();

    window.selectHelper = select;

})(jQuery);

/**
 * @Descpription: bootboxHelper
 */
(function ($) {

    var defaults = {
        confirm_className: "btn btn-primary",
        confirm_label: '确认',
        cancel_className: 'btn default',
        cancel_label: '取消'
    };

    var defaultOption = {
        title: '',
        message: '',
        callback: function (res) {

        }
    };
    var bootboxHelper = function () {

        function getBaseOptions(type, title, message, handler) {
            var result = {
                message: message,
                buttons: {}
            };
            if (type == 'alert') {
                result.buttons = {
                    ok: {
                        label: defaults.confirm_label,
                        className: defaults.confirm_className
                    }
                };
                if (handler && $.isFunction(handler)) {
                    result.callback = function (data) {
                        handler.apply(this, [data]);
                    };
                }
                return result;
            }

            if (title && title.length > 0) {
                result.title = title;
            }
            result.buttons = {
                confirm: {
                    className: defaults.confirm_className,
                    label: defaults.confirm_label
                },
                cancel: {
                    className: defaults.cancel_className,
                    label: defaults.cancel_label
                }
            };
            if (type == 'confirm') {
                if (handler && $.isFunction(handler)) {
                    result.callback = function (data) {
                        handler.apply(this, [data]);
                    };
                }
                return result;
            }

            if (handler && $.isFunction(handler)) {
                result.buttons.confirm.callback = function (data) {
                    handler.apply(this, [data]);
                };
            }
            return result;
        };

        return {
            /**
             * @param message: '',
             * @param callbackHandler: function
             */
            alert: function (message, callbackHandler) {
                var options = getBaseOptions('alert', '', message, callbackHandler);
                bootbox.alert(options);
            },
            /**
             * @param option 是个对象 包含： title:'',message: '',callback: function
             */
            confirm: function (option) {
                // 合并参数设置
                var inOptions = $.extend(true, {}, defaultOption, option);
                var options = getBaseOptions('confirm', inOptions.title, inOptions.message, inOptions.callback);
                bootbox.confirm(options);
            },
            /**
             * @param option 是个对象 包含： title:'',message: '',callback: function
             */
            dialog: function (option) {
                // 合并参数设置
                var inOptions = $.extend(true, {}, defaultOption, option);
                var options = getBaseOptions('dialog', inOptions.title, inOptions.message, inOptions.callback);
                bootbox.dialog(options);
            }
        };
    };

    var helper = bootboxHelper();

    window.bootboxHelper = helper;

})(jQuery);
(function ($) {
    var dataUtil = {
        // 格式化日期函数  YY-MM-DD hh:mm:ss
        changeDateFormat: function (cellval) {
            if (cellval != null) {
                var date = new Date(parseInt((cellval + "").replace("/Date(", "").replace(")/", ""), 10));
                var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                var oHour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours()
                var oMin = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
                var oSen = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
                return date.getFullYear() + "-" + month + "-" + currentDate + " " + oHour + ":" + oMin + ":" + oSen;
            }
            return "--";
        },
        // 格式化日期函数  YY-MM-DD
        changeDateFormat2: function (cellval) {
            if (cellval != null) {
                var date = new Date(parseInt((cellval + "").replace("/Date(", "").replace(")/", ""), 10));
                var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                var oHour = date.getHours();
                var oMin = date.getMinutes();
                var oSen = date.getSeconds();
                return date.getFullYear() + "-" + month + "-" + currentDate;
            }
            return "--";
        },
        // 添加对默认时间的判断 有效期使用
        changeDateFormat3: function (cellval) {
            if (cellval != null) {
                var date = new Date(parseInt((cellval + "").replace("/Date(", "").replace(")/", ""), 10));
                var year = date.getFullYear() + "";
                var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                var oHour = date.getHours();
                var oMin = date.getMinutes();
                var oSen = date.getSeconds();
                return date.getFullYear() + "-" + month + "-" + currentDate;
            }
            return "--";
        }
    };

    window.dataUtil = dataUtil;
})(jQuery);






