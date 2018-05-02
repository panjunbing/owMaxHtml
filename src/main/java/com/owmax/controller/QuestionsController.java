package com.owmax.controller;

import com.owmax.model.QuestionnaireUser;
import com.owmax.model.Questions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by panpan on 2017/4/18    ^_^
 */

@Controller
@RequestMapping("/questions")
public class QuestionsController extends BaseController{

    /**
     * 登录
     * http://localhost:8080/questions/getQuestion?id=1
     * @param id  用户名
     * @return json
     */
    @RequestMapping(value = "/getQuestion",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(int id){
        Map map = new HashMap<>();
        try {
            Questions questions = questionsService.get(id);
            if(questions != null) {
                map.put("title",questions.getTitle());
                int type = questions.getType();
                //根据题目类型进行判断
                map.put("result", true);
            }
            else {
                map.put("result", false);
                map.put("message", "问题ID不存在！");
            }
        }
        catch (Exception e){
            map.put("result",e.getMessage());
        }
        return gson.toJson(map);
    }
}
