package com.owmax.controller;

import com.owmax.model.Blanks;
import com.owmax.model.Questions;
import com.owmax.model.Selections;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by panpan on 2017/4/18    ^_^
 */

@Controller
@RequestMapping("/answer")
public class AnswerController extends BaseController{


    /**
     * 获取问题类型
     * http://localhost:8080/answer/addSelectionAnswer
     * @param id  题号
     * @return json
     */
    @RequestMapping(value = "/addSelectionAnswer",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addSelectionAnswer(int id){
        Map<Object, Object> map = new HashMap<>();
        try {
            Questions question = questionsService.get(id);
            if(question != null) {
                int type = question.getType();
                map.put("type",type);
                map.put("result", true);
            }
            else {
                map.put("result", false);
                map.put("message", "问题ID不存在！");
            }
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }
}
