package com.yjl.mybatis.mapper;

import com.yjl.mybatis.entity.TbEmp;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yujiale
 * @Classname TbEmpMapper
 * @Description TOO
 * @Date 2021/9/24 下午1:56
 * @Created by yujiale
 */
public interface TbEmpMapper {
    List<TbEmp> selectEmployeeByCondition(@Param("tbEmp") TbEmp tbEmp);

    Integer updateEmployeeByCondition(@Param("tbEmp") TbEmp emp);

    TbEmp selectEmpByName(Integer empId);

    List<TbEmp> selectEmployeeByConditionByTrim(@Param("tbEmp") TbEmp emp);

    List<TbEmp> selectEmployeeByConditionByChoose(@Param("tbEmp") TbEmp tbEmp);

    void updateEmployeeBatchByForeach(@Param("empList") ArrayList<TbEmp> empList);



    void updateEmp(@Param("emp") TbEmp emp);
}
