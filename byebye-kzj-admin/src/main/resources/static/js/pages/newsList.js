var page = {
    basePath: baseUrlPath,
    vue: null
};
//页面初始化
page.init = function () {
    page.initVue();
    //品牌事件
    $('#brandId').change(function () {
        var id = $(this).val();
        $('#select2-chosen-2').text('车系');
        page.vue.getSerialList(id, function (obj) {
            if (obj && obj.code == 200) {
                var list = obj.data;
                page.vue.searchSerials = list;
            }
        });
    });
};
page.initVue = function () {
    page.vue = new Vue({
        el: "#vue_main",
        data: {
            list: [],
            queryParam: {
                brandId: '',
                serialId: '',
                newsType: '',
                newsId: '',
                newsTitle: '',
                status: '',
                source: '',
                userName: '',
                userId: '',
                minCreateTime: '',
                maxCreateTime: '',
                pageNumber: 1,
                pageSize: 10
            },
            selectIds: [],
            detailItem: {},
            confirmItem: {},
            isCheckAll: false,
            brands: [],
            searchSerials: [],
            relaCars: {
                newsId: 0,
                relaCarItems: []
            },
            total: 0,
            newsTypeItems: [{'text': '全部', 'value': ''}, {'text': '文章', 'value': 1}, {'text': '微文', 'value': 2}],
            sourceItems: [{'text': '全部', 'value': ''}, {'text': '官方', 'value': 1}, {'text': '发帖', 'value': 2}]
        },
        mounted: function () {
            this.queryParam.userId = document.querySelector('#uid').value;
            this.getNewsList();
            this.getBrand();
        },
        methods: {
            searchBrandChange: function () {
                var vue = this;
                var id = vue.queryParam.brandId;
                $('#select2-chosen-1').text('车系');
                vue.getSerialList(id, function (obj) {
                    if (obj && obj.code == 200) {
                        var list = obj.data;
                        vue.searchSerials = list;
                    }
                });
            },
            clearSearch: function () {
                var vue = this;
                vue.queryParam.userId = '';
                vue.queryParam.userName = '';
                vue.queryParam.newsTitle = '';
                vue.queryParam.newsId = '';
                vue.queryParam.brandId = '';
                vue.queryParam.newsType = '';
                vue.queryParam.source = '';
            },
            getNewsList: function (pageNumber, pageSize) {
                var vue = this;
                var _param = vue.queryParam;
                _param.brandId = $("#brandId").val();
                _param.serialId = $('#serialId').val();
                //_param.newsType = $("#searchType").val();
                _param.status = $('#searchStatus').val();
                _param.minCreateTime = $('#startDate').val();
                _param.maxCreateTime = $('#endDate').val();
                //_param.source = $('#searchsource').val();
                if (pageNumber && pageSize) {
                    _param.pageNumber = pageNumber;
                    _param.pageSize = pageSize;
                } else {
                    _param.pageNumber = 1;
                    _param.pageSize = 10;
                }
                //vue.queryParam = _param;

                ajaxHelper.doPost({
                    url: page.basePath + '/news/getlist',
                    data: _param,
                    success: function (result) {
                        vue.total = 0;
                        vue.selectIds = [];
                        vue.isCheckAll = false;
                        if (result.code == 200) {
                            vue.list = result.data.rows;
                            vue.total = result.data.total;
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
            },
            showDetail: function (id) {//详情弹窗
                var vue = this;
                ajaxHelper.doPost({
                    url: baseUrlPath + '/news/detail',
                    data: {newsId: id},
                    success: function (res) {
                        if (res.code == 200) {
                            var data = res.data;
                            if (data && data.newsContent) {
                                data.newsContent = JSON.parse(data.newsContent);
                            }
                            vue.detailItem = data;
                            $('#previewModal').modal('show');
                        } else {
                            yui.toastTips.show(res.msg);
                        }
                    },
                    error: function () {
                        yui.toastTips.show('出错了,请稍后重试！');
                    }
                });
            },
            closeModal: function (mele) {
                $('#' + mele).modal('hide');
            },
            setStatusConfirm: function (id, status) {
                var vue = this;
                vue.confirmItem = {
                    newsId: id,
                    status: status,
                    isBatch: false
                };
                $('#upStatus').modal('show');
            },
            batchStatusConfirm: function (status) {
                var vue = this;
                if (vue.selectIds.length == 0) {
                    yui.toastTips.show('请至少选择一条记录！');
                    return;
                }
                vue.confirmItem = {
                    newsIds: vue.selectIds,
                    status: status,
                    isBatch: true
                };
                $('#upStatus').modal('show');
            },
            doSetStatus: function (itemIds, isUp, isPreview) {
                var vue = this;
                var upStatus = isUp ? 1 : 0;
                var msg = isUp ? "上" : "下";
                ajaxHelper.doPost({
                    url: baseUrlPath + '/news/editstatus',
                    data: {ids: itemIds.join(','), status: upStatus},
                    success: function (res) {
                        if (isPreview) {
                            vue.closeModal('previewModal');
                        } else {
                            vue.closeModal('upStatus');
                        }
                        if (res.code == 200) {
                            vue.getNewsList();
                            yui.toastTips.show(msg + '架成功！');
                        } else {
                            yui.toastTips.show(msg + '架失败！');
                        }
                    },
                    error: function () {
                        yui.toastTips.show('出错了,请稍后重试！');
                    }
                });
            },
            ckAllChange: function () {
                var vue = this;
                vue.selectIds = [];
                if (vue.isCheckAll == true) {
                    var list = vue.list;
                    var len = list.length;
                    for (var idx = 0; idx < len; idx++) {
                        vue.selectIds.push(list[idx].newsId);
                    }
                }
            },
            getBrand: function () {
                var vue = this;
                ajaxHelper.doPost({
                    url: page.basePath + '/news/brands',
                    success: function (res) {
                        if (res && res.code == 200) {
                            //
                            vue.brands = res.data;
                            //vue.brands.splice(0, 0, {"brandId": '', "brandName": '品牌'});
                        }
                    },
                    error: function (dataR) {
                        yui.toastTips.show('获取品牌信息失败！');
                        return;
                    }
                });
            },
            brandChange: function (index) {
                var vue = this;
                if (index > -1) {
                    var t = vue.relaCars.relaCarItems[index];
                    t.serials = [];
                    t.selSerialId = -1;
                    vue.getSerialList(t.selBrandId, function (obj) {
                        if (obj && obj.code == 200) {
                            var list = obj.data;
                            t.serials = list;
                        }
                    });
                }
            },
            getSerialList: function (brandId, callback) {
                var vue = this;
                //车系
                ajaxHelper.doPost({
                    url: page.basePath + '/news/serials',
                    data: {'brandId': brandId},
                    success: function (res) {
                        callback.call(this, res);
                    },
                    error: function () {
                        yui.toastTips.show('获取车系信息失败！');
                    }
                });
            },
            showCarRelaModal: function (newsId) {
                var vue = this;
                vue.relaCars = {
                    newsId: newsId,
                    relaCarItems: []
                };
                vue.getNewsRelaCarList(newsId);
                $('#associatedCars').modal('show');
            },
            addCarItem: function (brandId, seriaId, serials) {
                var vue = this;
                var bId = brandId ? brandId : -1;
                var sId = seriaId ? seriaId : -1;
                vue.relaCars.relaCarItems.push({
                    selBrandId: bId,
                    selSerialId: sId,
                    brands: vue.brands,
                    serials: serials ? serials : []
                });
            },
            delCarItem: function (idx) {
                var vue = this;
                vue.relaCars.relaCarItems.splice(idx, 1);
            },
            setNewsRelaCar: function () {
                var vue = this;
                var items = [], id = vue.relaCars.newsId;
                var list = vue.relaCars.relaCarItems, len = list.length;
                for (var i = 0; i < len; i++) {
                    var item = list[i];
                    if (item.selBrandId > -1 && item.selSerialId > -1) {
                        items.push({
                            brandId: item.selBrandId,
                            serialId: item.selSerialId
                        });
                    }
                }
                if (items.length == 0) {
                    yui.toastTips.show('请先选择关联车系');
                    return;
                }
                ajaxHelper.doPost({
                    url: baseUrlPath + '/news/editCarRelation',
                    data: {'newsId': id, 'body': JSON.stringify(items)},
                    success: function (res) {
                        yui.toastTips.show("设置关联车系成功");
                        vue.closeModal('associatedCars');
                        vue.getNewsList();
                    },
                    error: function () {
                        yui.toastTips.show('出错了,请稍后重试！');
                        return;
                    }
                });
            },
            getNewsRelaCarList: function (id) {
                var vue = this;
                ajaxHelper.doPost({
                    url: baseUrlPath + '/news/getCarRelations',
                    data: {newsId: id},
                    success: function (res) {
                        if (res && res.code == 200) {
                            var list = res.data;
                            var len = list.length;
                            if (len > 0) {
                                for (var i = 0; i < len; i++) {
                                    var item = list[i];
                                    vue.getSerialList(item.brandId, function (obj) {
                                        if (obj && obj.code == 200) {
                                            var serialData = obj.data;
                                            vue.addCarItem(item.brandId, item.serialId, serialData);
                                            vue.addCarItem();
                                        }
                                    });
                                }
                            } else {
                                vue.addCarItem();
                            }
                        }
                    },
                    error: function () {
                        yui.toastTips.show('出错了,请稍后重试！');
                    }
                });
            }
        },
        watch: {
            selectIds: {
                handler: function (val, oldVal) {
                    var vue = this;
                    var listLen = vue.list.length;
                    if (listLen == 0) {
                        vue.isCheckAll = false;
                        return;
                    }
                    if (vue.selectIds.length == listLen) {
                        vue.isCheckAll = true;
                    } else {
                        vue.isCheckAll = false;
                    }
                },
                deep: true
            }
        }
    });
};
$(function () {
    page.init();
});