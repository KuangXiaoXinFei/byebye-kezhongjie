(function (vue) {
// html模板信息
    var selectTemplate = ['<div class="select-container" v-on:mouseleave="mleave">',
        '<div class="select2-container form-control" v-on:click="vShow">',
        '<a href="javascript:void(0)" class="select2-choice" tabindex="-1">',
        '<span class="select2-chosen">{{selectedText}}</span>',
        '<span class="select2-arrow" role="presentation">',
        '<b role="presentation"></b></span></a>',
        '<label for="s2id_autogen4" class="select2-offscreen"></label>',
        '</div>',
        '<div class="select2-drop select2-drop-active" v-bind:style="widthStyle" v-show="dropShow">',
        '<ul class="select2-results" role="listbox">',
        '<li v-for="p in valOptions" @click="select(p);" :class="selectClass(p)" class="select2-result select2-result-selectable" role="presentation">',
        '<div class="select2-result-label" role="option"><span class="select2-match"></span>{{p.text}}</div>',
        '</li>',
        '</ul>',
        '</div>',
        '<select v-model="model" class="form-control select2-offscreen" tabindex="-1">',
        '<option :value="p.value" v-for="p in valOptions">{{p.text}}</option>',
        '</select></div>'].join('');

    Vue.component('v-select', {
        name: 'vSelect',
        template: selectTemplate,
        data: function () {
            return {
                model: this.value,
                focused: false,
                dropShow: false,
                selectedText: ''
            };
        },
        props: {
            value: {default: '', required: true},
            options: {
                type: Array,
                required: true
            },
            placeholder: String,
            label: {default: 'text'},
            code: {default: 'value'},
            width: {default: ''}
        },
        watch: {
            value: function (val) {
                this.model = val;
            },
            model: function (val) {
                this.model = val;
                this.$emit('input', this.model);
                if (val !== this.value) {
                    this.$emit('change', val);
                }
            }
        },
        computed: {
            widthStyle: function () {
                var w = this.width;
                if (w != null && w.length > 0) {
                    return 'width:' + w + '%;';
                }
                return '';
            },
            valOptions: function () {
                var vue = this, $option = [];
                var _option = this.options;
                _option.forEach(function (t) {
                    var item = vue.getOption(t);
                    $option.push(item);
                    if (vue.isSelected(item)) {
                        vue.selectedText = item.text;
                    }
                });
                return $option;
            }
        },
        methods: {
            select: function (option) {
                if (!option) {
                    return;
                }

                this.model = option.value;
                this.selectedText = option.text;
                this.dropShow = false;
                //this.selectClass(option);
            },
            mleave: function () {
                this.dropShow = false;
            },
            isSelected: function (option) {
                if (option.value == this.model) {
                    return true;
                }
                return false;
            },
            selectClass: function (option) {
                if (this.isSelected(option)) {
                    return 'select2-highlighted';
                }
                return '';
            },
            vShow: function () {
                this.dropShow = !this.dropShow;
            },
            getOption: function (option) {
                var label = this.label, code = this.code;
                if (typeof option === 'object') {
                    if (!option.hasOwnProperty(label)) {
                        console.log(option);
                    }
                    var _option = {'text': '', 'value': ''};
                    if (label && option[label]) {
                        _option.text = option[label];
                    }
                    if (code && option[code]) {
                        _option.value = option[code];
                    }
                    return _option;
                }
                return option;
            }
        }
    });
    //vue.vselect = selectComponent;
})(Vue);