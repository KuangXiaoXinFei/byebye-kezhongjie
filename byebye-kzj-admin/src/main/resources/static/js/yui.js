/**
 * Description:公共js帮助类
 */
(function ($) {
    var yui = yui || {};
    yui.version = "201805171458";

    yui.toastTips = new function () {
        var _this = this;

        _this.timeout_tips = 0;

        var tips_defaults = {
            toastTipMillSecond: 1500,
            tips_Id: 'toast_tips',
            message: ''
        };

        _this.initDom = function (eleId) {
            if ($("#" + eleId).length == 0) {
                var ht = ['<div id="', eleId, '" class="toast" style="display: none;"></div>'].join('')
                $('body').append(ht);
            }
        };

        _this.show = function (msg) {
            var _options = $.extend(true, {}, tips_defaults, {message: msg});
            this.initDom(_options.tips_Id);
            $('#' + _options.tips_Id).text(_options.message).show();
            _this.closeTips(_options.tips_Id, _options.toastTipMillSecond);
        };
        _this.closeTips = function (eleId, millsecond) {
            clearTimeout(_this.timeout_tips);
            _this.timeout_tips = setTimeout(function () {
                $('#' + eleId).hide();
            }, millsecond);
        };
    };


    yui.page = new function () {
        var _this = this;

        //select2下拉框去除搜索框
        _this.initSelect2 = function () {
            var opt = {
                minimumResultsForSearch: Infinity
            };
            //按照类名来渲染
            $("select.select2").select2(opt);
        }
        _this.initBootstrapSelect = function () {
            $('.bs-select').selectpicker({
                iconBase: 'fa',
                tickIcon: 'fa-check'
            });
        }

        //日期控件到日
        _this.initDateRange = function () {
            if (jQuery().datepicker) {
                $('.date-picker').datepicker({
                    rtl: Metronic.isRTL(),
                    orientation: "left",
                    autoclose: true,
                    language: "zh-CN",
                    // clearBtn: true,
                    startDate: new Date(1970, 01, 01),
                    endDate: new Date(9998, 12, 31),
                    format: "yyyy-mm-dd",
                    todayBtn: "linked",
                    todayHighlight: true
                });
                //$('body').removeClass("modal-open"); // fix bug when inline picker is used in modal
            }
        }

        //重置select
        _this.ResetSelect2 = function () {
            $("button[type='reset']").bind("click", function () {
                setTimeout(function () {
                    $("select.select2").each(function (i, v) {
                        $(v).trigger("change");
                    });

                    $("select.select2me").each(function (i, v) {
                        $(v).trigger("change");
                    });
                }, 10);
            });
            $("input[type='reset']").bind("click", function () {
                setTimeout(function () {
                    $("select.select2").each(function (i, v) {
                        $(v).trigger("change");
                    });

                    $("select.select2me").each(function (i, v) {
                        $(v).trigger("change");
                    });
                }, 10);
            })
        }
    }

    yui.init = function () {
        Function.prototype.method = function (name, func) {
            this.prototype[name] = func;
            return this;
        };
        if (!String.prototype.trim) { //判断下浏览器是否自带有trim()方法
            String.method('trim', function () {
                return this.replace(/^\s+|\s+$/g, '');
            });
            String.method('ltrim', function () {
                return this.replace(/^\s+/g, '');
            });
            String.method('rtrim', function () {
                return this.replace(/\s+$/g, '');
            });
        }
        String.prototype.format = function (args) {
            var result = this;
            if (arguments.length > 0) {
                if (arguments.length == 1 && typeof (args) == "object") {
                    for (var key in args) {
                        if (args[key] != undefined) {
                            var reg = new RegExp("({" + key + "})", "g");
                            result = result.replace(reg, args[key]);
                        }
                    }
                }
                else {
                    for (var i = 0; i < arguments.length; i++) {
                        if (arguments[i] != undefined) {
                            var reg = new RegExp("({)" + i + "(})", "g");
                            result = result.replace(reg, arguments[i]);
                        }
                    }
                }
            }
            return result;
        };

         this.page.initSelect2();
        // this.page.initBootstrapSelect();
         this.page.initDateRange();
        this.page.ResetSelect2();
    };

    window.yui = yui;
})(jQuery);
