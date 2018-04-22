package com.owmax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panpan on 2017/4/18    ^_^
 */




@Controller
public class OwmaxController extends BaseController{


    //微信主页面
    @RequestMapping(value = "/wechat")
    public String wechatIndex(){ return wechatPath+"index"; }

    /**
     * 微信一级页面转发控制器
     * @param var1
     * @return
     */
    @RequestMapping("/wechat/{var1}")
    public String sendMain(@PathVariable("var1") String var1){
        return wechatPath+var1;
    }

    /**
     * 微信二级级页面转发控制器
     * @param dir
     * @param file
     * @return
     */
    @RequestMapping("/wechat/{dir}/{file}")
    public String sendMainDir(@PathVariable("dir") String dir,@PathVariable("file") String file){
        return wechatPath+dir+"/"+file;
    }



    @ModelAttribute("BasePath")
    public String getBasePath(HttpServletRequest httpServletRequest){
        return httpServletRequest.getServletContext().getContextPath();
    }

}
