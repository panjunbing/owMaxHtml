package com.owmax.controller;

import com.owmax.model.Data;
import com.owmax.model.User;
import com.owmax.scrapy.scrapy;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panpan on 2017/4/18    ^_^
 */

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    /**
     * 插入新用户或者把用户state改为0，并删除data数据
     * http://localhost:8080/user/insertUser?userName=隔壁小王-52430
     * @param userName  用户名
     * @return json
     */
    @RequestMapping(value = "/insertUser",
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String insertUser(String userName){
        Map map = new HashMap<>();
        try {
            User user = new User();
            user.setUserName(userName);
            user.setState(0);
            user = userService.scrapyUser(user);
            scrapy.scrapy();
            userService.setState1(userName);
            map.put("userID",user.getId());
            map.put("result",true);
        }
        catch (Exception e){
            map.put("result",e.getMessage());
        }
        return gson.toJson(map);
    }
}
