package com.yjl.mvn.entity;

/**
 * @author yujiale
 */
public class Subject {

    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                '}';
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject() {

    }
}
