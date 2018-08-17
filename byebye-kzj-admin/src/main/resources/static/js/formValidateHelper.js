/**
 * Description:formValidateHelper
 * All Rights Reserved.
 *
 * @version 1.0  2017-9-14 16:51:31  by  zhangcz（zhangcz@cloud-young.com）创建
 */

(function ($) {
    /*默认参数*/
    var defaults = {
        formId: 'submit_form',
        debug: false,//只验证不提交表单
        doNotHideMessage: true, //this option enables to show the error/success messages on tab switch.
        errorElement: 'span', //default input error message container
        errorClass: 'help-block help-block-error', // default input error message class
        onsubmit: true,// 是否在提交时验证
        rules: {},
        messages: {},
        ignore: ":hidden",
        highlight: function (element) { // hightlight error inputs
            $(element)
                .closest('.form-group').removeClass('has-success').addClass('has-error'); // set error class to the control group
        },
        unhighlight: function (element) { // revert the change done by hightlight
            $(element)
                .closest('.form-group').removeClass('has-error'); // set error class to the control group
        },
        submitHandler: function (form) {
        }
    };

    var validateHelper = function () {
        return {
            init: function (option) {
                // 合并参数设置
                var options = $.extend(true, {}, defaults, option);

                $("#" + options.formId).validate({
                    debug: options.debug,
                    doNotHideMessage: options.doNotHideMessage,
                    errorElement: options.errorElement,
                    errorClass: options.errorClass,
                    focusInvalid: options.focusInvalid,
                    onsubmit: options.onsubmit,
                    rules: options.rules,
                    messages: options.messages,
                    ignore: options.ignore,
                    highlight: options.highlight,
                    unhighlight: options.unhighlight,
                    submitHandler: options.submitHandler,
                    errorPlacement: options.errorPlacement
                });
            }
        };
    };

    window.formValidateHelper = validateHelper();

    // 电话号码验证
    jQuery.validator.addMethod("isMobile", function (value, element) {
        var tel = /^((0\d{2,3}-\d{7,8}(-\d{1,4})?),)*(0\d{2,3}-\d{7,8}(-\d{1,4})?)$/;
        return this.optional(element) || (tel.test(value));
    }, "请输入正确的电话号码");

    jQuery.validator.addMethod("isFaxNumber", function (value, element) {
        var tel = /^(\d{3,4}-)?\d{7,8}$/;
        return this.optional(element) || (tel.test(value));
    }, "请输入正确的传真");

    //上传图片大小
    jQuery.validator.addMethod("checkPicSize", function (value, element) {
        if (element.files[0] == null) {
            return true;
        }

        var fileSize = element.files[0].size;
        var maxSize = 2 * 1024 * 1024;
        if (fileSize > maxSize) {
            return false;
        } else {
            return true;
        }
    }, "请上传不大于2M的图片");
})(jQuery);