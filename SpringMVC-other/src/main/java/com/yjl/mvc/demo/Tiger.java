package com.yjl.mvc.demo;

/**
 * @author yujiale
 */
public class Tiger {

    private Integer tigerId;
    private String tigerName;
    private Double tigerSalary;

    public Integer getTigerId() {
        return tigerId;
    }

    public void setTigerId(Integer tigerId) {
        this.tigerId = tigerId;
    }

    public String getTigerName() {
        return tigerName;
    }

    public void setTigerName(String tigerName) {
        this.tigerName = tigerName;
    }

    public Double getTigerSalary() {
        return tigerSalary;
    }

    public void setTigerSalary(Double tigerSalary) {
        this.tigerSalary = tigerSalary;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "tigerId=" + tigerId +
                ", tigerName='" + tigerName + '\'' +
                ", tigerSalary=" + tigerSalary +
                '}';
    }

    public Tiger(Integer tigerId, String tigerName, Double tigerSalary) {
        this.tigerId = tigerId;
        this.tigerName = tigerName;
        this.tigerSalary = tigerSalary;
    }

    public Tiger() {
    }
}
