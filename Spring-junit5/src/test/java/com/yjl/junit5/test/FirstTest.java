package com.yjl.junit5.test;

import com.yjl.junit5.mapper.EmpDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class FirstTest {

    @Autowired
    private EmpDao empDao;

    @Test
    public void testIntegration() {
        System.out.println("empDao = " + empDao);
    }

}
