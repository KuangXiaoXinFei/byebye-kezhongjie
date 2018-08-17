(function ($) {
    'use strict';

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

    var calculateObjectValue = function (self, name, args, defaultValue) {
        var func = name;

        if (typeof name === 'string') {
            // support obj.func1.func2
            var names = name.split('.');

            if (names.length > 1) {
                func = window;
                $.each(names, function (i, f) {
                    func = func[f];
                });
            } else {
                func = window[name];
            }
        }
        if (typeof func === 'object') {
            return func;
        }
        if (typeof func === 'function') {
            return func.apply(self, args || []);
        }
        if (!func && typeof name === 'string' && sprintf.apply(this, [name].concat(args))) {
            return sprintf.apply(this, [name].concat(args));
        }
        return defaultValue;
    };

    $.extend($.fn.bootstrapTable.defaults, {
        leftFixedColumns: false,
        leftFixedNumber: 1,
        rightFixedColumns: false,
        rightFixedNumber: 1
    });

    var BootstrapTable = $.fn.bootstrapTable.Constructor,
        _initHeader = BootstrapTable.prototype.initHeader,
        _initBody = BootstrapTable.prototype.initBody,
        _resetView = BootstrapTable.prototype.resetView;

    BootstrapTable.prototype.initFixedColumns = function () {
        this.timeoutHeaderColumns_ = 0;
        this.timeoutBodyColumns_ = 0;
        if (this.options.leftFixedColumns) {
            this.$fixedBody = $([
                '<div class="fixed-table-column lefttable" style="position: absolute;left:0; background-color: #fff; border-right:1px solid #ddd;">',
                '<table>',
                '<thead></thead>',
                '<tbody></tbody>',
                '</table>',
                '</div>'].join(''));


            this.$fixedBody.find('table').attr('class', this.$el.attr('class'));
            this.$fixedHeaderColumns = this.$fixedBody.find('thead');
            this.$fixedBodyColumns = this.$fixedBody.find('tbody');
            this.$tableBody.before(this.$fixedBody);
        }
        if (this.options.rightFixedColumns) {
            this.$rightfixedBody = $([
                '<div class="fixed-table-column righttable" style="position: absolute;right:0px; background-color: #fff; border-right:1px solid #ddd;">',
                '<table>',
                '<thead></thead>',
                '<tbody></tbody>',
                '</table>',
                '</div>'].join(''));

            this.$rightfixedBody.find('table').attr('class', this.$el.attr('class'));
            this.$rightfixedHeaderColumns = this.$rightfixedBody.find('thead');
            this.$rightfixedBodyColumns = this.$rightfixedBody.find('tbody');
            this.$tableBody.before(this.$rightfixedBody);
        }
    };

    BootstrapTable.prototype.initHeader = function () {
        _initHeader.apply(this, Array.prototype.slice.apply(arguments));

        if (!this.options.leftFixedColumns && !this.options.rightFixedColumns) {
            return;
        }
        this.initFixedColumns();

        var $tr = this.$header.find('tr:eq(0)').clone(),
            $ths = $tr.clone().find('th');

        var $trl = this.$header.find('tr:eq(0)').clone(),
            $thl = $trl.clone().find('th');

        $trl.html('');
        $tr.html('');
        //左边列冻结
        if (this.options.leftFixedColumns) {
            for (var i = 0; i < this.options.leftFixedNumber; i++) {
                $trl.append($thl.eq(i).clone());
            }

            this.$fixedHeaderColumns.html('').append($trl);
        }

        //右边列冻结
        if (this.options.rightFixedColumns) {
            for (var i = 0; i < this.options.rightFixedNumber; i++) {
                $tr.append($ths.eq($ths.length - this.options.rightFixedNumber + i).clone());
            }
            this.$rightfixedHeaderColumns.html('').append($tr);

        }
    };

    BootstrapTable.prototype.initBody = function () {
        _initBody.apply(this, Array.prototype.slice.apply(arguments));

        if (!this.options.leftFixedColumns && !this.options.rightFixedColumns) {
            return;
        }

        var that = this;
        if (this.options.leftFixedColumns) {
            this.$fixedBodyColumns.html('');
            this.$body.find('> tr[data-index]').each(function () {
                var $tr = $(this).clone(),
                    $tds = $tr.clone().find('td');

                $tr.html('');
                for (var i = 0; i < that.options.leftFixedNumber; i++) {
                    $tr.append($tds.eq(i).clone());
                }
                that.$fixedBodyColumns.append($tr);
            });
        }
        if (this.options.rightFixedColumns) {
            this.$rightfixedBodyColumns.html('');

            this.$body.find('> tr[data-index]').each(function () {
                var $tr = $(this).clone(),
                    $tds = $tr.clone().find('td');
                $tr.html('');
                for (var i = 0; i < that.options.rightFixedNumber; i++) {
                    var indexTd = $tds.length - that.options.rightFixedNumber + i;
                    var tdEvents = that.header.events[indexTd];
                    var oldTd = $tds.eq(indexTd);
                    var fixTd = oldTd.clone();
                    var buttons = fixTd.find('button');
                    //事件转移：冻结列里面的事件转移到实际按钮的事件
                    buttons.each(function (key, item) {
                        $(item).click(function () {
                            that.$body.find("tr[data-index=" + $tr.attr('data-index') + "] td:eq(" + indexTd + ") button:eq(" + key + ")").click();
                        });
                    });
                    $tr.append(fixTd);

                    //td event
                    // if (tdEvents) {
                    //     var field = that.header.fields[indexTd];
                    //
                    //     // fix bug, if events is defined with namespace
                    //     if (typeof tdEvents === 'string') {
                    //         tdEvents = calculateObjectValue(null, tdEvents);
                    //     }
                    //
                    //     for (var key in tdEvents) {
                    //         var evn_index = key.indexOf(' '),
                    //             name = key.substring(0, evn_index),
                    //             el = key.substring(evn_index + 1),
                    //             func = tdEvents[key];
                    //         oldTd.find(el).off(name);
                    //         fixTd.find(el).off(name).on(name, function (e) {
                    //             var tr_index = $tr.data('index'),
                    //                 row = that.data[tr_index];
                    //             console.log('---row--');
                    //             console.log(row);
                    //             console.log('---end row--');
                    //             var value = row[field];
                    //             func.apply($tr, [e, value, row, tr_index]);
                    //         });
                    //     }
                    // }
                }
                that.$rightfixedBodyColumns.append($tr);
            });
        }
    };

    BootstrapTable.prototype.resetView = function () {
        _resetView.apply(this, Array.prototype.slice.apply(arguments));

        if (!this.options.leftFixedColumns && !this.options.rightFixedColumns) {
            return;
        }

        clearTimeout(this.timeoutHeaderColumns_);
        this.timeoutHeaderColumns_ = setTimeout($.proxy(this.fitHeaderColumns, this), this.$el.is(':hidden') ? 100 : 0);

        clearTimeout(this.timeoutBodyColumns_);
        this.timeoutBodyColumns_ = setTimeout($.proxy(this.fitBodyColumns, this), this.$el.is(':hidden') ? 100 : 0);
    };

    BootstrapTable.prototype.fitHeaderColumns = function () {
        var that = this,
            visibleFields = this.getVisibleFields(),
            headerWidth = 0;
        if (that.options.leftFixedColumns) {
            this.$body.find('tr:first-child:not(.no-records-found) > *').each(function (i) {
                var $this = $(this),
                    index = i;

                if (i >= that.options.leftFixedNumber) {
                    return false;
                }

                if (that.options.detailView && !that.options.cardView) {
                    index = i - 1;
                }

                that.$fixedBody.find('thead th[data-field="' + visibleFields[index] + '"]')
                    .find('.fht-cell').width($this.innerWidth() - 1);
                headerWidth += $this.outerWidth();
            });
            this.$fixedBody.width(headerWidth - 1).show();
        }
        if (that.options.rightFixedColumns) {
            this.$body.find('tr:first-child:not(.no-records-found) > *').each(function (i) {
                var $this = $(this),
                    index = i;

                if (i >= visibleFields.length - that.options.rightFixedNumber) {
                    //return false;


                    //if (that.options.detailView && !that.options.cardView) {
                    //    index = i - 1;
                    //}
                    // debugger;
                    that.$rightfixedBody.find('thead th[data-field="' + visibleFields[index] + '"]')
                        .find('.fht-cell').width($this.innerWidth() - 1);
                    headerWidth += $this.outerWidth();
                }
            });
            this.$rightfixedBody.width(headerWidth - 1).show();
        }
    };

    BootstrapTable.prototype.fitBodyColumns = function () {
        var that = this,
            top = -(parseInt(this.$el.css('margin-top')) - 2),
            height = this.$tableBody.height() - 2;

        if (that.options.leftFixedColumns) {
            if (!this.$body.find('> tr[data-index]').length) {
                this.$fixedBody.hide();
                return;
            }

            this.$body.find('> tr').each(function (i) {
                that.$fixedBody.find('tbody tr:eq(' + i + ')').height($(this).height());
            });

            //// events
            this.$tableBody.on('scroll', function () {
                that.$fixedBody.find('table').css('top', -$(this).scrollTop());
            });
            this.$body.find('> tr[data-index]').off('hover').hover(function () {
                var index = $(this).data('index');
                that.$fixedBody.find('tr[data-index="' + index + '"]').addClass('hover');
            }, function () {
                var index = $(this).data('index');
                that.$fixedBody.find('tr[data-index="' + index + '"]').removeClass('hover');
            });
            this.$fixedBody.find('tr[data-index]').off('hover').hover(function () {
                var index = $(this).data('index');
                that.$body.find('tr[data-index="' + index + '"]').addClass('hover');
            }, function () {
                var index = $(this).data('index');
                that.$body.find('> tr[data-index="' + index + '"]').removeClass('hover');
            });
        }
        if (that.options.rightFixedColumns) {
            if (!this.$body.find('> tr[data-index]').length) {
                this.$rightfixedBody.hide();
                return;
            }

            this.$body.find('> tr').each(function (i) {
                that.$rightfixedBody.find('tbody tr:eq(' + i + ')').height($(this).height());
            });

            //// events
            this.$tableBody.on('scroll', function () {
                that.$rightfixedBody.find('table').css('top', -$(this).scrollTop());
            });
            this.$body.find('> tr[data-index]').off('hover').hover(function () {
                var index = $(this).data('index');
                that.$rightfixedBody.find('tr[data-index="' + index + '"]').addClass('hover');
            }, function () {
                var index = $(this).data('index');
                that.$rightfixedBody.find('tr[data-index="' + index + '"]').removeClass('hover');
            });
            this.$rightfixedBody.find('tr[data-index]').off('hover').hover(function () {
                var index = $(this).data('index');
                that.$body.find('tr[data-index="' + index + '"]').addClass('hover');
            }, function () {
                var index = $(this).data('index');
                that.$body.find('> tr[data-index="' + index + '"]').removeClass('hover');
            });
        }
    };

})(jQuery);