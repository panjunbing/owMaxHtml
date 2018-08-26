package com.owmax.controller;

import com.owmax.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Created by panpan on 2017/4/18    ^_^
 */

@Controller
@RequestMapping("/questions")
public class QuestionsController extends BaseController{

    /**
     * 根据session中问题ID获取问题
     * http://localhost:8080/questions/getQuestion
     * @return json
     */
    @RequestMapping(value = "/getQuestion",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getQuestion(HttpServletRequest request){
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("questionID");
        Map<Object, Object> map = new HashMap<>();
        try {
            Questions question = questionsService.get(id);
            if(question != null) {
                map.put("title",question.getTitle());
                map.put("questionID",question.getId());
                map.put("maxSelection",question.getMaxSelection());
                int type = question.getType();
                map.put("type",type);
                //根据题目类型进行判断
                //选择题
                if(type >= 0 && type <= 1 || type >=5){
                    List<Selections> selectionsList = new ArrayList<>(question.getSelectionses());
                    int size = selectionsList.size();
                    Map rows[] = new Map[size];
                    for(int i = 0 ;i<size;i++) {
                        Selections selection = selectionsList.get(i);
                        rows[i] = new HashMap<>();
                        rows[i].put("selectionID", selection.getId());
                        rows[i].put("selection", selection.getSelection());
                    }
                    map.put("selections",rows);
                }
                if (type == 2) {
                    List<Selections> selectionsList = new ArrayList<>(question.getSelectionses());
                    int size = selectionsList.size();
                    List<Map> listTextSelections = new ArrayList<>();
                    List<Map> listSelections = new ArrayList<>();
                    List<Map> listText = new ArrayList<>();

                    for(int i = 0;i<size;i++) {
                        Selections selection = selectionsList.get(i);
                        Map<String, Object> textSelectionsMap = new HashMap<>();
                        Map<String, Object> selectionsMap = new HashMap<>();
                        Map<String, Object> textMap = new HashMap<>();
                        selectionsMap.put("selectionID", selection.getId());
                        selectionsMap.put("selection", selection.getSelection());
                        listSelections.add(selectionsMap);

                        if((i == (size-1) || (!selection.getSelectionText().equals(selectionsList.get(i + 1).getSelectionText())))){
                            textMap.put("text", selection.getSelectionText());
                            listText.add(textMap);
                            textSelectionsMap.put("text",((ArrayList<Map>) listSelections).clone());
                            listTextSelections.add(textSelectionsMap);
                            listSelections.clear();
                        }
                    }
                    map.put("text",listText);
                    map.put("selectionText",listTextSelections);
                }

                else if (type == 4){
                    List<Blanks> blanksList = new ArrayList<>(question.getBlankses());
                    int size = blanksList.size();
                    Map rows[] = new Map[size];
                    for(int i = 0 ;i<size;i++) {
                        Blanks blank = blanksList.get(i);
                        rows[i] = new HashMap<>();
                        rows[i].put("blank", blank.getBlankText());
                        rows[i].put("blankID", blank.getId());
                    }
                    map.put("blanks",rows);
                }
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

    /**
     * 获取问题
     * http://localhost:8080/questions/getQuestionByID?id=1
     * @param id 题号
     * @return json
     */
    @RequestMapping(value = "/getQuestionByID",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getQuestionByID(int id){
        Map<String, Object> map = new HashMap<>();
        try {
            Questions question = questionsService.get(id);
            if(question != null) {
                map.put("title",question.getTitle());
                map.put("questionID",question.getId());
                map.put("maxSelection",question.getMaxSelection());
                int type = question.getType();
                map.put("type",type);
                //根据题目类型进行判断
                //选择题
                if(type >= 0 && type <= 1 || type >= 5){
                    List<Selections> selectionsList = new ArrayList<>(question.getSelectionses());
                    int size = selectionsList.size();
                    Map rows[] = new Map[size];
                    for(int i = 0 ;i<size;i++) {
                        Selections selection = selectionsList.get(i);
                        rows[i] = new HashMap<>();
                        rows[i].put("selectionID", selection.getId());
                        rows[i].put("selection", selection.getSelection());
                    }
                    map.put("selections",rows);
                }
                if (type == 2) {
                    List<Selections> selectionsList = new ArrayList<>(question.getSelectionses());
                    int size = selectionsList.size();
                    List<Map> listTextSelections = new ArrayList<>();
                    List<Map> listSelections = new ArrayList<>();
                    List<Map> listText = new ArrayList<>();

                    for(int i = 0;i<size;i++) {
                        Selections selection = selectionsList.get(i);
                        Map<String, Object> textSelectionsMap = new HashMap<>();
                        Map<String, Object> selectionsMap = new HashMap<>();
                        Map<String, Object> textMap = new HashMap<>();
                        selectionsMap.put("selectionID", selection.getId());
                        selectionsMap.put("selection", selection.getSelection());
                        listSelections.add(selectionsMap);

                        if((i == (size-1) || (!selection.getSelectionText().equals(selectionsList.get(i + 1).getSelectionText())))){
                            textMap.put("text", selection.getSelectionText());
                            listText.add(textMap);
                            textSelectionsMap.put("text",((ArrayList<Map>) listSelections).clone());
                            listTextSelections.add(textSelectionsMap);
                            listSelections.clear();
                        }
                    }
                    map.put("text",listText);
                    map.put("selectionText",listTextSelections);
                }

                else if (type >= 3 && type <= 4){
                    List<Blanks> blanksList = new ArrayList<>(question.getBlankses());
                    int size = blanksList.size();
                    Map rows[] = new Map[size];
                    for(int i = 0 ;i<size;i++) {
                        Blanks blank = blanksList.get(i);
                        rows[i] = new HashMap<>();
                        rows[i].put("blank", blank.getBlankText());
                        rows[i].put("blankID", blank.getId());
                    }
                    map.put("blanks",rows);
                }
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

    /**
     * 返回上一题的题号,并将session中当前题号设置为上一题题号
     * http://localhost:8080/questions/back
     * @return json
     */
    @RequestMapping(value = "/back",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String back(HttpServletRequest request){
        Map<Object, Object> map = new HashMap<>();
        try {
            HttpSession session = request.getSession();
            int lastQuestionID = (int) session.getAttribute("lastQuestionID");
            //当前为第一题时
            if (lastQuestionID == -1){
                map.put("result", false);
                map.put("message","当前已是第一题！");
            }
            else {
                session.setAttribute("questionID",lastQuestionID);
                map.put("lastQuestionID",lastQuestionID);
                map.put("result", true);
            }
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }


    /**
     * 获取问题类型
     * http://localhost:8080/questions/getQuestionType?id=1
     * @param id  题号
     * @return json
     */
    @RequestMapping(value = "/getQuestionType",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getQuestionType(int id){
        Map<Object, Object> map = new HashMap<>();
        try {
            Questions question = questionsService.get(id);
            if(question != null) {
                int type = question.getType();
                map.put("type",type);
                map.put("result", true);
            }
            else {
                map.put("result", true);
                map.put("type", 7);
            }
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }
}
