package com.yjl.ajax.entity;

/**
 * @author yujiale
 */
public class Teacher {

    private String teacherName;
    private String teacherAge;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(String teacherAge) {
        this.teacherAge = teacherAge;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", teacherAge='" + teacherAge + '\'' +
                '}';
    }

    public Teacher(String teacherName, String teacherAge) {
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
    }

    public Teacher() {
    }
}
