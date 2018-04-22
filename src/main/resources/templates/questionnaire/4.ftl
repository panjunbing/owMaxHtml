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
        <a class="weui-btn weui-btn_primary" href="5" id="showTooltips">下一题</a>
        <a class="weui-btn weui-btn_warn back" href="javascript:">上一题</a>
    </div>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

    function getLabel(value){
        switch (value[0]) {
            case 0:
                return '非常赞成';
            case 1:
                return '赞成';
            case 2:
                return '无所谓';
            case 3:
                return '不赞成';
            case 4:
                return '非常不赞成';
        }
    }

    $('#q1').on('click', function () {
        weui.picker([{
            label: '非常赞成',
            value: 0
        }, {
            label: '赞成',
            value: 1
        }, {
            label: '无所谓',
            value: 2
        },{
            label: '不赞成',
            disabled: true,
            value: 3
        }, {
            label: '非常不赞成',
            value: 4
        }], {
            defaultValue: [0],
            onChange: function (result) {
                // console.log(result);
            },
            onConfirm: function (result) {
                $("#q1").attr('value',getLabel(result));
            }
        });
    });

    $("#q2").on('click', function () {
        weui.picker([{
            label: '非常赞成',
            value: 0
        }, {
            label: '赞成',
            value: 1
        }, {
            label: '无所谓',
            value: 2
        },{
            label: '不赞成',
            disabled: true,
            value: 3
        }, {
            label: '非常不赞成',
            value: 4
        }], {
            defaultValue: [0],
            onChange: function (result) {
                // console.log(result);
            },
            onConfirm: function (result) {
                $("#q2").attr('value',getLabel(result));
            }
        });
    });

    $("#q3").on('click', function () {
        weui.picker([{
            label: '非常赞成',
            value: 0
        }, {
            label: '赞成',
            value: 1
        }, {
            label: '无所谓',
            value: 2
        },{
            label: '不赞成',
            disabled: true,
            value: 3
        }, {
            label: '非常不赞成',
            value: 4
        }], {
            defaultValue: [0],
            onChange: function onChange(result) {
                // console.log(result);
            },
            onConfirm: function onConfirm(result) {
                $("#q3").attr('value',getLabel(result));
            }
        });
    });
</script>
</body>
</html>
