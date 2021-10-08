package com.atguigu.jdbc.test;

import com.yjl.tx.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-context.xml"})
public class JDBCTest {

    @Autowired
    private EmpService empService;
    @Test
    public void testBaseTransaction() throws Exception {

        Integer empId4EditName = 2;
        String newName = "new-name";

        Integer empId4EditSalary = 3;
        Double newSalary = 444.44;

        empService.updateTwice(empId4EditName, newName, empId4EditSalary, newSalary);

    }

}
