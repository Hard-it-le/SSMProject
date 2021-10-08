package com.yjl.mvn.entity;

/**
 * @author yujiale
 */
public class School {

    private String schoolName;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                '}';
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public School() {

    }
}
