package com.owmax.controller;

import com.owmax.model.Jump;
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
@RequestMapping("/jump")
public class JumpController extends BaseController{

    /**
     * 获取选项跳转的问题号
     * http://localhost:8080/jump/getJump?selectionID=56
     * @param selectionID  选项ID
     * @return json
     */
    @RequestMapping(value = "/getJump",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJump(int selectionID){
        Map<Object, Object> map = new HashMap<>();
        try {
            List list = jumpService.queryALL();
            Selections selections = selectionsService.get(selectionID);
//            List<Jump> jumpList = selections.get(selectionID).getJumps();
//            int questionID = jumpList.get(0).getId();
            int questionID = 0;
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
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }
}
