package com.owmax.controller;

import com.owmax.model.All;
import com.owmax.model.Data;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panpan on 2017/4/18    ^_^
 */

@Controller
@Transactional(propagation= Propagation.REQUIRED)
@RequestMapping("/data")
public class DataController extends BaseController{

    /**
     * 通过用户ID来获取数据
     * http://localhost:8080/data/queryDataByUser?userID=1
     * @param userID  用户ID
     * @return json
     */
    @RequestMapping(value = "/queryDataByUser",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryDataByUser(int userID){
        Map map = new HashMap<>();
        try {
            //英雄信息
            List<Data> dataList = dataService.queryDataByUserID(userID);
            int size = dataList.size();
            Map rows[] = new Map[size];
            for(int i = 0 ;i<size;i++) {
                Data data =  dataList.get(i);
                float kd = Float.valueOf(data.getAverageKill())/Float.valueOf(data.getAverageDead());
                float winRate = Float.valueOf(data.getGameWinning())/Float.valueOf(data.getGameTime());
                rows[i] = new HashMap<>();
                rows[i].put("hero",data.getHero());
                rows[i].put("averageCritRate",data.getAverageCritRate());
                rows[i].put("averageDamage",data.getAverageDamage());
                rows[i].put("averageDamageDefense",data.getAverageDamageDefense());
                rows[i].put("averageDead",data.getAverageDead());
                rows[i].put("averageDefenseKill",data.getAverageDefenseKill());
                rows[i].put("averageHitRate",data.getAverageHitRate());
                rows[i].put("averageKill",data.getAverageKill());
                rows[i].put("averageLastKill",data.getAverageLastKill());
                rows[i].put("averageSingleKill",data.getAverageSingleKill());
                rows[i].put("averageTime",data.getAverageTime());
                rows[i].put("averageTreatment",data.getAverageTreatment());
                rows[i].put("gameTime",data.getGameTime());
                rows[i].put("gameWinning",data.getGameWinning());
                rows[i].put("bestDamage",data.getBestDamage());
                rows[i].put("bestHitRate",data.getBestHitRate());
                rows[i].put("bestKill",data.getBestKill());
                rows[i].put("bestTime",data.getBestTime());
                rows[i].put("bestTreatment",data.getBestTreatment());
                rows[i].put("kd",String.format("%.2f",kd));
                rows[i].put("winRate",String.format("%.2f",winRate));
            }
            map.put("data",rows);

            //全局信息
            List<All> list = allService.queryALL();
            size = list.size();
            Map rows2[] = new Map[size];
            for (int i = 0;i<size;i++){
                All all = list.get(i);
                rows2[i] = new HashMap<>();
                rows2[i].put("hero",all.getHero());
                rows2[i].put("appearance",all.getAppearance());
                rows2[i].put("winRate",all.getWinRate());
                rows2[i].put("kd",all.getKd());
            }
            map.put("all",rows2);
            map.put("result",true);
        }
        catch (Exception e){
            map.put("result",e.getMessage());
        }
        return gson.toJson(map);
    }

    /**
     * 通过用户ID来获取数据
     * http://localhost:8080/data/queryHeroDataByUser?userID=1&hero=源氏
     * @param userID  用户ID
     * @param hero  英雄名称
     * @return data数据
     */
    @RequestMapping(value = "/queryHeroDataByUser",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView queryHeroDataByUser(int userID, String hero){
        ModelAndView modelAndView = new ModelAndView("/wechat/hero");
        try {
            Data data = dataService.queryHeroDataByUserID(userID,hero);
            float kd = Float.valueOf(data.getAverageKill())/Float.valueOf(data.getAverageDead());
            float winRate = Float.valueOf(data.getGameWinning())/Float.valueOf(data.getGameTime());
            modelAndView.addObject("hero",data.getHero());
            modelAndView.addObject("averageCritRate",data.getAverageCritRate());
            modelAndView.addObject("averageDamage",data.getAverageDamage());
            modelAndView.addObject("averageDamageDefense",data.getAverageDamageDefense());
            modelAndView.addObject("averageDead",data.getAverageDead());
            modelAndView.addObject("averageDefenseKill",data.getAverageDefenseKill());
            modelAndView.addObject("averageHitRate",data.getAverageHitRate());
            modelAndView.addObject("averageKill",data.getAverageKill());
            modelAndView.addObject("averageLastKill",data.getAverageLastKill());
            modelAndView.addObject("averageSingleKill",data.getAverageSingleKill());
            modelAndView.addObject("averageTime",data.getAverageTime());
            modelAndView.addObject("averageTreatment",data.getAverageTreatment());
            modelAndView.addObject("gameTime",data.getGameTime());
            modelAndView.addObject("gameWinning",data.getGameWinning());
            modelAndView.addObject("bestDamage",data.getBestDamage());
            modelAndView.addObject("bestHitRate",data.getBestHitRate());
            modelAndView.addObject("bestKill",data.getBestKill());
            modelAndView.addObject("bestTime",data.getBestTime());
            modelAndView.addObject("bestTreatment",data.getBestTreatment());
            modelAndView.addObject("kd",String.format("%.2f",kd));
            modelAndView.addObject("winRate",String.format("%.2f",winRate));
        }
        catch (Exception e){
            modelAndView.addObject("result",e.getMessage());
        }
        return modelAndView;
    }


}
