package com.spring.mvc.demo.controller;

import com.spring.mvc.demo.service.DemoService;
import com.spring.mvc.framework.annotations.Autowired;
import com.spring.mvc.framework.annotations.RequestMapping;
import com.spring.mvc.framework.annotations.TestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: SSMProject
 * @author: yjl
 * @created: 2021/12/06
 */
@TestController
@RequestMapping("/demo")
public class DemoController {


    @Autowired
    private DemoService demoService;

    /**
     * URL:/demo/query
     * @param request
     * @param response
     * @param name
     * @return
     */
    @RequestMapping("/query")
    public String getName(HttpServletRequest request, HttpServletResponse response, String name) {
        return demoService.getName(name);
    }
}
