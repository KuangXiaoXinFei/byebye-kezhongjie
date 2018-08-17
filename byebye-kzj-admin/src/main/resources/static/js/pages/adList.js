var page = {
    basePath: baseUrlPath,
    app_vue: null
};
//页面初始化
page.init = function () {
    page.initVue();
    page.ValidInput();
};

page.initVue = function () {
    page.app_vue = new Vue({
        el: "#vue_main",
        data: {
            list: [],
            weight: 1,
            txtUrl: '',
            txtDesctript: '',
            adId: 0,
            queryParam: {
                status: '',
                beginTime: '',
                endTime: '',
                pageNumber: 1,
                pageSize: 10
            },
            total: 0
        },
        mounted: function () {
            this.getAdList();
        },
        methods: {
            getAdList: function (pageNumber, pageSize) {
                var vue = this;
                var _param = vue.queryParam;
                _param.status = $.trim($('#searchStatus').val());
                _param.beginTime = $.trim($('#startDate').val());
                _param.endTime = $.trim($('#endDate').val());
                if (pageNumber && pageSize) {
                    _param.pageNumber = pageNumber;
                    _param.pageSize = pageSize;
                } else {
                    _param.pageNumber = 1;
                    _param.pageSize = 10;
                }
                ajaxHelper.doPost({
                    url: page.basePath + '/sowing/getDatas',
                    data: _param,
                    success: function (result) {
                        vue.total = 0;
                        if (result.code == 200) {
                            vue.list = result.data.rows;
                            vue.total = result.data.total;
                            console.log(vue.list);
                        }
                    },
                    error: function () {
                        yui.toastTips.show('获取信息失败！');
                        return;
                    }
                });
            },
            addModel: function () {
                var vue = this;
                vue.addCancel();
                $("#add").modal("show");
            },
            addCancel: function () {
                this.weight = 1;
                this.txtUrl = '';
                this.txtDesctript = '';
                this.adId = 0;
                $("#files").val("");
                $("#addBannerForm").find('.form-group').removeClass('has-error');
                $("#addBannerForm").validate().resetForm();
                $("#element_id").attr("src","../../static/images/imgBg.jpg");
                $("#add").modal("hide");
            },
            add: function (status) {
                var vue = this;
                var mainValid = $("#addBannerForm").valid();
                if (!mainValid) {
                    return;
                }
                var value = $("#files").val();   //
                if (value == "" && $("#imgPath").attr("src") == "") {
                    yui.toastTips.show('请先选择上传文件！');
                    return false;
                }
                var filepath = $("input[name='files']").val();
                var extStart = filepath.lastIndexOf(".");
                var ext = filepath.substring(extStart, filepath.length).toUpperCase();
                if(vue.adId == 0){
                    if (ext != ".BMP" && ext != ".PNG" && ext != ".JPG" && ext != ".JPEG") {
                        yui.toastTips.show("图片限于bmp,png,jpeg,jpg格式");
                        return false;
                    }
                }
                var params = new FormData();
                params.append("weight", vue.weight);
                params.append("adId", vue.adId);
                params.append("url", vue.txtUrl);
                params.append("status", status);
                params.append("description", vue.txtDesctript);
                params.append("files", $("#files").get(0).files[0]);
                console.log($("#files").get(0).files[0]);
                $(":input[name='btn_sure']").attr("disabled", "disabled");
                ajaxHelper.doPost({
                    url: page.basePath + '/sowing/save',
                    data: params,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (result) {
                        vue.total = 0;
                        if (result.code == 200) {
                            yui.toastTips.show('操作成功！');
                            $("#add").modal("hide");
                            vue.getAdList();
                            $(":input[name='btn_sure']").removeAttrs("disabled");
                            return;
                        }
                    },
                    error: function () {
                        yui.toastTips.show('获取信息失败！');
                        $(":input[name='btn_sure']").removeAttrs("disabled");
                        return;
                    }
                });
            },
            editAd: function (adId) {
                var vue = this;
                vue.addCancel();
                ajaxHelper.doGet({
                    url: page.basePath + '/sowing/getDetail?adId=' + adId,
                    cache: false,
                    success: function (result) {
                        if (result.code == 200) {
                            var item = result.data.data;
                            $("#element_id").attr("src", item.imagePath);
                            vue.txtUrl = item.url;
                            vue.weight = item.weight;
                            vue.txtDesctript = item.description;
                            vue.adId = item.bannerId;
                            $("#add").modal("show");
                        }
                    },
                    error: function () {
                        yui.toastTips.show('获取信息失败！');
                        return;
                    }
                });
            },
            updown: function (adId) {
                this.adId = adId;
                $("#shelves").modal("show");
            },
            shelvesCancel: function () {
                this.adId = 0;
                $("#shelves").modal("hide");
            },
            upSure: function () {
                this.updateStatus(1);
            },
            shelvesSure: function () {
                this.updateStatus(2);
            },
            upward: function (adId) {
                this.adId = adId;
                $("#shelvesUp").modal("show");
            },
            upCancel: function () {
                this.adId = 0;
                $("#shelvesUp").modal("hide");
            },
            updateStatus: function (status) {
                var vue = this;
                var param = [];
                param.push("adId", vue.adId);
                param.push("status", status);
                ajaxHelper.doPost({
                    url: page.basePath + '/sowing/updateStatus',
                    data: {'adId': vue.adId, 'status': status},
                    cache: false,
                    success: function (result) {
                        if (result.code == 200) {
                            $("#shelves").modal("hide");
                            $("#shelvesUp").modal("hide");
                            vue.getAdList();
                        }
                    },
                    error: function () {
                        yui.toastTips.show('获取信息失败！');
                        return;
                    }
                });
            },
            del: function (adId) {
                this.adId = adId;
                $("#delete").modal("show");
            },
            delCancel: function () {
                this.adId = 0;
                $("#delete").modal("hide");
            },
            delSure: function () {
                var vue = this;

                ajaxHelper.doPost({
                    url: page.basePath + '/sowing/delData',
                    data: {'adId': vue.adId},
                    cache: false,
                    success: function (result) {
                        if (result.code == 200) {
                            $("#delete").modal("hide");
                            vue.getAdList();
                        }
                    },
                    error: function () {
                        yui.toastTips.show('获取信息失败！');
                        return;
                    }
                });
            },
            formatDate: function (value) {
                if (!value) return '';
                return dataUtil.changeDateFormat(value);
            }
        }
    });
};

page.updateStatus = function (status, adId) {
    var param = [];
    console.log(status);
    console.log(adId);
    param.push("adId", adId);
    param.push("status", status);
    ajaxHelper.doPost({
        url: page.basePath + '/sowing/updateStatus',
        data: {'adId': adId, 'status': status},
        cache: false,
        success: function (result) {
            if (result.code == 200) {
                $("#shelves").modal("hide");
                $("#shelvesUp").modal("hide");
                vue.getAdList();
            }
        },
        error: function () {
            yui.toastTips.show('获取信息失败！');
            return;
        }
    });
}

jQuery.validator.addMethod("checkPic", function (value, element) {
    var filepath = $("#logo").val();
    //获得上传文件名
    var fileArr = filepath.split("\\");
    var fileTArr = fileArr[fileArr.length - 1].toLowerCase().split(".");
    var filetype = fileTArr[fileTArr.length - 1];
    //切割出后缀文件名
    if (filetype != "jpg" || filetype != "png") {
        return false;
    } else {
        return true;
    }
}, "上传图片格式不适合");

page.ValidInput = function () {
    formValidateHelper.init({
        formId: "addBannerForm",
        rules: {
            "txtUrl": {
                required: true,
                url: true
            },
            "txtDescription": {
                required: true
            }
        },
        messages: {
            "txtUrl": {
                required: '请填写链接地址',
                url: '请输入正确的url地址'
            },
            "txtDescription": {
                required: '请填写描述信息'
            }
        }
    });
}


$(function () {
    page.init();
});













