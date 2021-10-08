package com.yjl.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author yujiale
 */
@TableName("tb_emp")
public class Emp {

    @TableField("emp_id")
    private Long empId;
    @TableField("emp_name")
    private String empName;
    @TableField("emp_salary")
    private Double empSalary;

    public Emp() {
    }

    public Emp(Long emp_id, String emp_name, Double emp_salary) {
        this.empId = emp_id;
        this.empName = emp_name;
        this.empSalary = emp_salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
}
