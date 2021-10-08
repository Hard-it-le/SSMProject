package com.yjl.junit5.test;


import com.yjl.junit5.mapper.EmpDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = {"classpath:spring-context.xml"})
public class SecondTest {

    @Autowired
    private EmpDao empDao;

    @Test
    public void testIntegration() {
        System.out.println("empDao = " + empDao);
    }

}
