package com.yjl.mvn.entity;

/**
 * @author yujiale
 */
public class Teacher {

    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                '}';
    }

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public Teacher() {
    }
}
