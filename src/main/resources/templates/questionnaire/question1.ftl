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
    <form id="form" method="post" action="">
        <div class="weui-cells__title" id="title"></div>
        <div class="weui-cells weui-cells_checkbox" id="selections">
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
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" id="next">下一题</a>
            <a class="weui-btn weui-btn_warn back" href="7">上一题</a>
        </div>
    </form>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

    //获取问题
    $.ajax({
        url: "/questions/getQuestion?id=8",
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
                    html += '<label class="weui-cell weui-check__label" for="s'+ i +'">' +
                            '<div class="weui-cell__hd"><input type="checkbox" name="selection"' +
                            ' class="weui-check" required pattern="{1,'+ selections[i].maxselection +'}" id="s'+ i +'"' +
                            'tips="请勾选正确的选项数"><i class="weui-icon-checked"></i>' +
                            '</div><div class="weui-cell__bd"><p>'+ selections[i].selection +'</p>\n' +
                            '</div></label>';
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
                $('#next').attr('href','9')
            }
            else {
                // weui.topTips('必须选择1-3项', 3000);
            }
            // return true; // 当return true时，不会显示错误
        }, {
            regexp: {
                IDNUM: /(?:^\d{15}$)|(?:^\d{18}$)|^\d{17}[\dXx]$/,
                VCODE: /^.{4}$/
            }
        });
    })

</script>
</body>
</html>
