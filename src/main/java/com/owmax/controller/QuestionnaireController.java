package com.owmax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panpan on 2018/4/20    ^_^
 */




@Controller
public class QuestionnaireController extends BaseController{


    //调查问卷主页面
    @RequestMapping(value = "/questionnaire")
    public String wechatIndex(){ return questionnairePath+"login"; }

    /**
     * 调查问卷一级页面转发控制器
     * @param var1
     * @return
     */
    @RequestMapping("/questionnaire/{var1}")
    public String sendMain(@PathVariable("var1") String var1){
        return questionnairePath+var1;
    }

    /**
     * 调查问卷二级级页面转发控制器
     * @param dir
     * @param file
     * @return
     */
    @RequestMapping("/questionnaire/{dir}/{file}")
    public String sendMainDir(@PathVariable("dir") String dir,@PathVariable("file") String file){
        return questionnairePath+dir+"/"+file;
    }



    @ModelAttribute("BasePath")
    public String getBasePath(HttpServletRequest httpServletRequest){
        return httpServletRequest.getServletContext().getContextPath();
    }

}
