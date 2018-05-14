package com.owmax.controller;

import com.owmax.model.Jump;
import com.owmax.model.QuestionnaireUser;
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
@RequestMapping("/jump")
public class JumpController extends BaseController{

    /**
     * 获取选项跳转的问题号
     * http://localhost:8080/jump/getJump?selection=56
     * @param selectionID  选项ID
     * @return json
     */
    @RequestMapping(value = "/getJump",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJump(HttpServletRequest request,int selectionID){
        HttpSession session = request.getSession();
        Map<Object, Object> map = new HashMap<>();
        try {
            Selections selections = selectionsService.get(selectionID);
            if(selections != null) {
                map.put("result", true);
                List<Jump> jumpList = new ArrayList<>(selections.getJumps());
                if(jumpList.size() > 0){
                    map.put("questionID", jumpList.get(0).getQuestions().getId());
                }
                else {
                    QuestionnaireUser user = (QuestionnaireUser) session.getAttribute("user");
                    map.put("questionID",user.getId()+1);
                }
            }
            else {
                map.put("result", false);
                map.put("message", "选项ID不存在！");
            }
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }


    /**
     * test
     * http://localhost:8080/jump/test?selectionsID=test
     * @param selectionsID  选项
     * @return json
     */
    @RequestMapping(value = "/test",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int getJump(int selectionsID[],HttpServletRequest request){
        HttpSession session = request.getSession();
        int s = selectionsID[0];
        return s;
    }
}
