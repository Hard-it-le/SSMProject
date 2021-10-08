package com.yjl.xml;

import com.yjl.xml.service.CalculationPureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-context.xml"})
public class AOPTest {

    @Autowired
    private CalculationPureService calculationPureService;

    @Test
    public void testLogAspect() {
        int add = calculationPureService.add(10, 2);
        System.out.println("add = " + add);
    }
}
