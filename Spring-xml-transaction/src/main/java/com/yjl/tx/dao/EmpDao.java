package com.yjl.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateEmpNameById(Integer empId, String empName) {
        String sql = "update t_emp set emp_name=? where emp_id=?";
        jdbcTemplate.update(sql, empName, empId);
    }

    public void updateEmpSalaryById(Integer empId, Double salary) {

        // 为了看到操作失败后的效果人为将 SQL 语句破坏
        String sql = "update t_emp set emp_salary=? where emp_id=?";
        jdbcTemplate.update(sql, salary, empId);

//        抛出编译时异常测试是否回滚
//        new FileInputStream("aaaa.aaa");
//        Class.forName("aaa..aaa.wwe");

//        抛出运行时异常测试是否回滚
        System.out.println(10 / 0);

//        测试超时属性使用
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public String selectEmpNameById(Integer empId) {
        String sql = "select emp_name from t_emp where emp_id=?";

        String empName = jdbcTemplate.queryForObject(sql, String.class, empId);

        return empName;
    }

}
