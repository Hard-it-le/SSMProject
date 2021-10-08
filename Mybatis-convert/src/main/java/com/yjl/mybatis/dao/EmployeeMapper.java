package com.yjl.mybatis.dao;

import com.yjl.mybatis.entity.Emp;

public interface EmployeeMapper {
    Emp selectById(int empId);
}
