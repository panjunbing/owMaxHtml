package com.owmax.controller;

import com.owmax.model.Blanks;
import com.owmax.model.Jump;
import com.owmax.model.Questions;
import com.owmax.model.Selections;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by panpan on 2017/4/18    ^_^
 */

@Controller
@RequestMapping("/questions")
public class JumpController extends BaseController{

    /**
     * 获取选项跳转的问题号
     * http://localhost:8080/questions/getJump?selection_id=56
     * @param id  选项ID
     * @return json
     */
    @RequestMapping(value = "/getJump",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJump(int id){
        Map<Object, Object> map = new HashMap<>();
        try {
            int questionID = jumpService.queryQuestionBySelection(id);
            if(questionID != 0) {
                map.put("question_id",questionID);
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
