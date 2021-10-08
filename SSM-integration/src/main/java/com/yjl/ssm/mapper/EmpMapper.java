package com.yjl.ssm.mapper;

import com.yjl.ssm.entity.Emp;

import java.util.List;

/**
 * @author yujiale
 * @Classname EmpMapper
 * @Description TOO
 * @Date 2021/10/6 上午11:05
 * @Created by yujiale
 */
public interface EmpMapper {
    List<Emp> selectAll();

    void deleteByPrimaryKey(Integer empId);

    void insertEmp(Emp emp);

   Emp selectByPrimaryKey(Integer empId);

    void updateEmpByPrimaryKey(Emp emp);
}
