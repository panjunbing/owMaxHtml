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

<div class="page">
    <header class="demos-header">
        <h1 class="demos-title">青年调查问卷</h1>
        <p class="demos-sub-title">xxxxxxxxxxxxxxx</p>
    </header>
    <div id="form">
        <div class="weui-cells__title" id="title"></div>
        <div class="weui-cells weui-cells_radio">
            <div id="selections">
            <#--<label class="weui-cell weui-check__label" for="x11">-->
                <#--<div class="weui-cell__bd">-->
                    <#--<p>入职及职位转换期心理培训</p>-->
                <#--</div>-->
                <#--<div class="weui-cell__ft">-->
                    <#--<input type="radio" name="radio" class="weui-check" id="x11" required tips="请选择其中一个选项">-->
                    <#--<span class="weui-icon-checked"></span>-->
                <#--</div>-->
            <#--</label>-->
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <input class="weui-input" id="radio_other" name="radio_other" readonly="readonly"
                           type="text" placeholder="请输入你的观点">
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

    //获取问题
    $.ajax({
        url: "/questions/getQuestion",
        data: JSON,
        async: false,
        success: function (data) {
            var result = eval(data);
            if (result.result) {
                var title = result.title;
                $("#title").html(title);
                var selections = result.selections;
                var html = "";
                for(var i=0;i < selections.length;i++){
                    html += '<label class="weui-cell weui-check__label" for="x'+ i +'"><div class="weui-cell__bd"><p>'
                            + selections[i].selection +'</p></div><div class="weui-cell__ft">' +
                            '<input type="radio" class="weui-check" name="selection" id="x' + i +
                            '" required tips="请选择其中一个选项">' +
                            '<span class="weui-icon-checked"></span></div></label>';
                }
                $("#selections").html(html);
            }
            else
                weui.topTips("获取问题失败", 1000);
        }
    });


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
    $('#x3').on('click',function () {
        //当前状态是不可填入（未勾选其他）,勾选后应设置为可以填入
        $('#radio_other').removeAttr("readonly");
        state = true;
    });

    $('#x0').on('click',function () {
        var $radio_other = $('#radio_other');
        $radio_other.val('');
        $radio_other.attr("readonly","readonly");
    });
    $('#x1').on('click',function () {
        var $radio_other = $('#radio_other');
        $radio_other.val('');
        $radio_other.attr("readonly","readonly");
    });
    $('#x2').on('click',function () {
        var $radio_other = $('#radio_other');
        $radio_other.val('');
        $radio_other.attr("readonly","readonly");
    });

    weui.form.checkIfBlur('#form', {
        regexp: {
        }
    });

</script>
</body>
</html>
