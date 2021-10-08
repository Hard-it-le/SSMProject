package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yujiale
 */
@Controller
@RequestMapping("/user")
public class Demo02MappingHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String userLogin() {

        logger.debug("user login ☆☆☆");

        return "target";
    }

    @RequestMapping("/register")
    public String userRegister() {

        logger.debug("user register ☆☆☆");

        return "target";
    }

    @RequestMapping("/logout")
    public String userLogout() {

        logger.debug("user logout ☆☆☆");

        return "target";
    }

}
