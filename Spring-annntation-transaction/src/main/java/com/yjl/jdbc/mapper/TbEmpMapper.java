package com.yjl.jdbc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author yujiale
 * @Classname TbEmpMapper
 * @Description TOO
 * @Date 2021/9/28 下午9:17
 * @Created by yujiale
 */
@Repository
public class TbEmpMapper {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateEmpNameById(Integer empId, String empName) {
        String sql = "update tb_emp set emp_name=? where emp_id=?";
        jdbcTemplate.update(sql, empName, empId);
    }

    public void updateEmpSalaryById(Integer empId, Double salary) {
        String sql = "update tb_emp set emp_salary=? where emp_id=?";
        jdbcTemplate.update(sql, salary, empId);
    }

    public String selectEmpNameById(Integer empId) {
        String sql = "select emp_name from tb_emp where emp_id=?";
        String empName = jdbcTemplate.queryForObject(sql, String.class, empId);
        return empName;
    }

}
