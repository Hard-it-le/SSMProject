package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author yujiale
 */
@Controller
public class Demo03MappingMethodHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // @RequestMapping(value = "/emp", method = RequestMethod.GET)
    @GetMapping("/emp")
    public String empGet() {

        logger.debug("GET 请求");

        return "target";
    }

    // @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @PostMapping("/emp")
    public String empPost() {

        logger.debug("POST 请求");

        return "target";
    }

}
