package com.yjl.mybatis.entity;


import java.util.List;

/**
 * @author yujiale
 */
public class TbCustomer {

    private long customerId;
    private String customerName;

    // 体现对多关系
    private List<TbOrder> orderList;

    public TbCustomer() {
    }

    public TbCustomer(long customerId, String customerName, List<TbOrder> orderList) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "TCustomer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", orderList=" + orderList +
                '}';
    }

    public List<TbOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<TbOrder> orderList) {
        this.orderList = orderList;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
