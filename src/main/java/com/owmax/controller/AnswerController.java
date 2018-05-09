package com.owmax.controller;

import com.owmax.model.*;
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
     * 添加选择题回答
     * http://localhost:8080/answer/addSelectionAnswer?selectionID=3
     * @param selection  选项
     * @return json
     */
    @RequestMapping(value = "/addSelectionAnswer",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addSelectionAnswer(String selection,HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<Object, Object> map = new HashMap<>();
        try {
            AnswerSelections answerSelection = new AnswerSelections();
//            answerSelection.setSelections(selectionsService.get(selectionID));
//            answerSelection.setQuestionnaireUser((QuestionnaireUser)session.getAttribute("user"));
            answerSelectionsService.save(answerSelection);
            map.put("result", true);
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }

    /**
     * 添加选择题回答
     * http://localhost:8080/answer/addBlankAnswer?blankID=3
     * @param blankID  选项
     * @return json
     */



    @RequestMapping(value = "/addBlankAnswer",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addBlankAnswer(String blankID,HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<Object, Object> map = new HashMap<>();
        try {
            AnswerSelections answerSelection = new AnswerSelections();
//            answerSelection.setSelections(selectionsService.get(selectionID));
//            answerSelection.setQuestionnaireUser((QuestionnaireUser)session.getAttribute("user"));
            answerSelectionsService.save(answerSelection);
            map.put("result", true);
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }
}
