<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl"/>
</head>
<title>青年调查问卷</title>
<body>
<div class="page">
    <#include "common/header.ftl"/>
    <div class="weui-msg">
        <div class="weui-msg__text-area">
            <p class="weui-msg__desc">您已完成团青调查问卷的填写，是否提交问卷？</p>
        </div>
        <div class="weui-msg__opr-area">
            <p class="weui-btn-area">
                <a href="javascript:" class="weui-btn weui-btn_primary" id="submit">是</a>
                <a href="javascript:" class="weui-btn weui-btn_default">否</a>
            </p>
        </div>
        <div class="weui-msg__extra-area">
            <div class="weui-footer">
                <p class="weui-footer__links">
                    <a href="javascript:void(0);" class="weui-footer__link">底部链接文本</a>
                </p>
                <p class="weui-footer__text">Copyright &copy; 2008-2016 weui.io</p>
            </div>
        </div>
    </div>
    <#--<#include "common/footer.ftl"/>-->
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">
    $('#submit').on('click',function () {
        $.ajax({
            url: "/answer/submit",
            data: $('#form').serialize(),
            async: false,
            success: function (data) {
                var result = eval(data);
                if (result.result) {
                    var questionURL = "success";
                    $(location).attr('href', questionURL);
                    $(window).attr('location', questionURL);
                    $(location).prop('href', questionURL);
                }
                else
                    weui.topTips(result.message, 1000);
            }
        });
    });
</script>
</body>
</html>
