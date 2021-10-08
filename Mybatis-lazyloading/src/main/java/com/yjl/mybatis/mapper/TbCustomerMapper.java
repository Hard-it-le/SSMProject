package com.yjl.mybatis.mapper;

import com.yjl.mybatis.entity.TbCustomer;

/**
 * @author yujiale
 * @Classname TbCustomerMapper
 * @Description TOO
 * @Date 2021/9/24 上午8:28
 * @Created by yujiale
 */
public interface TbCustomerMapper {


    /**
     * 测试
     * @param customerId
     * @return
     */
    TbCustomer selectCustomerAndOrderTwoStep(Integer customerId);
}
