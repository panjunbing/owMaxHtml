<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl"/>
    <style type="text/css">
        .small_size{
            font-size: small
        }
    </style>
</head>
<title>青年调查问卷</title>
<body>

<div class="weui-tab" id="page-index">
    <header class="demos-header">
        <h1 class="demos-title">青年调查问卷</h1>
        <p class="demos-sub-title">xxxxxxxxxxxxxxx</p>
    </header>
    <div id="form">
        <div class="weui-cells__title">6.您认为公司应采取哪些措施，对员工心理进行辅导？</div>
        <div class="weui-cells weui-cells_radio">
            <label class="weui-cell weui-check__label" for="x11">
                <div class="weui-cell__bd">
                    <p>入职及职位转换期心理培训</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="radio" class="weui-check" id="x11" required tips="请选择其中一个选项">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x12">
                <div class="weui-cell__bd">
                    <p>定期开办讲座</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" class="weui-check" name="radio" id="x12">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x13">
                <div class="weui-cell__bd">
                    <p>建立心理指导中心</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="radio" class="weui-check" id="x13">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x14">
                <div class="weui-cell__bd">
                    <p>其他</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="radio" class="weui-check" id="x14">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <input class="weui-input" id="radio_other" name="radio_other" readonly="readonly"
                           type="text" placeholder="请输入您认为应该采取的措施">
                </div>
            </div>
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" id="next">下一题</a>
            <a class="weui-btn weui-btn_warn back" href="javascript:">上一题</a>
        </div>
    </div>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">
    $('#next').on('click',function () {
        weui.form.validate('#form', function (error) {
            if (!error) {
                $('#next').attr('href','7')
            }
            else {
                // weui.topTips('请选择您的选项', 3000);
            }
            // return true; // 当return true时，不会显示错误
        }, {
            // 正则校验
            regexp: {
                IDNUM: /(?:^\d{15}$)|(?:^\d{18}$)|^\d{17}[\dXx]$/,
                VCODE: /^.{4}$/
            }
        });
    });

    //判断其他是否可以填入
    $('#x14').on('click',function () {
        //当前状态是不可填入（未勾选其他）,勾选后应设置为可以填入
        $('#radio_other').removeAttr("readonly");
        state = true;
    });

    $('#x11').on('click',function () {
        var $radio_other = $('#radio_other');
        $radio_other.val('');
        $radio_other.attr("readonly","readonly");
    });
    $('#x12').on('click',function () {
        var $radio_other = $('#radio_other');
        $radio_other.val('');
        $radio_other.attr("readonly","readonly");
    });
    $('#x13').on('click',function () {
        var $radio_other = $('#radio_other');
        $radio_other.val('');
        $radio_other.attr("readonly","readonly");
    });

</script>
</body>
</html>
