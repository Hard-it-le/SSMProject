package com.yjl.mvc.demo;

/**
 * @author yujiale
 */
public class Paige {

    private Integer paigeId;
    private String paigeName;
    private Season season;

    public Paige() {
    }

    public Integer getPaigeId() {
        return paigeId;
    }

    public void setPaigeId(Integer paigeId) {
        this.paigeId = paigeId;
    }

    public String getPaigeName() {
        return paigeName;
    }

    public void setPaigeName(String paigeName) {
        this.paigeName = paigeName;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Paige{" +
                "paigeId=" + paigeId +
                ", paigeName='" + paigeName + '\'' +
                ", season=" + season +
                '}';
    }

    public Paige(Integer paigeId, String paigeName, Season season) {
        this.paigeId = paigeId;
        this.paigeName = paigeName;
        this.season = season;
    }
}
