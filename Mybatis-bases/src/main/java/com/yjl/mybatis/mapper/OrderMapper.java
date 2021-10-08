package com.yjl.mybatis.mapper;

import com.yjl.mybatis.entity.TbOrder;

/**
 * @author yujiale
 */
public interface OrderMapper {

    /**
     * s
     * @param orderId
     * @return
     */
    TbOrder selectOrderWithCustomer(Integer orderId);

}
