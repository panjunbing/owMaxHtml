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
    <form id="form" method="post" action="">
        <div class="weui-cells__title" id="title"></div>
        <div class="weui-cells weui-cells_radio" id = selections>
            <#--<label class="weui-cell weui-check__label" for="x11">-->
                <#--<div class="weui-cell__bd">-->
                    <#--<p>高中及以下</p>-->
                <#--</div>-->
                <#--<div class="weui-cell__ft">-->
                    <#--<input type="radio" class="weui-check" name="radio" id="x11" required tips="请选择其中一个选项">-->
                    <#--<span class="weui-icon-checked"></span>-->
                <#--</div>-->
            <#--</label>-->
        </div>
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" id="next">下一题</a>
        </div>
    </form>
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
                            '<input type="radio" class="weui-check" name="selectionID" id="x' + i +
                            '" required tips="请选择其中一个选项" value="'+ selections[i].selectionID +'">' +
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
                $.ajax({
                    url: "/jump/getJump",
                    data: $('#form').serialize(),
                    async: false,
                    success: function (data) {

                    }
                });
            }
            else {
                weui.topTips('请选择您的选项', 3000);
            }
            // return true; // 当return true时，不会显示错误
        }, {
            regexp: {
                IDNUM: /(?:^\d{15}$)|(?:^\d{18}$)|^\d{17}[\dXx]$/,
                VCODE: /^.{4}$/
            }
        });
    });

    weui.form.checkIfBlur('#form', {
        regexp: {
        }
    });

    $('#back').on('click',function () {
        weui.toast('已是第一题！', 3000);
    });
</script>
</body>
</html>
