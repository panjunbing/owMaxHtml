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

<div class="page">
    <header class="demos-header">
        <h1 class="demos-title">青年调查问卷</h1>
        <p class="demos-sub-title">xxxxxxxxxxxxxxx</p>
    </header>
    <form id="form" method="post" action="">
        <div id="questions">
        <div class="weui-cells__title" id="title"></div>
        </div>
        <#--<div class="weui-cells__title" id="title"></div>-->
        <#--<div class="weui-cells weui-cells_radio" id = selections>-->
        <#--<label class="weui-cell weui-check__label" for="x11">-->
        <#--<div class="weui-cell__bd">-->
        <#--<p>高中及以下</p>-->
        <#--</div>-->
        <#--<div class="weui-cell__ft">-->
        <#--<input type="radio" class="weui-check" name="radio" id="x11" required tips="请选择其中一个选项">-->
        <#--<span class="weui-icon-checked"></span>-->
        <#--</div>-->
        <#--</label>-->
        <#--</div>-->
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" id="next">下一题</a>
        </div>
    </form>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

    //获取问题
    $.ajax({
        url: "/questions/getQuestionByID?id=4",
        data: JSON,
        async: false,
        success: function (data) {
            var result = eval(data);
            if (result.result) {
                $('#title').html(result.title);
                var text = result.text;
                var selectionTexts = result.selectionText;
                var html = "";
                for(var i=0;i < text.length;i++){
                    html += '<div class="weui-cells__title">'+ text[i].text +'</div>' +
                            '<div class="weui-cells weui-cells_radio" id = selections'+ i +'></div>';
                }
                $("#questions").append(html);
                html="";
                var count = 0;
                for(var j=0;j < selectionTexts.length;j++){
                    var selection =  selectionTexts[j].text;
                    for(var k=0;k < selection.length;k++){
                        html += '<label class="weui-cell weui-check__label" for="x'+ count +'"><div class="weui-cell__bd"><p>'
                                + selection[k].selection +'</p></div><div class="weui-cell__ft">' +
                                '<input type="radio" class="weui-check" name="selectionID" id="x' + count +
                                '" required tips="请选择其中一个选项" value="'+ selection[k].selectionID +'">' +
                                '<span class="weui-icon-checked"></span></div></label>';
                        count++;
                    }
                    var s = $('#selections'+j);
                    s.html(html);
                    html="";
                }
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
