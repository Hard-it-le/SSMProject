package com.yjl.mybatis.entity;

/**
 * @author yujiale
 * @Classname Order
 * @Description TOO
 * @Date 2021/9/24 上午8:27
 * @Created by yujiale
 */
public class TbOrder {

    private Integer orderId;

    private String orderName;

    private Integer customerId;
    /**
     * 体现的是对一的关系
     */
    private TbCustomer customer;

    public TbOrder() {
    }

    public TbOrder(Integer orderId, String orderName, Integer customerId, TbCustomer customer) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.customerId = customerId;
        this.customer = customer;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public TbCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TbCustomer customer) {
        this.customer = customer;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "TbOrder{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", customerId=" + customerId +
                ", customer=" + customer +
                '}';
    }
}
