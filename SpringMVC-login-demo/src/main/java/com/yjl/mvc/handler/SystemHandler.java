package com.yjl.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemHandler {

    @RequestMapping("/feature/system/message")
    public String toSystemMessagePage(){

        return "system-message";
    }

}
