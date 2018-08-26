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
     * 添加选择题回答（保存到session中）,并返回下一题的题号
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
            int questionID = (int) session.getAttribute("questionID");
            QuestionnaireUser user = (QuestionnaireUser) session.getAttribute("user");
            List<AnswerSelections> answerSelectionsList = (List<AnswerSelections>) session.getAttribute("answerSelectionsList");
            List<AnswerSelections> answerSelectionsListTemp = new ArrayList<>();
            //新建AnswerSelects
            for (int selectionID : selectionsID) {
                Selections selection = selectionsService.get(selectionID);
                AnswerSelections answerSelection = new AnswerSelections(user,selection);
                //当选项为其他时
                if(selectionOther != null && selection.getSelection().equals("其他")){
                    answerSelection.setSelectionOther(selectionOther);
                }
                //如果元素存在则删除元素再添加，否则直接添加
                for(AnswerSelections answerSelectionTemp:answerSelectionsList) {
                    if(answerSelectionTemp.getSelections().getQuestions().getId() == questionID){
                        //元素存在
                        answerSelectionsList.remove(answerSelectionTemp);
                        break;
                    }
                }
                //加入临时List，防止多选题第二次遍历的时候删除第一次添加的回答
                answerSelectionsListTemp.add(answerSelection);
            }
            //添加元素
            if(answerSelectionsListTemp.size() > 0){
                answerSelectionsList.addAll(answerSelectionsListTemp);
            }
            //添加到session中
            session.setAttribute("answerSelectionsList",answerSelectionsList);

            //添加上一题ID
            session.setAttribute("lastQuestionID",questionID);
            //判断是否需要跳转
            Selections selections = selectionsService.get(selectionsID[0]);
            List<Jump> jumpList = new ArrayList<>(selections.getJumps());
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
     * 添加填空题回答（保存到session中）,并返回下一题的题号
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
            //为了获取当前填空题的id
            int questionID = (int) session.getAttribute("questionID");
            Questions question = questionsService.get(questionID);
            List<Blanks> blanksList = new ArrayList<>(question.getBlankses());
            List<AnswerBlanks> answerBlanksList = (List<AnswerBlanks>) session.getAttribute("answerBlanksList");
            List<AnswerBlanks> answerBlanksListTemp = new ArrayList<>();

            for (int i = 0;i<blanksList.size();i++){
                AnswerBlanks answerBlank = new AnswerBlanks(user,blanksList.get(i),blankText[i]);
                //如果元素存在则删除元素再添加，否则直接添加
                for(AnswerBlanks answerBlanksTemp:answerBlanksList) {
                    if (answerBlanksTemp.getBlanks().getQuestions().getId() == questionID){
                        //元素存储
                        answerBlanksList.remove(answerBlanksTemp);
                        break;
                    }
                }
                //加入临时List，防止多填空第二次遍历的时候删除第一次添加的回答
                answerBlanksListTemp.add(answerBlank);
            }
            //添加元素
            if(answerBlanksListTemp.size() > 0){
                answerBlanksList.addAll(answerBlanksListTemp);
            }
            session.setAttribute("answerBlanksList",answerBlanksList);
            session.setAttribute("lastQuestionID",questionID);
            session.setAttribute("questionID",questionID+1);
            map.put("result", true);
            map.put("questionID",question.getId()+1);
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }

    /**
     * 将session中保存的答案提交
     * http://localhost:8080/answer/submit
     * @return json
     */
    @RequestMapping(value = "/submit",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String submit(HttpServletRequest request) {
        Map<Object, Object> map = new HashMap<>();
        try {
            HttpSession session = request.getSession();
            //保存选择题回答
            List<AnswerSelections> answerSelectionsList = new ArrayList<>();
            answerSelectionsList = (List<AnswerSelections>) session.getAttribute("answerSelectionsList");
            for (AnswerSelections answerSelection:answerSelectionsList){
                answerSelectionsService.save(answerSelection);
            }
            //保存填空题回答
            List<AnswerBlanks> answerBlanksList = new ArrayList<>();
            answerBlanksList = (List<AnswerBlanks>) session.getAttribute("answerBlanksList");
            for (AnswerBlanks answerBlanks:answerBlanksList){
                answerBlanksService.save(answerBlanks);
            }
            //设置用户已答题
            QuestionnaireUser user = (QuestionnaireUser) session.getAttribute("user");
            user.setIsAnswer(true);
            questionnaireUserService.update(user);

            map.put("result",true);
        } catch (Exception e) {
            map.put("result", false);
            map.put("message", e.getMessage());
        }
        return gson.toJson(map);
    }
}
