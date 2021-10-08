package com.yjl.ajax.entity;

/**
 * @author yujiale
 */
public class Subject {

    private String subjectName;
    private Double subjectScore;

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", subjectScore=" + subjectScore +
                '}';
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Double getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(Double subjectScore) {
        this.subjectScore = subjectScore;
    }

    public Subject(String subjectName, Double subjectScore) {
        this.subjectName = subjectName;
        this.subjectScore = subjectScore;
    }

    public Subject() {
    }
}
