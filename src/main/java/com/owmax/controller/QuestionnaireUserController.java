package com.owmax.controller;

import com.owmax.model.QuestionnaireUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by panpan on 2017/4/18    ^_^
 */

@Controller
@RequestMapping("/questionnaireUser")
public class QuestionnaireUserController extends BaseController{

    /**
     * 登录
     * http://localhost:8080/questionnaireUser/login?username=userName&password=password
     * @param username  用户名
     * @param password  密码
     * @return json
     */
    @RequestMapping(value = "/login",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(String username, String password){
        Map map = new HashMap<>();
        try {
            QuestionnaireUser user = questionnaireUserService.queryQuestionnaireUserByUserName(username);
            if(user != null) {
                if(!user.getPassword().equals(password)) {
                    map.put("result", false);
                    map.put("message", "密码错误！");
                }
                else if (user.getIsAnswer().equals(1)) {
                    map.put("result", false);
                    map.put("message", "您已填写过问卷！");
                }
                else {
                    map.put("userID", user.getId());
                    map.put("result", true);
                }
            }
            else {
                map.put("result", false);
                map.put("message", "该用户不存在！");
            }
        }
        catch (Exception e){
            map.put("result",e.getMessage());
        }
        return gson.toJson(map);
    }
}
