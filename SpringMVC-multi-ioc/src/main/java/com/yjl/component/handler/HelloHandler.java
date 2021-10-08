package com.yjl.component.handler;

import com.yjl.component.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
public class HelloHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HelloService helloService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/hello/world")
    public String helloWorld(Model model) {

        String message = helloService.getMessage();
        model.addAttribute("message", message);

        Object springMVCIOC = servletContext.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcherServlet");
        logger.debug(springMVCIOC.toString());

        Object springIOC = servletContext.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
        logger.debug(springIOC.toString());

        return "target";
    }

}
