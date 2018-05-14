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
     * 添加选择题回答,并返回下一题的题号
     * http://localhost:8080/answer/addSelectionsAnswer?selectionsID=3
     * @param selectionsID  选项ID数组
     * @return json
     */
    @RequestMapping(value = "/addSelectionsAnswer",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addSelectionsAnswer(int selectionsID[],String selectionOther,HttpServletRequest request){
        Map<Object, Object> map = new HashMap<>();
        try {
            HttpSession session = request.getSession();
            QuestionnaireUser user = (QuestionnaireUser) session.getAttribute("user");
            List<AnswerSelections> answerSelectionsList = (List<AnswerSelections>) session.getAttribute("answerSelectionsList");
            for (int selectionID : selectionsID) {
                Selections selection = selectionsService.get(selectionID);
                //在此处添加回答入session中
                AnswerSelections answerSelection = new AnswerSelections(user,selection);
                if(selectionOther != null){
                    answerSelection.setSelectionOther(selectionOther);
                }
                answerSelectionsList.add(answerSelection);
            }
            session.setAttribute("answerSelectionsList",answerSelectionsList);

            //判断是否需要跳转
            Selections selections = selectionsService.get(selectionsID[0]);
            List<Jump> jumpList = new ArrayList<>(selections.getJumps());
            int questionID = 0;
            if(jumpList.size() > 0)
                questionID = jumpList.get(0).getQuestions().getId();
            else
                questionID = selections.getQuestions().getId()+1;
            session.setAttribute("questionID",questionID);
            map.put("questionID",questionID);
            map.put("result", true);
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }


    /**
     * 添加填空题回答
     * http://localhost:8080/answer/addBlanksAnswer?blanks=test
     * @param blankText  填空
     * @return json
     */
    @RequestMapping(value = "/addBlanksAnswer",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addBlanksAnswer(String blankText[],HttpServletRequest request){
        Map<Object, Object> map = new HashMap<>();
        try {
            HttpSession session = request.getSession();
            QuestionnaireUser user = (QuestionnaireUser) session.getAttribute("user");
            int questionsID = (int) session.getAttribute("questionID");
            Questions question = questionsService.get(questionsID);
            List<Blanks> blanksList = new ArrayList<>(question.getBlankses());
            List<AnswerBlanks> answerBlanksList = (List<AnswerBlanks>) session.getAttribute("answerBlanksList");
            for (int i = 0;i<blanksList.size();i++){
                AnswerBlanks answerBlank = new AnswerBlanks(user,blanksList.get(i),blankText[i]);
                answerBlanksList.add(answerBlank);
            }
            session.setAttribute("answerBlanksList",answerBlanksList);
            session.setAttribute("questionID",question.getId()+1);
            map.put("result", true);
            map.put("questionID",question.getId()+1);
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }
}
