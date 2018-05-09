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
    <div class="weui-cells__title" id="title"></div>
    <div class="weui-cell" id="selections">
        <#--<div class="weui-cell__hd">-->
            <#--<label for="date" class="weui-label" style="width: 100%">最重要</label>-->
        <#--</div>-->
        <#--<div class="weui-cell__bd">-->
            <#--<input class="weui-input" id="q1" type="text" readonly="readonly" style="text-align: right" placeholder="">-->
        <#--</div>-->
    </div>
    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" id="next">下一题</a>
        <a class="weui-btn weui-btn_warn back" href="javascript:">上一题</a>
    </div>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

    //获取问题
    $.ajax({
        url: "/questions/getQuestionByID?id=8",
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
                    html += '<div class="weui-cell"><div class="weui-cell__hd">' +
                            '<label for="date" class="weui-label" style="width: 100%">'+ selections.selectionText +
                            '</label></div><div class="weui-cell__bd">' +
                            '<input class="weui-input" id="q'+ i +'" type="text" readonly="readonly" ' +
                            'style="text-align: right" placeholder=""></div></div>';
                }
                $("#selections").html(html);
                //添加选项内的内容
                function getLabel(value){
                    switch (value[0]) {
                        case 0:
                            return selections[0];
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
            }
            else
                weui.topTips("获取问题失败", 1000);
        }
    });


    $('#next').on('click',function () {
        // var value1 = $('#q1').val();
        // var value2 = $('#q2').val();
        // var value3 = $('#q3').val();
        // if ((value1 === value2) || (value3 === value1) || (value3 === value2)){
        //     weui.topTips('请选择正确的排序', 3000);
        // }
        // else {
            $('#next').attr('href','4')
        // }
    });


</script>
</body>
</html>
