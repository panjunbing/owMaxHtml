package com.owmax.controller;

import com.owmax.model.QuestionnaireUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String login(String username, String password,HttpServletRequest request){
        HttpSession session = request.getSession();
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
                    session.setAttribute("user",user);
                    session.setAttribute("questionID",1);
                }
            }
            else {
                map.put("result", false);
                map.put("message", "该用户不存在！");
            }
        }
        catch (Exception e){
            map.put("result", false);
            map.put("message",e.getMessage());
        }
        return gson.toJson(map);
    }


    /**
     * 设置用户为已回答
     * http://localhost:8080/questionnaireUser/setAnswer?userID=1
     * @param userID 用户ID
     * @return json
     */
    @RequestMapping(value = "/setAnswer",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String setAnswer(int userID) {
        Map map = new HashMap<>();
        QuestionnaireUser user = questionnaireUserService.get(userID);
        try {
            if (user != null) {
                user.setIsAnswer(1);
                map.put("result", true);
            } else {
                map.put("result", false);
                map.put("message", "该用户不存在！");
            }

        } catch (Exception e) {
            map.put("result", false);
            map.put("message", e.getMessage());
        }
        return gson.toJson(map);
    }


    /**
     * 从session获取用户
     * http://localhost:8080/questionnaireUser/getUser
     * @return json
     */
    @RequestMapping(value = "/getUser",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map map = new HashMap<>();
        try {
            QuestionnaireUser user = (QuestionnaireUser) session.getAttribute("user");
            if (user != null) {
                map.put("userName", user.getUsername());
                map.put("userID", user.getId());
                map.put("return", true);
            } else {
                map.put("return", false);
                map.put("message", "session中无用户信息");
            }
        } catch (Exception e) {
            map.put("result", false);
            map.put("message", e.getMessage());
        }
        return gson.toJson(map);
    }
}
