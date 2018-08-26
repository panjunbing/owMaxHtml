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
    <form id="form" action="" method="post">
        <div class="weui-cells__title" id="title"></div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <textarea name="blankText" id="blankText" class="weui-textarea" placeholder="请输入内容" rows="3"></textarea>
                    <div class="weui-textarea-counter"><span>0</span>/200</div>
                </div>
            </div>
        </div>
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" href="javascript:" id="next">下一题</a>
            <a class="weui-btn weui-btn_warn" id="back">上一题</a>
        </div>
    </form>
    <#--<#include "common/footer.ftl"/>-->
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

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
            }
            else
                weui.topTips("获取问题失败", 1000);
        }
    });


    $('#next').on('click',function () {
        //判断输入框是否为空
        var text = $('#blankText').val();
        if(text!=="") {
            $.ajax({
                url: "/answer/addBlanksAnswer",
                data: $('#form').serialize(),
                async: false,
                success: function (data) {
                    var result = eval(data);
                    if (result.result) {
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
            weui.topTips("请输入内容", 1000);
        }
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
