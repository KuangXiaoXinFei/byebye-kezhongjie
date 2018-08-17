(function (vue) {
// html模板信息
    var paginationTemplate = ['<div id="page_number_contaniner" class="pagination_nav text-right" style="float: right">'
        , '<ul class="pagination">'
        , '<li :class="{disabled:current==1}"><a href="javascript:;" @click="goto(1)">首页</a></li>'
        , '<li :class="{disabled:current<=1}"><a href="javascript:;" @click="goto(current-1)">上一页</a></li>'
        , '<li :class="{active:current==p}" v-for="p in pages()"><a href="javascript:;" @click="goto(p);"> {{p}} </a></li>'
        , '<li :class="{disabled: current >= totalPage}"><a href="javascript:;" @click="goto(current+1)">下一页</a></li>'
        , '<li :class="{disabled: current == totalPage}"><a href="javascript:;" @click="goto(totalPage)">末页</a></li>'
        , '<select class="pager_select" v-model="pageSelect">'
        , '<option v-for="l in pageList" v-bind:value="l">每页{{l}}条</option>'
        , '</select>'
        , '</ul></div>'].join('');

    var pagination = Vue.component('v-pagination', {
            template: paginationTemplate,
            data: function () {
                return {
                    current: this.currentpage,
                    pageSelect: this.size,
                    pageList: [10, 20, 30]
                };
            },
            props: ['total', 'size', 'currentpage'],
            computed: {
                totalPage: function () { // 总页数
                    var totalPages = parseInt((this.total - 1) / this.size) + 1;
                    if (totalPages > 0 && this.currentPage > totalPages) {
                        this.currentPage = totalPages;
                    }
                    return totalPages;
                }
            },
            methods: {
                // 页码点击事件
                goto: function (idx) {
                    if (this.current != idx && idx > 0 && idx < this.totalPage + 1) {
                        this.current = idx;
                        this.$emit('pagechange', this.current, this.size, this.totalPage);
                    }
                },
                pages: function () { // 获取分页页码

                    var _total = this.totalPage, list = [], from, to
                    _current = this.current;

                    if (_total < 5) {
                        from = 1;
                        to = _total;
                    } else {
                        from = _current - 2;
                        to = from + 4;
                        if (from < 1) {
                            from = 1;
                            to = 5;
                        }
                        if (to > _total) {
                            to = _total;
                            from = to - 4;
                        }
                    }

                    if (_total >= 6) {
                        if (_current >= 3) {
                            list.push(1);
                            from++;
                        }

                        if (_current >= 4) {
                            if (_current == 4 || _total == 6 || _total == 7) {
                                from--;
                            } else {
                                list.push("...");
                            }
                            to--;
                        }
                    }

                    if (_total >= 7) {
                        if (_current >= (_total - 2)) {
                            from--;
                        }
                    }

                    if (_total == 6) {
                        if (_current >= (_total - 2)) {
                            to++;
                        }
                    } else if (_total >= 7) {
                        if (_total == 7 || _current >= (_total - 3)) {
                            to++;
                        }
                    }

                    for (i = from; i <= to; i++) {
                        list.push(i);
                    }

                    if (_total >= 8) {
                        if (_current <= (_total - 4)) {
                            list.push('...');
                        }
                    }

                    if (_total >= 6) {
                        if (_current <= (_total - 3)) {
                            list.push(_total);
                        }
                    }

                    return list;
                }
            },
            watch: {
                currentpage: function (val) {
                    if (val > 0) {
                        this.current = val;
                    }
                },
                pageSelect: function (val) {
                    if (val > 0) {
                        this.$emit('pagechange', 1, val, this.totalPage);
                    }
                }
            }
        })
    ;
    vue.pagination = pagination;
})(Vue);