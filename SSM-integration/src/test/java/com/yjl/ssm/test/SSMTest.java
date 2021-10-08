package com.yjl.ssm.test;

import com.yjl.ssm.entity.Emp;
import com.yjl.ssm.mapper.EmpMapper;
import com.yjl.ssm.service.EmpService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yujiale
 * @Classname SSMTest
 * @Description TOO
 * @Date 2021/10/6 上午11:02
 * @Created by yujiale
 */
@SpringJUnitConfig(locations = {"classpath:spring-persist.xml"})
public class SSMTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpService empService;

    Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void testTx() {
        List<Emp> empList = empService.getAll();
        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void testConn() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.debug(connection.toString());
    }


    @Test
    public void testMybatis() {
        List<Emp> empList = empMapper.selectAll();

        for (Emp emp : empList) {
            logger.debug(emp.toString());
        }
    }
}
