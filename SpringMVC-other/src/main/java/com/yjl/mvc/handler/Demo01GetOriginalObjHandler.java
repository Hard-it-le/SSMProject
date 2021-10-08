package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author yujiale
 */
@Controller
public class Demo01GetOriginalObjHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 获取ServletContext对象的方法二：从 IOC 容器中直接注入
    @Autowired
    private ServletContext servletContext;

//    @RequestMapping("/")
//    public String showPortal() {
//        return "portal";
//    }
    // SpringMVC 中没有默认欢迎页这样的概念，所以想通过index.html访问首页就必须明确声明 URL 地址的映射
//    @RequestMapping("/index.html")
//    public String showIndex() {
//        return "portal";
//    }

    @RequestMapping("/original/api/direct")
    public String getOriginalAPIDirect(

            // 有需要使用的 Servlet API 直接在形参位置声明即可。
            // 需要使用就写上，不用就不写，开发体验很好，这里给 SpringMVC 点赞
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session

            // ServletContext 无法通过形参位置直接传入
            // ServletContext servletContext
    ) {

        logger.debug(request.toString());
        logger.debug(response.toString());
        logger.debug(session.toString());

        return "target";
    }

    @RequestMapping("/original/servlet/context/first/way")
    public String originalServletContextFirstWay(HttpSession session) {

        // 获取ServletContext对象的方法一：通过HttpSession对象获取
        ServletContext servletContext = session.getServletContext();
        logger.debug(servletContext.toString());

        return "target";
    }

    @RequestMapping("/original/servlet/context/second/way")
    public String originalServletContextSecondWay() {

        logger.debug(this.servletContext.toString());

        return "target";
    }
}
