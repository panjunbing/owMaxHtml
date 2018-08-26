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
    <#include "common/header.ftl"/>
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
            <a class="weui-btn weui-btn_warn" id="back">上一题</a>
        </div>
    </form>
    <#--<#include "common/footer.ftl"/>-->
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

    var size = 0;

    //获取问题
    $.ajax({
        url: "/questions/getQuestion",
        data: JSON,
        async: false,
        success: function (data) {
            var result = eval(data);
            if (result.result) {
                var title = result.questionID +"、"+ result.title;
                $("#title").html(title);
                var text = result.text;
                var selectionTexts = result.selectionText;
                var html = "";
                size = text.length;
                for(var i=0;i < size;i++){
                    html += '<div class="weui-cells__title">'+ "（" + i + "）" + text[i].text +'</div>' +
                            '<div class="weui-cells weui-cells_radio" id = selections'+ i +'></div>';
                }
                $("#questions").append(html);
                html="";
                var count = 0;
                for(var j=0;j < selectionTexts.length;j++){
                    var selection =  selectionTexts[j].text;
                    for(var k=0;k < selection.length;k++){
                        html += '<label class="weui-cell weui-check__label" for="x'+ count +'">' +
                                '<div class="weui-cell__bd"><p>' + selection[k].selection +
                                '</p></div><div class="weui-cell__ft">' +
                                '<input type="radio" class="weui-check" name="selectionID'+ j +'" id="x' +
                                count + '" required tips="请选择其中一个选项" value="'+ selection[k].selectionID +
                                '">' + '<span class="weui-icon-checked"></span></div></label>';
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
        weui.form.validate('#form', function (error) {
            if (!error) {
                var selections = $('#form').serializeArray();
                var json = "selectionsID=" + selections[0].value;
                for (var i = 1;i < selections.length;i++){
                    json += "&selectionsID=";
                    json +=  selections[i].value;
                }

                $.ajax({
                    url: "/answer/addSelectionsAnswer?"+ json,
                    async: false,
                    success: function (data) {
                        var result = eval(data);
                        if(result.result) {
                            var questionID = result.questionID;
                            $.ajax({
                                url: "/questions/getQuestionType?id=" + questionID,
                                async: false,

                                success: function (data) {
                                    var result = eval(data);
                                    if (result.result) {
                                        var questionURL = "question" + result.type;
                                        $(location).attr('href', questionURL);
                                        $(window).attr('location', questionURL);
                                        $(location).prop('href', questionURL);
                                    }
                                    else {
                                        weui.topTips(result.message, 1000);
                                    }
                                }
                            });
                        }
                        else {
                            weui.topTips(result.message, 1000);
                        }
                    }
                });
            }
            else {
                weui.topTips('请选择您的选项', 3000);
            }
            // return true; // 当return true时，不会显示错误
        }, {
            regexp: {
                IDNUM: /(?:^\d{15}$)|(?:^\d{18}$)|^\d{17}[\dXx]$/,
                VCODE: /^.{4}$/
            }
        });
    });

    //返回上一题
    $('#back').on('click',function () {
        $.ajax({
            url: "/questions/back",
            async: false,
            success: function (data) {
                var result = eval(data);
                if(result.result) {
                    var questionID = result.lastQuestionID;
                    $.ajax({
                        url: "/questions/getQuestionType?id=" + questionID,
                        async: false,
                        success: function (data) {
                            var result = eval(data);
                            if (result.result) {
                                var questionURL = "question" + result.type;
                                $(location).attr('href', questionURL);
                                $(window).attr('location', questionURL);
                                $(location).prop('href', questionURL);
                            }
                            else {
                                weui.topTips(result.message, 1000);
                            }
                        }
                    });
                }
                else {
                    weui.topTips(result.message, 1000);
                }
            }
        });
    });


</script>
</body>
</html>
