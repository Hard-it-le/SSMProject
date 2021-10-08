package com.yjl.ajax.entity;

/**
 * @author yujiale
 */
public class Soldier {

    private Integer soldierId;
    private String soldierName;

    public Soldier() {
    }

    public Integer getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(Integer soldierId) {
        this.soldierId = soldierId;
    }

    public String getSoldierName() {
        return soldierName;
    }

    public void setSoldierName(String soldierName) {
        this.soldierName = soldierName;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "soldierId=" + soldierId +
                ", soldierName='" + soldierName + '\'' +
                '}';
    }

    public Soldier(Integer soldierId, String soldierName) {
        this.soldierId = soldierId;
        this.soldierName = soldierName;
    }
}
