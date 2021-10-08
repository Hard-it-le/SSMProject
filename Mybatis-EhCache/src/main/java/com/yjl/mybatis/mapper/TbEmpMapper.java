package com.yjl.mybatis.mapper;

import com.yjl.mybatis.entity.TbEmp;

/**
 * @author yujiale
 * @Classname TbEmpMapper
 * @Description TOO
 * @Date 2021/9/24 下午1:56
 * @Created by yujiale
 */
public interface TbEmpMapper {

    TbEmp selectEmpById(Integer empId);
}
