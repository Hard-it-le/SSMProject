package com.yjl.mybatis.entity;

import java.util.List;

/**
 * @author yujiale
 * @Classname TbCustomer
 * @Description TOO
 * @Date 2021/9/24 上午8:27
 * @Created by yujiale
 */
public class TbCustomer {
    private Integer customerId;
    private String customerName;
    /**
     * 体现的是对多的关系
     */
    private List<TbOrder> orderList;

    public TbCustomer() {
    }

    public TbCustomer(Integer customerId, String customerName, List<TbOrder> orderList) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderList = orderList;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<TbOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<TbOrder> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "TbCustomer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
