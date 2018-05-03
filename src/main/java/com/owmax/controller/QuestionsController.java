package com.owmax.controller;

import com.owmax.model.Blanks;
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
public class QuestionsController extends BaseController{

    /**
     * 获取问题
     * http://localhost:8080/questions/getQuestion?id=1
     * @param id  题号
     * @return json
     */
    @RequestMapping(value = "/getQuestion",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getQuestion(int id){
        Map<Object, Object> map = new HashMap<>();
        try {
            Questions question = questionsService.get(id);
            if(question != null) {
                map.put("title",question.getTitle());
                int type = question.getType();
                map.put("type",type);
                //根据题目类型进行判断
                //选择题
                if(type >= 0 && type <= 2 || type == 5){
                    List<Selections> selectionsList = (List<Selections>) question.getSelectionses();
                    int size = selectionsList.size();
                    Map rows[] = new Map[size];
                    for(int i = 0 ;i<size;i++) {
                        Selections selection = selectionsList.get(i);
                        rows[i] = new HashMap<>();
                        rows[i].put("selection", selection.getSelection());
                        if (type == 2)
                            rows[i].put("selectionText", selection.getSelectionText());
                    }
                    map.put("selections",rows);
                }
                else {
                    List<Blanks> blanksList = (List<Blanks>) question.getBlankses();
                    int size = blanksList.size();
                    Map rows[] = new Map[size];
                    for(int i = 0 ;i<size;i++) {
                        Blanks blank = blanksList.get(i);
                        rows[i] = new HashMap<>();
                        rows[i].put("blank", blank.getBlankText());
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
            map.put("result",e.getMessage());
        }
        return gson.toJson(map);
    }
}
