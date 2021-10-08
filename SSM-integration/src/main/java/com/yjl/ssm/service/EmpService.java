package com.yjl.ssm.service;

import com.github.pagehelper.PageInfo;
import com.yjl.ssm.entity.Emp;

import java.util.List;

/**
 * @author yujiale
 * @Classname EmpService
 * @Description TOO
 * @Date 2021/10/6 上午11:35
 * @Created by yujiale
 */
public interface EmpService {
    List<Emp> getAll();

    PageInfo<Emp> getPageInfo(Integer pageNo);

    void removeEmpById(Integer empId);

    void saveEmp(Emp emp);

    Emp getEmpById(Integer empId);

    void updateEmp(Emp emp);
}
