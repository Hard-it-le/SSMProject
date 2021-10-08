package com.yjl.mybatis.mapper;

import com.yjl.mybatis.entity.TbOrder;

import java.util.List;

/**
 * @author yujiale
 * @Classname TbOrderMapper
 * @Description TOO
 * @Date 2021/9/24 上午8:28
 * @Created by yujiale
 */
public interface TbOrderMapper {


    /**
     * 查询
     * @param orderId
     * @return
     */
    TbOrder selectOrderAndCustomer(Long orderId);

    List<TbOrder> selectOrderAll();
}
