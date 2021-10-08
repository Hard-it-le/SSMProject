package com.yjl.mybatis.test;


import com.yjl.mybatis.dao.EmployeeMapper;
import com.yjl.mybatis.entity.Address;
import com.yjl.mybatis.entity.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MybatisTest {

    private SqlSession session;

    @Test
    public void testQueryAddress() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Emp emp = employeeMapper.selectById(1);

        Address empAddress = emp.getEmpAddress();

        System.out.println("empAddress = " + empAddress);
    }

    @Before
    public void init() throws IOException {
        session =
                new SqlSessionFactoryBuilder()
                        .build(Resources.getResourceAsStream("mybatis-config.xml"))
                        .openSession();
    }

    @After
    public void clear() {
        session.commit();
        session.close();
    }

}