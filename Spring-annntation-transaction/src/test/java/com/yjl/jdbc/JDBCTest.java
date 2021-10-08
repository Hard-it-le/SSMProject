package com.yjl.jdbc;

import com.yjl.jdbc.mapper.TbEmpMapper;
import com.yjl.jdbc.service.TbEmpService;
import com.yjl.jdbc.service.TopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yujiale
 * @Classname JDBCTest
 * @Description TOO
 * @Date 2021/9/28 下午9:14
 * @Created by yujiale
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-context.xml"})
public class JDBCTest {


    @Autowired
    private TbEmpMapper tbEmpMapper;

    @Autowired
    private TbEmpService tbEmpService;

    @Test
    public void testUpdateEmpName() {
        Integer empId = 2;
        String empName = "new-name";
        tbEmpMapper.updateEmpNameById(empId, empName);
    }

    @Test
    public void testUpdateSalary() throws Exception {
        Integer empId = 2;
        Double salary = 777.77;
        tbEmpMapper.updateEmpSalaryById(empId, salary);
    }

    @Test
    public void testSelectName() {
        Integer empId = 2;
        String empName = tbEmpMapper.selectEmpNameById(empId);
        System.out.println("empName = " + empName);
    }

    @Test
    public void testBaseTransaction() throws Exception {
        Integer empId4EditName = 2;
        String newName = "new-name";
        Integer empId4EditSalary = 3;
        Double newSalary = 444.44;
        tbEmpService.updateTwice(empId4EditName, newName, empId4EditSalary, newSalary);

    }

    @Test
    public void testTxReadOnly() {
        String empName = tbEmpService.getEmpName(2);
        System.out.println("empName = " + empName);
    }

    @Test
    public void testIsolation() {
        Integer empId = 2;
        String empName = "aaaaaaaa";
        tbEmpService.updateEmpName(empId, empName);

    }

    @Autowired
    private TopService topService;

    @Test
    public void testPropagation() {
        // 调用外层方法
        topService.topTxMethod();

    }

}
