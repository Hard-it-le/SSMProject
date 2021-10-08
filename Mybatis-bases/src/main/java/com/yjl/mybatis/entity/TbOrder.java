package com.yjl.mybatis.entity;

/**
 * @author yujiale
 */
public class TbOrder {

    private long orderId;
    private String orderName;
    private long customerId;

    // 体现对一关系
    private TbCustomer customer;

    public TbOrder() {

    }

    public TbOrder(long orderId, String orderName, long customerId, TbCustomer customer) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.customerId = customerId;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "TOrder{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", customerId=" + customerId +
                ", customer=" + customer +
                '}';
    }

    public TbCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TbCustomer customer) {
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

}
