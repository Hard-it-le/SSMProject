package com.yjl.mybatis;

import com.yjl.mybatis.entity.TbEmp;
import com.yjl.mybatis.mapper.TbEmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yujiale
 * @Classname MybatisTestDynamicSQL
 * @Description TOO
 * @Date 2021/9/24 上午10:42
 * @Created by yujiale
 */
public class MybatisTestDynamicSQL {


    private SqlSession session;

    @Test
    public void testCommonUpdate() {
        TbEmpMapper employeeMapper = session.getMapper(TbEmpMapper.class);
        for (Integer i = 7; i <= 16; i++) {
            TbEmp emp = new TbEmp(i, "smallTiger" + i, i * 100.00);
            employeeMapper.updateEmp(emp);
        }
    }

    @Test
    public void updateEmployeeBatchByForeachTest() {
        TbEmpMapper empMapper = session.getMapper(TbEmpMapper.class);
        ArrayList<TbEmp> empList = new ArrayList<>();
        for (Integer i = 7; i <= 16; i++) {
            TbEmp emp = new TbEmp(i, "bigTiger" + i, i * 100.00);
            empList.add(emp);
        }
        empMapper.updateEmployeeBatchByForeach(empList);

    }

    @Test
    public void selectEmployeeByConditionByChooseTest() {
        TbEmpMapper empMapper = session.getMapper(TbEmpMapper.class);
        TbEmp tbEmp = new TbEmp();
        List<TbEmp> empList = empMapper.selectEmployeeByConditionByChoose(tbEmp);
        for (TbEmp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test
    public void selectEmployeeByConditionByTrimTest() {
        TbEmpMapper empMapper = session.getMapper(TbEmpMapper.class);
        TbEmp tbEmp = new TbEmp();
        /**
         * 第一种情况
         */
        // tbEmp.setEmpName("harry");
        // tbEmp.setEmpSalary(2500.00);
        /**
         * 第二种情况
         */
        // tbEmp.setEmpName("harry");
        // tbEmp.setEmpSalary(null);
        /**
         * 第三种情况
         */
        // tbEmp.setEmpName(null);
        // tbEmp.setEmpSalary(1000.00);
        /**
         * 第四种情况
         */
        tbEmp.setEmpName(null);
        tbEmp.setEmpSalary(null);
        List<TbEmp> empList = empMapper.selectEmployeeByConditionByTrim(tbEmp);
        for (TbEmp emp : empList) {
            System.out.println(emp);
        }
    }


    @Test
    public void updateEmployeeByConditionTest() {
        TbEmpMapper empMapper = session.getMapper(TbEmpMapper.class);
        TbEmp emp = new TbEmp();
        emp.setEmpId(1);
        emp = empMapper.selectEmpByName(emp.getEmpId());
        // emp.setEmpName("wangZhe");
        //emp.setEmpSalary(10000.00);
        emp.setEmpName("feiWu");
        emp.setEmpSalary(null);
        Integer integer = empMapper.updateEmployeeByCondition(emp);
        System.out.println(integer);

    }

    @Test
    public void selectEmployeeByConditionTest() {
        TbEmpMapper empMapper = session.getMapper(TbEmpMapper.class);
        TbEmp tbEmp = new TbEmp();
        // tbEmp.setEmpName("harry");
        // tbEmp.setEmpSalary(2000.00);
        tbEmp.setEmpName(null);
        tbEmp.setEmpSalary(2000.00);
        List<TbEmp> empList = empMapper.selectEmployeeByCondition(tbEmp);
        for (TbEmp emp : empList) {
            System.out.println(emp);
        }
    }


    @Before
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @After
    public void clear() {
        session.commit();
        session.close();
    }

}
