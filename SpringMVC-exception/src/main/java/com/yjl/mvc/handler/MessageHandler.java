package com.yjl.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageHandler {

    @RequestMapping("/throw/arithmetic/exception")
    public String throwArithmeticException() {

        System.out.println(10 / 0);

        return "target";
    }
    
    @RequestMapping("/throw/null-pointer/exception")
    public String throwNullPointerException() {
        
        String message = null;

        System.out.println("message.length() = " + message.length());
        
        return "target";
    }

    @RequestMapping("/throw/out/of/index/exception/common")
    public String throwOutOfIndex(){

        int[] array = new int[10];
        System.out.println(array[15]);

        return "target";
    }

    @ResponseBody
    @RequestMapping("/throw/out/of/index/exception/ajax")
    public String throwOutOfIndexAjax() {

        int[] array = new int[10];
        System.out.println(array[15]);

        return "message from server";
    }

}
