/**
    * Created by panpan on 2017/4/18    ^_^
    */

$(function () {
    "use strict";

    var $tabButton1 = $('#tabButton1');
    var $tabButton2 = $('#tabButton2');
    var $tab1 = $('#tab1');
    var $tab2 = $('#tab2');
    var userID = 0;

    //主页初始化
    $("#page-index").ready(function () {
    });


    //爬取数据
    $('#scrapy').on('click',function () {
        $.prompt({
            title: '提示',
            text: '请输入用户名称，例如：隔壁小王-52430',
            input: '隔壁小王-52430',
            empty: false, // 是否允许为空
            onOK: function (input) {
                //点击确认
                $.showLoading();
                setTimeout(function() {
                    $.ajax({
                        url: "/user/insertUser?userName="+input,
                        type: "post",
                        data: "json",
                        async: false,
                        success: function (data) {
                            var result = eval(data);
                            if(result.result){
                                userID = result.userID;
                                $("#scrapy").html(input);
                                refesh();
                                $.hideLoading();
                            }
                            else{
                                $.hideLoading();
                                $.toast("纯文字",result.result.errorMsg);
                            }
                        }
                    });
                }, 3000)
            },
            onCancel: function () {
                //点击取消
            }
        });
    });

    //刷新数据按钮
    $('#refresh').on('click',function () {
        $.showLoading();
        setTimeout(function() {
            refesh();
            $.hideLoading();
        }, 3000)

    });

    //刷新数据
    function refesh () {
            //用户英雄数据
            $.ajax({
                    url: "/data/queryDataByUser?userID="+userID,
                    type: "post",
                    data: "json",
                    async: false,
                    success: function (data) {
                        var heroHtml = "";
                        var bestHtml = "";
                        var allHtml = "";
                        var html = "";
                        var result = eval(data);
                        if (result.result == true){
                            //英雄信息
                            var rows = result.data;
                            for (var i = 0; i < rows.length; i++) {
                                if(rows[i].hero == "所有英雄"){
                                    allHtml += '<div class="weui-cell"><div class="weui-cell__bd weui-cell_primary">' +
                                        '<p>总场次</p></div><div class="weui-cell__ft">'+rows[i].gameTime+'</div></div>';
                                    allHtml += '<div class="weui-cell"><div class="weui-cell__bd weui-cell_primary">' +
                                        '<p>胜率</p></div><div class="weui-cell__ft">'+rows[i].winRate+'</div></div>';
                                    allHtml += '<a class="weui-cell weui-cell_access" href="/data/queryHeroDataByUser?userID=1&hero=所有英雄">' +
                                        '<div class="weui-cell__bd"><p>查看详细信息</p></div><div class="weui-cell__ft"></div></a>';
                                    bestHtml += '<div class="weui-cell"><div class="weui-cell__bd weui-cell_primary">' +
                                        '<p>单场最多击杀数</p></div><div class="weui-cell__ft">'+rows[i].bestKill+'</div></div>';
                                    bestHtml += '<div class="weui-cell"><div class="weui-cell__bd weui-cell_primary">' +
                                        '<p>单场最多治疗量</p></div><div class="weui-cell__ft">'+rows[i].bestDamage+'</div></div>';
                                    bestHtml += '<div class="weui-cell"><div class="weui-cell__bd weui-cell_primary">' +
                                        '<p>单场最多攻防时间</p></div><div class="weui-cell__ft">'+rows[i].bestTime+'</div></div>'
                                }
                                else {
                                    heroHtml+= "<a href='/data/queryHeroDataByUser?userID=1&hero="+ rows[i].hero +"' class='weui-media-box weui-media-box_appmsg hero'>" +
                                        "<div class='weui-media-box__hd'><img class='weui-media-box__thumb' style='width: 50px' " +
                                        "src='/images/heros/"+ rows[i].hero +".png' ></div>" +
                                        "<div class='weui-media-box__bd'><h4 class='weui-media-box__title' id='heroName'>" +
                                        rows[i].hero+"</h4><p class='weui-media-box__desc'>" +
                                        "场次："+rows[i].gameTime+"    胜率："+rows[i].winRate+"    KD："+rows[i].kd+"</p></div></a>";
                                }
                            }
                            $('#allList').html(allHtml);
                            $('#heroList').html(heroHtml);
                            $('#bestList').html(bestHtml);

                            //全局信息
                            var rows2 = result.all;
                            for (i = 0; i < rows.length; i++) {
                                html += '<div class="weui-cell"><div class="weui-cell__bd">' +
                                    '<p>'+rows2[i].hero+'</p></div><div class="weui-cell__ft small_size">' +
                                    '出场率：'+rows2[i].appearance+'  胜率：'+ rows2[i].winRate +'  KD:'+ rows2[i].kd +'</div></div>'
                            }
                            var $allList2 = $('#allList2');
                            $allList2.html(html);

                            //根据目前tab跳转tab高度
                            if($tabButton1.is(".weui-bar__item--on"))
                                $tab1.height($('#all-pannel').height()+$('#hero-pannel').height()+$('#best-pannel').height()+30);
                            else
                                $tab2.height($allList2.height() + $(".weui-cells__title").height() + 20);
                            $.toast("操作成功");
                        }
                        else{
                            $.toast("纯文字",result.result.errorMsg);
                        }
                    }
                }
            )
    }

});