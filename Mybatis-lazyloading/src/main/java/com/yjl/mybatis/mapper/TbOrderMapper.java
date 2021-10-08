package com.yjl.mybatis.mapper;

import com.yjl.mybatis.entity.TbOrder;

/**
 * @author yujiale
 * @Classname TbOrderMapper
 * @Description TOO
 * @Date 2021/9/24 上午8:28
 * @Created by yujiale
 */
public interface TbOrderMapper {


    /**
     * 根据订单id查询信息
     * @param orderId
     * @return
     */
    TbOrder selectOrderAndCustomerTwoStep(Integer orderId);
}
