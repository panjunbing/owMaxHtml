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
<title>守望先锋助手</title>
<body>

<div class="weui-tab" id="page-index">
    <header class="demos-header">
        <h1 class="demos-title">OwMax</h1>
        <p class="demos-sub-title">守望先锋数据查询</p>
    </header>
    <a href="javascript:" class="weui-search-bar__cancel-btn" id="searchCancel">取消</a>
    <a id="scrapy" href="#" style="position: absolute;top: 0;right: 0;font-size: small;color: black;padding: 10px">查询用户</a>
    <a id="refresh" href="#" style="position: absolute;top: 0;left: 0;font-size: small;color: black;padding: 10px"><img style="height: 22px" src="images/icon_refresh.png" alt=""></a>
    <div class="weui-navbar" style="position: initial">
        <a class="weui-navbar__item weui-bar__item--on" id="tabButton1" href="#tab1" >
            个人
        </a>
        <a class="weui-navbar__item" href="#tab2" id="tabButton2">
            全局
        </a>
    </div>
    <div class="weui-tab__bd" style="padding-top: 0">
        <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active" style="height: 1938px">
                <div class="weui-panel" id="all-pannel">
                    <div class="weui-panel__hd">综合</div>
                    <div class="weui-panel__bd">
                        <div class="weui-media-box weui-media-box_small-appmsg">
                            <div class="weui-cells" id="allList">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="weui-panel weui-panel_access" id="hero-pannel">
                    <div class="weui-panel__hd">英雄（点击单项可查看详细~）</div>
                    <div class="weui-panel__bd" id="heroList">
                    </div>
                </div>
                <div class="weui-panel" id="best-pannel">
                    <div class="weui-panel__hd">最佳</div>
                    <div class="weui-panel__bd">
                        <div class="weui-media-box weui-media-box_small-appmsg">
                            <div class="weui-cells" id="bestList">
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        <div id="tab2" class="weui-tab__bd-item" style="height: 1010px">
            <div class="weui-cells__title">全局信息</div>
            <div class="weui-cells" id="allList2">
            </div>
        </div>
    </div>
</div>
<#include "common/js.ftl"/>
<script type="text/javascript">

</script>
</body>
</html>
