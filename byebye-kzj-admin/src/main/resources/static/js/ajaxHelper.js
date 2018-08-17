/**
 * Description:ajaxHelper封装ajax请求统一处理没有权限的ajax请求问题
 * All Rights Reserved.
 */

(function ($) {
    /*默认参数*/
    var defaults = {
        type: "post",
        cache: false,
        url: "",
        async: true,
        data: {},
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        processData: true,
        multiRequest: true,//并行请求
        redirectUrl: "",
        beforeSend: function () {
        },
        success: function (obj) {
        },
        complete: function () {
        },
        error: function (obj) {
            console.log("系统异常，请联系管理员");
        }
    };

    var ajaxHelper = function () {
        this.hadSubmit = false;

        function httpRequestDone(option) {

            var self = this;
            if (self.hadSubmit) {
                alert("正在提交数据，请稍后...");
                return false;
            }

            if (!option.multiRequest) {
                self.hadSubmit = true;
            }
            $.ajax({
                type: option.type,
                cache: option.cache,
                url: option.url,
                async: option.async,
                data: option.data,
                contentType: option.contentType,
                processData: option.processData,
                beforeSend: function () {
                    option['beforeSend'].call(option);
                },
                success: function (res) {
                    self.hadSubmit = false;
                    if (res.resultCode && res.resultCode == 100005) {
                        window.location.href = res.data.redirect;
                        return false;
                    }
                    else if (res.resultCode && res.resultCode == 100006) {
                        alert("您没有权限，请联系管理员");
                        if (option.redirectUrl != null
                            && $.trim(option.redirectUrl).length > 0) {
                            window.location.href = option.redirectUrl;
                        }
                        return false;
                    }
                    option['success'].call(option, res);
                },
                error: function (data) {
                    self.hadSubmit = false;
                    option['error'].call(option, data);
                },
                complete: function () {
                    self.hadSubmit = false;
                    option['complete'].call(option);
                }
            });
        }


        return {
            ajaxFun: function (option) {
                // 合并参数设置
                var _options = $.extend(true, {}, defaults, option);
                httpRequestDone(_options);
            },
            doPost: function (option) {
                // 合并参数设置
                var _options = $.extend(true, {}, defaults, option);
                _options.type = 'POST';
                httpRequestDone(_options);
            },
            doGet: function (option) {
                // 合并参数设置
                var _options = $.extend(true, {}, defaults, option);
                _options.type = 'GET';
                httpRequestDone(_options);
            }
        };
    };

    window.ajaxHelper = ajaxHelper();
})(jQuery);