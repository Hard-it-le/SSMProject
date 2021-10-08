package com.yjl.annotation.controller;

import com.yjl.annotation.service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author yujiale
 * @Classname SoldierController
 * @Description TOO
 * @Date 2021/9/25 下午9:01
 * @Created by yujiale
 */
@Controller
public class SoldierController {

    @Autowired
    private SoldierService soldierService;


    public void test(){
        soldierService.getTest();
    }
}
