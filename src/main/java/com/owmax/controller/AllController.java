package com.owmax.controller;

import com.owmax.model.All;
import com.owmax.model.Data;
import com.owmax.model.User;
import com.owmax.scrapy.scrapy;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panpan on 2017/4/18    ^_^
 */

@Controller
@Transactional(propagation= Propagation.REQUIRED)
@RequestMapping("/all")
public class AllController extends BaseController{

    /**
     * 通过用户ID来获取数据
     * http://localhost:8080/all/queryAll
     * @return all数据
     */
    @RequestMapping(value = "/queryAll",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryAll(){
        Map map = new HashMap<>();
        try {
            List<All> list = allService.queryALL();
            int size = list.size();
            Map rows[] = new Map[size];
            for (int i = 0;i<size;i++){
                All all = list.get(i);
                rows[i] = new HashMap<>();
                rows[i].put("hero",all.getHero());
                rows[i].put("appearance",all.getAppearance());
                rows[i].put("winRate",all.getWinRate());
                rows[i].put("kd",all.getKd());
            }
            map.put("data",rows);
        }
        catch (Exception e){
            map.put("result",e.getMessage());
        }
        return gson.toJson(map);
    }
}
