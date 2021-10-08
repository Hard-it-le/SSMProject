package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author yujiale
 */
@Controller
public class Demo02AttrHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/attr/request/model")
    public String testAttrRequestModel(

            // 在形参位置声明Model类型变量，用于存储模型数据
            Model model) {

        // 我们将数据存入模型，SpringMVC 会帮我们把模型数据存入请求域
        // 存入请求域这个动作也被称为暴露到请求域
        model.addAttribute("requestScopeMessageModel","i am very happy[model]");

        logger.debug(model.getClass().getName());

        return "target";
    }

    @RequestMapping("/attr/request/model/map")
    public String testAttrRequestModelMap(

            // 在形参位置声明ModelMap类型变量，用于存储模型数据
            ModelMap modelMap) {

        // 我们将数据存入模型，SpringMVC 会帮我们把模型数据存入请求域
        // 存入请求域这个动作也被称为暴露到请求域
        modelMap.addAttribute("requestScopeMessageModelMap","i am very happy[model map]");

        logger.debug(modelMap.getClass().getName());

        return "target";
    }

    @RequestMapping("/attr/request/map")
    public String testAttrRequestMap(

            // 在形参位置声明Map类型变量，用于存储模型数据
            Map<String, Object> map) {

        // 我们将数据存入模型，SpringMVC 会帮我们把模型数据存入请求域
        // 存入请求域这个动作也被称为暴露到请求域
        map.put("requestScopeMessageMap", "i am very happy[map]");

        logger.debug(map.getClass().getName());

        return "target";
    }

    @RequestMapping("/attr/request/original")
    public String testAttrOriginalRequest(

            // 拿到原生对象，就可以调用原生方法执行各种操作
            HttpServletRequest request) {

        request.setAttribute("requestScopeMessageOriginal", "i am very happy[original]");

        return "target";
    }

    @RequestMapping("/attr/request/mav")
    public ModelAndView testAttrByModelAndView() {

        // 1.创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();

        // 2.存入模型数据
        modelAndView.addObject("requestScopeMessageMAV", "i am very happy[mav]");

        // 3.设置视图名称
        modelAndView.setViewName("target");

        return modelAndView;
    }

    @RequestMapping("/attr/session")
    public String attrSession(
            // 使用会话域最简单直接的办法就是使用原生的 HttpSession 对象
            HttpSession session) {

        session.setAttribute("sessionScopeMessage", "i am haha ...");

        return "target";
    }

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/attr/application")
    public String attrApplication() {

        servletContext.setAttribute("appScopeMsg", "i am hungry...");

        return "target";
    }
}
