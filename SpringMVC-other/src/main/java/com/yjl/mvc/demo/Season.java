package com.yjl.mvc.demo;

import java.util.Objects;

/**
 * @author yujiale
 */
public class Season {

    // 提交给服务器的值
    private String submitValue;

    // 给用户看的值
    private String showForUserValue;

    public String getSubmitValue() {
        return submitValue;
    }

    public void setSubmitValue(String submitValue) {
        this.submitValue = submitValue;
    }

    public String getShowForUserValue() {
        return showForUserValue;
    }

    public void setShowForUserValue(String showForUserValue) {
        this.showForUserValue = showForUserValue;
    }

    @Override
    public String toString() {
        return "Season{" +
                "submitValue='" + submitValue + '\'' +
                ", showForUserValue='" + showForUserValue + '\'' +
                '}';
    }

    public Season(String submitValue, String showForUserValue) {
        this.submitValue = submitValue;
        this.showForUserValue = showForUserValue;
    }

    public Season() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return Objects.equals(submitValue, season.submitValue) &&
                Objects.equals(showForUserValue, season.showForUserValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submitValue, showForUserValue);
    }
}
