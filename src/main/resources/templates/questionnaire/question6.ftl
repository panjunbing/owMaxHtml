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
        <div class="weui-cells__title" id="title"></div>
        <div class="weui-cells weui-cells_checkbox">
            <div id="selections">
            <#--<label class="weui-cell weui-check__label" for="s11">-->
                <#--<div class="weui-cell__hd">-->
                    <#--<input type="checkbox" name="checkbox1" class="weui-check" required pattern="{1,3}" id="s11"-->
                           <#--tips="请勾选1-3个主要压力来源">-->
                    <#--<i class="weui-icon-checked"></i>-->
                <#--</div>-->
                <#--<div class="weui-cell__bd">-->
                    <#--<p>升职</p>-->
                <#--</div>-->
            <#--</label>-->
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <input class="weui-input" id="selectionOther" name="selectionOther" readonly="readonly"
                           type="text" placeholder="请输入你的观点">
                </div>
            </div>
        </div>
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" id="next">下一题</a>
            <a class="weui-btn weui-btn_warn" id="back">上一题</a>
        </div>
    </form>
    <#--<#include "common/footer.ftl"/>-->
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

    //最后一个选项序号
    var last = 0;

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
                var selections = result.selections;
                var html = "";
                last = selections.length - 1;
                 if(result.maxSelection != null){
                    html += '<label class="weui-cell weui-check__label" for="s'+ 0 +'">' +
                            '<div class="weui-cell__hd"><input type="checkbox" name="selectionsID"' +
                            ' class="weui-check" required pattern="{1,'+ result.maxSelection +'}" id="s'+ 0 +
                            '" tips="请勾选正确的选项数" value="'+ selections[0].selectionID + '">' +
                            '<i class="weui-icon-checked"></i>' + '</div><div class="weui-cell__bd">' +
                            '<p>'+ selections[0].selection +'</p></div></label>';
                }
                else {
                    html += '<label class="weui-cell weui-check__label" for="s'+ 0 +'">' +
                            '<div class="weui-cell__hd"><input type="checkbox" name="selectionsID"' +
                            ' class="weui-check" id="s'+ 0 +
                            '" tips="请勾选正确的选项数" value="'+ selections[0].selectionID + '">' +
                            '<i class="weui-icon-checked"></i>' + '</div><div class="weui-cell__bd">' +
                            '<p>'+ selections[0].selection +'</p></div></label>';
                }
                for(var i=1;i < selections.length;i++){
                    html += '<label class="weui-cell weui-check__label" for="s'+ i +'">' +
                            '<div class="weui-cell__hd"><input type="checkbox" name="selectionsID"' +
                            ' class="weui-check" id="s'+ i +
                            '" tips="请勾选正确的选项数" value="'+ selections[i].selectionID + '">' +
                            '<i class="weui-icon-checked"></i>' + '</div><div class="weui-cell__bd">' +
                            '<p>'+ selections[i].selection +'</p></div></label>';
                }
                $("#selections").html(html);
            }
            else
                weui.topTips("获取问题失败", 1000);
        }
    });

    $('#next').on('click',function () {
        weui.form.validate('#form', function (error) {
            if (!error) {
                $.ajax({
                    url: "/answer/addSelectionsAnswer",
                    data: $('#form').serialize(),
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

    //判断其他是否可以填入
    $('#s'+ last).on('click',function () {
        //当前状态是不可填入（未勾选其他）,勾选后应设置为可以填入
        $('#selectionOther').removeAttr("readonly");
        state = true;
    });

    for(var i =0;i < last;i++){
        $('#s'+ i).on('click',function () {
            var $radio_other = $('#selectionOther');
            $radio_other.val('');
            $radio_other.attr("readonly","readonly");
        });
    }

    weui.form.checkIfBlur('#form', {
        regexp: {
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
