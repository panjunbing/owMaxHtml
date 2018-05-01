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
    <div class="weui-cells__title"> 您目前主要的压力来源于什么：（最多选三项）</div>
    <div class="weui-cells weui-cells_checkbox">
        <label class="weui-cell weui-check__label" for="s11">
            <div class="weui-cell__hd">
                <input type="checkbox" class="weui-check" name="checkbox1" id="s11" checked="checked">
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>升职</p>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="s12">
            <div class="weui-cell__hd">
                <input type="checkbox" name="checkbox1" class="weui-check" id="s12">
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>加薪</p>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="s13">
            <div class="weui-cell__hd">
                <input type="checkbox" name="checkbox1" class="weui-check" id="s13">
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>工作能力不够</p>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="s14">
            <div class="weui-cell__hd">
                <input type="checkbox" name="checkbox1" class="weui-check" id="s14">
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>加班，工作时间太长</p>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="s15">
            <div class="weui-cell__hd">
                <input type="checkbox" name="checkbox1" class="weui-check" id="s15">
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>交通时间太长</p>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="s16">
            <div class="weui-cell__hd">
                <input type="checkbox" name="checkbox1" class="weui-check" id="s16">
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>工作乏味</p>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="s17">
            <div class="weui-cell__hd">
                <input type="checkbox" name="checkbox1" class="weui-check" id="s17">
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>人际关系复杂</p>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="s18">
            <div class="weui-cell__hd">
                <input type="checkbox" name="checkbox1" class="weui-check" id="s18">
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>缺乏外界沟通</p>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="s19">
            <div class="weui-cell__hd">
                <input type="checkbox" name="checkbox1" class="weui-check" id="s19">
                <i class="weui-icon-checked"></i>
            </div>
            <div class="weui-cell__bd">
                <p>房租房价太高</p>
            </div>
        </label>
    </div>
    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" href="9.ftl" id="showTooltips">下一题</a>
        <a class="weui-btn weui-btn_warn" href="javascript:" id="showTooltips">上一题</a>
    </div>

</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

</script>
</body>
</html>
