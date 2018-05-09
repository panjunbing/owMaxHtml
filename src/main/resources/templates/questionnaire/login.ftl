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
    <form id="form_login" method="post" action="">
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label class="weui-label">账号</label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" id="username" name="username" type="text" maxlength="18" required
                           placeholder="输入您的账号" emptytips="请输入账号" notmatchtips="请输入正确的账号">
                </div>
                <div class="weui-cell__ft"><i class="weui-icon-warn"></i></div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label class="weui-label">密码</label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" id="password" name="password" type="password" maxlength="18" required
                           placeholder="输入您的密码" emptytips="请输入密码" notmatchtips="请输入正确的密码">
                </div>
                <div class="weui-cell__ft"><i class="weui-icon-warn"></i></div>
            </div>
        </div>
        <div class="weui-btn-area">
            <a id="login" type="submit" href="javascript:" class="weui-btn weui-btn_primary">登录</a>
        </div>
    </form>
</div>

<#include "common/js.ftl"/>
<script type="text/javascript">


    $('#login').on('click',function () {
        weui.form.validate('#form_login', function (error) {
            if (!error) {
                var loading = weui.loading('登录中');
                setTimeout(function () {
                    $.ajax({
                        url: "/questionnaireUser/login",
                        type: "post",
                        data: $('#form_login').serialize(),
                        async: false,
                        success: function (data) {
                            loading.hide();
                            var result = eval(data);
                            if(result.result){
                                weui.toast('登录成功',500);
                                var userID = result.userID;
                                setTimeout(function () {
                                    //获取问题类型
                                    $.ajax({
                                        url:"/questions/getQuestionType?id=1",
                                        async:false,
                                        success:function (data) {
                                            var result = eval(data);
                                            if(result.result){
                                                var questionURL = "question" + result.type;
                                                $(location).attr('href',questionURL);
                                                $(window).attr('location',questionURL);
                                                $(location).prop('href',questionURL);
                                            }
                                            else{
                                                weui.topTips(result.message, 1000);
                                            }
                                        }
                                    });
                                },500);
                            }
                            else{
                                weui.topTips(result.message, 1000);
                            }
                        }
                    });
                },500);
            }
        }, {
            regexp: {
            }
        });
    });

    weui.form.checkIfBlur('#form_login', {
        regexp: {
        }
    });

</script>
</body>
</html>
