package com.yjl.test;

import com.yjl.jdbc.ts.entity.TbEmp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yujiale
 * @Classname tsTest
 * @Description TOO
 * @Date 2021/9/28 下午8:34
 * @Created by yujiale
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-context.xml"})
public class tsTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbcTemplateQueryForEntity() {
        // 1.编写 SQL 语句
        String sql = "select emp_id,emp_name,emp_salary from tb_emp where emp_id=?";
        // 2.准备 RowMapper 对象
        RowMapper<TbEmp> rowMapper = new BeanPropertyRowMapper<>(TbEmp.class);
        // 3.调用 jdbcTemplate 的方法执行查询
        TbEmp emp = jdbcTemplate.queryForObject(sql, rowMapper, 5);
        System.out.println("emp = " + emp);
    }

    @Test
    public void testJdbcTemplateQueryForSingleValue() {
        // 1.编写 SQL 语句
        String sql = "select emp_name from tb_emp where emp_id=?";
        // 2.调用 jdbcTemplate 的方法执行查询
        String empName = jdbcTemplate.queryForObject(sql, String.class, 3);
        System.out.println("empName = " + empName);
    }

    @Test
    public void testJdbcTemplateUpdate() {
        String sql = "update tb_emp set emp_salary=? where emp_id=?";
        // 2.调用 jdbcTemplate 的 update() 方法执行 update 语句
        int count = jdbcTemplate.update(sql, 999.99, 3);
        System.out.println("count = " + count);
    }

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();

        System.out.println("connection = " + connection);
    }
}
