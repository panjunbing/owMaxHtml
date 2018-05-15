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
    <div class="weui-cells__title" id="title"></div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <textarea class="weui-textarea" placeholder="请输入文本" rows="3" name="blankText"></textarea>
                <div class="weui-textarea-counter"><span>0</span>/200</div>
            </div>
        </div>
    </div>
    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" href="javascript:" id="next">提交</a>
        <a class="weui-btn weui-btn_warn back" href="javascript:">上一题</a>
    </div>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

    //获取问题
    $.ajax({
        url: "/questions/getQuestionByID?id=9",
        data: JSON,
        async: false,
        success: function (data) {
            var result = eval(data);
            if (result.result) {
                var title = result.title;
                $("#title").html(title);
            }
            else
                weui.topTips("获取问题失败", 1000);
        }
    });


    $('#next').on('click',function () {
        weui.form.validate('#form', function (error) {
            if (!error) {
                $.ajax({
                    url: "/answer/addSelectionAnswer",
                    data: $('#form').serialize(),
                    async: false,
                    success: function (data) {
                        var result = eval(data);
                        if(result.result) {
                            var questionID = result.questionID;
                            $.ajax({
                                url: "/questions/getQuestionsType?id=" + questionID,
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
                weui.topTips('请输入填空', 3000);
            }
            // return true; // 当return true时，不会显示错误
        }, {
            regexp: {
                IDNUM: /(?:^\d{15}$)|(?:^\d{18}$)|^\d{17}[\dXx]$/,
                VCODE: /^.{4}$/
            }
        });
    });
</script>
</body>
</html>
