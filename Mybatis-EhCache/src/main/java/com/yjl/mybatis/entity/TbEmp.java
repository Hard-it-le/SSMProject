package com.yjl.mybatis.entity;

import java.io.Serializable;

/**
 * @author yujiale
 * @Classname TbEmp
 * @Description TOO
 * @Date 2021/9/24 下午1:45
 * @Created by yujiale
 */
public class TbEmp implements Serializable {
    private Integer empId;

    private String empName;

    private Double empSalary;

    public TbEmp() {
    }

    public TbEmp(Integer empId, String empName, Double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
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

    @Override
    public String toString() {
        return "TbEmp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}
