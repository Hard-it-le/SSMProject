package com.yjl.annotation;

import com.yjl.annotation.controller.SoldierController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yujiale
 * @Classname JunitIntegrationSpring
 * @Description TOO
 * @Date 2021/9/25 下午10:19
 * @Created by yujiale
 */

/**
 * junit的@RunWith注解：指定Spring为Junit提供的运行器
 * Spring的@ContextConfiguration指定Spring配置文件的位置
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class JunitIntegrationSpring {
    @Autowired
    private SoldierController soldierController;

    @Test
    public void testIntegration() {
        System.out.println("soldierController = " + soldierController);
    }
}
