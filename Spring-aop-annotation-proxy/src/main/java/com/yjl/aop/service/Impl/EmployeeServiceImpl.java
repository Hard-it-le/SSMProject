package com.yjl.aop.service.Impl;

import org.springframework.stereotype.Service;

/**
 * @author yujiale
 * @Classname EmployeeService
 * @Description TOO
 * @Date 2021/9/28 下午8:02
 * @Created by yujiale
 */
@Service
public class EmployeeServiceImpl {
    public void getEmpList() {
        System.out.println("方法内部 com.atguigu.aop.imp.EmployeeService.getEmpList");
    }
}
