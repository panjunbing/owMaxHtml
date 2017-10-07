<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl"/>
</head>
<body>
<header class='demos-header'>
    <h1 class="demos-title">${hero}</h1>
</header>
<div class="bd">
    <div class="page__bd">
        <div class="weui-cells">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>总场次</p>
                </div>
                <div class="weui-cell__ft">${gameTime}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>胜率</p>
                </div>
                <div class="weui-cell__ft">${winRate}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>KD</p>
                </div>
                <div class="weui-cell__ft">${kd}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>平均伤害量</p>
                </div>
                <div class="weui-cell__ft">${averageDamage}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>平均伤害吸收量</p>
                </div>
                <div class="weui-cell__ft">${averageDamageDefense}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>平均攻防击杀数</p>
                </div>
                <div class="weui-cell__ft">${averageDefenseKill}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>平均命中率</p>
                </div>
                <div class="weui-cell__ft">${averageHitRate}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>平均击杀数</p>
                </div>
                <div class="weui-cell__ft">${averageKill}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>平均最后一击数</p>
                </div>
                <div class="weui-cell__ft">${averageLastKill}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>平均攻防时间</p>
                </div>
                <div class="weui-cell__ft">${averageTime}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>平均治疗量</p>
                </div>
                <div class="weui-cell__ft">${averageTreatment}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>单场最多伤害量</p>
                </div>
                <div class="weui-cell__ft">${bestDamage}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>单场最多命中率</p>
                </div>
                <div class="weui-cell__ft">${bestHitRate}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>单场最多击杀</p>
                </div>
                <div class="weui-cell__ft">${bestKill}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>单场最多攻防时间</p>
                </div>
                <div class="weui-cell__ft">${bestTime}</div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>单场最多治疗量</p>
                </div>
                <div class="weui-cell__ft">${bestTreatment}</div>
            </div>

        </div>
    </div>
</div>

<#include "common/js.ftl"/>
<script type="text/javascript">
</script>
</body>
</html>
