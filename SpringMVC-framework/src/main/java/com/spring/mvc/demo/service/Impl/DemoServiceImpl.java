package com.spring.mvc.demo.service.Impl;

import com.spring.mvc.demo.service.DemoService;

/**
 * @program: SSMProject
 * @author: yjl
 * @created: 2021/12/06
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String getName(String name) {

        System.out.println("service 实现类的name参数" + name);
        return name;
    }
}
