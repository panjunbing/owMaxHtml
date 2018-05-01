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
    <div class="weui-cells__title">请从下述激励机制，选出您期望的三项机制，并按照对您的重要程度从大至小进行排序:<br>
        A.奖金 &nbsp; &nbsp; &nbsp; B.荣誉称号及精神鼓励 &nbsp; &nbsp; &nbsp; C.职称或职业资格鉴定 &nbsp; &nbsp; &nbsp;
        D.福利增加&nbsp; &nbsp; &nbsp; E.职位晋升 &nbsp; &nbsp; &nbsp; F.补贴 &nbsp; &nbsp; &nbsp;
        G.休闲娱乐 &nbsp; &nbsp; &nbsp; H.股票期权</div>
    <div class="weui-cell weui-cell_select weui-cell_select-after">
        <div class="weui-cell__hd">
            <label for="" class="weui-label">最重要</label>
        </div>
        <div class="weui-cell__bd">
            <select class="weui-select" name="select2">
                <option value="1">奖金</option>
                <option value="2">荣誉称号及精神鼓励</option>
                <option value="3">职称或职业资格鉴定</option>
                <option value="4">福利增加</option>
                <option value="5">职位晋升</option>
                <option value="6">补贴</option>
                <option value="7">休闲娱乐</option>
                <option value="8">股票期权</option>
            </select>
        </div>
    </div>
    <div class="weui-cell weui-cell_select weui-cell_select-after">
        <div class="weui-cell__hd">
            <label for="" class="weui-label">第二重要</label>
        </div>
        <div class="weui-cell__bd">
            <select class="weui-select" name="select2">
                <option value="1">奖金</option>
                <option value="2">荣誉称号及精神鼓励</option>
                <option value="3">职称或职业资格鉴定</option>
                <option value="4">福利增加</option>
                <option value="5">职位晋升</option>
                <option value="6">补贴</option>
                <option value="7">休闲娱乐</option>
                <option value="8">股票期权</option>
            </select>
        </div>
    </div>
    <div class="weui-cell weui-cell_select weui-cell_select-after">
        <div class="weui-cell__hd">
            <label for="" class="weui-label">第三重要</label>
        </div>
        <div class="weui-cell__bd">
            <select class="weui-select" name="select2">
                <option value="1">奖金</option>
                <option value="2">荣誉称号及精神鼓励</option>
                <option value="3">职称或职业资格鉴定</option>
                <option value="4">福利增加</option>
                <option value="5">职位晋升</option>
                <option value="6">补贴</option>
                <option value="7">休闲娱乐</option>
                <option value="8">股票期权</option>
            </select>
        </div>
    </div>
    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" href="4.ftl" id="showTooltips">下一题</a>
        <a class="weui-btn weui-btn_warn" href="javascript:" id="showTooltips">上一题</a>
    </div>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">
</script>
</body>
</html>
