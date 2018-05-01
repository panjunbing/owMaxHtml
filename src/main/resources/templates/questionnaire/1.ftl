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
        <div class="weui-cells__title">1.您的文化程度是？</div>
        <div class="weui-cells weui-cells_radio">
            <label class="weui-cell weui-check__label" for="x11">
                <div class="weui-cell__bd">
                    <p>高中及以下</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" class="weui-check" name="radio" id="x11" required tips="请选择其中一个选项">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x12">
                <div class="weui-cell__bd">
                    <p>专科</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" class="weui-check" name="radio" id="x12">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x13">
                <div class="weui-cell__bd">
                    <p>本科</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="radio" class="weui-check" id="x13">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x14">
                <div class="weui-cell__bd">
                    <p>硕士</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="radio" class="weui-check" id="x14">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x15">
                <div class="weui-cell__bd">
                    <p>博士</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="radio" class="weui-check" id="x15">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
        </div>
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" id="next">下一题</a>
            <a class="weui-btn weui-btn_warn" href="javascript:" id="back">上一题</a>
        </div>
    </div>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

    $('#next').on('click',function () {
        weui.form.validate('#form', function (error) {
            if (!error) {
                $('#next').attr('href','2')
            }
            else {
                // weui.topTips('请选择您的选项', 3000);
            }
            // return true; // 当return true时，不会显示错误
        }, {
            regexp: {
                IDNUM: /(?:^\d{15}$)|(?:^\d{18}$)|^\d{17}[\dXx]$/,
                VCODE: /^.{4}$/
            }
        });
    });

    $('#back').on('click',function () {
        weui.toast('已是第一题！', 3000);
    });
</script>
</body>
</html>
