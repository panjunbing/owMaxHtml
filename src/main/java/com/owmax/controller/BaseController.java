package com.owmax.controller;

import com.google.gson.Gson;
import com.owmax.service.AllService;
import com.owmax.service.DataService;
import com.owmax.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panpan on 2017/4/18    ^_^
 */

@Controller
public class BaseController {

    //后台项目基础url
    protected String mainPath = "manage/";
    //微信项目基础url
    protected String wechatPath = "wechat/";
    //appweb页面基础url
    protected String questionnairePath = "questionnaire/";

    @ModelAttribute("BasePath")
    public String getBasePath(HttpServletRequest httpServletRequest) {
        log.info(httpServletRequest.getServletContext().getContextPath());
        return httpServletRequest.getServletContext().getContextPath();
    }

    protected Gson gson = new Gson();

    protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected UserService userService;

    @Autowired
    protected DataService dataService;

    @Autowired
    protected AllService allService;
}

