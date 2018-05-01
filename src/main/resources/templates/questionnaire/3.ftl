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
    <div class="weui-cells__title">3.请从下述激励机制，选出您期望的三项机制，并按照对您的重要程度从大至小进行排序:<br>
        A.奖金 &nbsp; &nbsp; &nbsp; B.荣誉称号及精神鼓励 &nbsp; &nbsp; &nbsp; C.职称或职业资格鉴定 &nbsp; &nbsp; &nbsp;
        D.福利增加&nbsp; &nbsp; &nbsp; E.职位晋升 &nbsp; &nbsp; &nbsp; F.补贴 &nbsp; &nbsp; &nbsp;
        G.休闲娱乐 &nbsp; &nbsp; &nbsp; H.股票期权</div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label for="date" class="weui-label" style="width: 100%">最重要</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="q1" type="text" readonly="readonly" style="text-align: right" placeholder="">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label for="date" class="weui-label" style="width: 100%">第二重要</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="q2" type="text"  readonly="readonly" style="text-align: right" placeholder="">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label for="date" class="weui-label" style="width: 100%">第三重要</label>
        </div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="q3" type="text" readonly="readonly" style="text-align: right" placeholder="">
        </div>
    </div>
    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" id="next">下一题</a>
        <a class="weui-btn weui-btn_warn back" href="javascript:">上一题</a>
    </div>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">
    $('#next').on('click',function () {
        var value1 = $('#q1').val();
        var value2 = $('#q2').val();
        var value3 = $('#q3').val();
        if ((value1 === value2) || (value3 === value1) || (value3 === value2)){
            weui.topTips('请进行正确排序', 3000);
        }
        else {
            $('#next').attr('href','4')
        }
    });

    function getLabel(value){
        switch (value[0]) {
            case 0:
                return '奖金';
            case 1:
                return '荣誉称号及精神鼓励';
            case 2:
                return '职称或职业资格鉴定';
            case 3:
                return '福利增加';
            case 4:
                return '职位晋升';
            case 5:
                return '补贴';
            case 6:
                return '休闲娱乐';
            case 7:
                return '股票期权';
        }
    }

    $('#q1').on('click', function () {
        weui.picker([{
            label: '奖金',
            value: 0
        }, {
            label: '荣誉称号及精神鼓励',
            value: 1
        }, {
            label: '职称或职业资格鉴定',
            value: 2
        },{
            label: '福利增加',
            value: 3
        },{
            label: '职位晋升',
            value: 4
        },{
            label: '补贴',
            value: 5
        },{
            label: '休闲娱乐',
            value: 6
        }, {
            label: '股票期权',
            value: 7
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

    $('#q2').on('click', function () {
        weui.picker([{
            label: '奖金',
            value: 0
        }, {
            label: '荣誉称号及精神鼓励',
            value: 1
        }, {
            label: '职称或职业资格鉴定',
            value: 2
        },{
            label: '福利增加',
            value: 3
        },{
            label: '职位晋升',
            value: 4
        },{
            label: '补贴',
            value: 5
        },{
            label: '休闲娱乐',
            value: 6
        },{
            label: '股票期权',
            value: 7
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

    $('#q3').on('click', function () {
        weui.picker([{
            label: '奖金',
            value: 0
        }, {
            label: '荣誉称号及精神鼓励',
            value: 1
        }, {
            label: '职称或职业资格鉴定',
            value: 2
        },{
            label: '福利增加',
            value: 3
        },{
            label: '职位晋升',
            value: 4
        },{
            label: '补贴',
            value: 5
        },{
            label: '休闲娱乐',
            value: 6
        },{
            label: '股票期权',
            value: 7
        }],{
            onChange: function (result) {
                // console.log(result);
            },
            onConfirm: function (result) {
                $("#q3").attr('value',getLabel(result));
            }
        });
    });
</script>
</body>
</html>
