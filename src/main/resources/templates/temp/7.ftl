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
    <div class="weui-cells__title">7. 您认为贵公司领导是否重视青年人才规划？</div>
    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check__label" for="x11">
            <div class="weui-cell__bd">
                <p>是</p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" class="weui-check" name="radio1" id="x11">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="x12">
            <div class="weui-cell__bd">
                <p>否</p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" class="weui-check" name="radio1" id="x12">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="x13">
            <div class="weui-cell__bd">
                <p>不清楚</p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" name="radio1" class="weui-check" id="x13" checked="checked">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
    </div>
    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" href="8.ftl" id="showTooltips">下一题</a>
        <a class="weui-btn weui-btn_warn" href="javascript:" id="showTooltips">上一题</a>
    </div>

</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

</script>
</body>
</html>
