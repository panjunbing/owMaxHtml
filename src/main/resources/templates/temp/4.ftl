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
    <div class="weui-cells__title">以下成才观念，您是否同意</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label for="date" class="weui-label" style="width: 100%">干一行， 爱一行</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="q1" type="text" value="" readonly="" style="text-align: right">
            </div>
        </div>
    </div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label for="date" class="weui-label" style="width: 100%">爱一行才能干一行</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="q2" type="text" value="" readonly="" style="text-align: right">
            </div>
        </div>
    </div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label for="date" class="weui-label" style="width: 100%">三百六十行， 行行出状元</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="q3" type="text" value="" readonly="" style="text-align: right">
            </div>
        </div>
    </div>
    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" href="5.ftl" id="showTooltips">下一题</a>
        <a class="weui-btn weui-btn_warn" href="javascript:" id="showTooltips">上一题</a>
    </div>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">
    $("#q1").picker({
        title: "请选择您的观点",
        cols: [
            {
                textAlign: 'center',
                values: ['非常赞成', '赞成', '无所谓', '不赞成', '非常不赞成']
            }
        ],
        onChange: function(p, v, dv) {
            console.log(p, v, dv);
        },
        onClose: function(p, v, d) {
            console.log("close");
        }
    });

    $("#q2").picker({
        title: "请选择您的观点",
        cols: [
            {
                textAlign: 'center',
                values: ['非常赞成', '赞成', '无所谓', '不赞成', '非常不赞成']
            }
        ],
        onChange: function(p, v, dv) {
            console.log(p, v, dv);
        },
        onClose: function(p, v, d) {
            console.log("close");
        }
    });

    $("#q3").picker({
        title: "请选择您的观点",
        cols: [
            {
                textAlign: 'center',
                values: ['非常赞成', '赞成', '无所谓', '不赞成', '非常不赞成']
            }
        ],
        onChange: function(p, v, dv) {
            console.log(p, v, dv);
        },
        onClose: function(p, v, d) {
            console.log("close");
        }
    });
</script>
</body>
</html>
