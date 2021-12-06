package com.spring.mvc.demo.controller;

import com.spring.mvc.demo.service.DemoService;
import com.spring.mvc.framework.annotations.Autowired;
import com.spring.mvc.framework.annotations.TestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: SSMProject
 * @author: yjl
 * @created: 2021/12/06
 */
@TestController
public class DemoController {


    @Autowired
    private DemoService demoService;

    public String getName(HttpServletRequest request, HttpServletResponse response, String name) {
        return demoService.getName(name);
    }
}
