package com.yjl.jdbc.service;

import com.yjl.jdbc.mapper.TbEmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

/**
 * @author yujiale
 * @Classname TbEmpService
 * @Description TOO
 * @Date 2021/9/28 下午9:18
 * @Created by yujiale
 */
@Service
@Transactional(readOnly = true)
public class TbEmpService {
    @Autowired
    private TbEmpMapper empMapper;

    // 为了便于核对数据库操作结果，不要修改同一条记录
    // timeout属性：设置规定的超时时间，以秒为单位
    // rollbackFor属性：指定要回滚的异常
    // noRollbackFor属性：指定不回滚的异常
    @Transactional(
            readOnly = false,
            timeout = 3,
            noRollbackFor = FileNotFoundException.class,
            rollbackFor = Exception.class
    )
    public void updateTwice(
            // 修改员工姓名的一组参数
            Integer empId4EditName, String newName,

            // 修改员工工资的一组参数
            Integer empId4EditSalary, Double newSalary
    ) throws Exception {

        // 为了测试事务是否生效，执行两个数据库操作，看它们是否会在某一个失败时一起回滚
        empMapper.updateEmpNameById(empId4EditName, newName);

        empMapper.updateEmpSalaryById(empId4EditSalary, newSalary);

    }

    // readOnly = true把当前事务设置为只读
    // @Transactional(readOnly = true)
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public String getEmpName(Integer empId) {

        return empMapper.selectEmpNameById(empId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false)
    public void updateEmpName(Integer empId, String empName) {

        empMapper.updateEmpNameById(empId, empName);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void updateEmpNameInner(Integer empId, String empName) {

        empMapper.updateEmpNameById(empId, empName);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void updateEmpSalaryInner(Integer empId, Double empSalary) {

        empMapper.updateEmpSalaryById(empId, empSalary);
    }
}
