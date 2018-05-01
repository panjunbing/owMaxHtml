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
        <div class="weui-cells__title">2.你的年龄是__周岁； 您在本单位已经工作的时间是__年。</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">年龄</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text" required pattern="[0-9]" maxlength="3" placeholder="输入你的年龄" emptytips="请输入年龄" notmatchtips="请输入正确的年龄（数字）">
                </div>
                <div class="weui-cell__ft">
                    <i class="weui-icon-warn"></i>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">工龄</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text" required pattern="[0-9]" maxlength="3" placeholder="输入你的工龄" emptytips="请输入工龄" notmatchtips="请输入正确的工龄（数字）">
                </div>
                <div class="weui-cell__ft">
                    <i class="weui-icon-warn"></i>
                </div>
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
                $('#next').attr('href','3')
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
</script>
</body>
</html>
