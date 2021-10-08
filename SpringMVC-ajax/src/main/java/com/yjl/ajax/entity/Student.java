package com.yjl.ajax.entity;

import java.util.*;

/**
 * @author yujiale
 */
public class Student {

    private Integer stuId;
    private String stuName;
    private List<Subject> subjectList;
    private Map<String, Teacher> teacherMap;
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", subjectList=" + subjectList +
                ", teacherMap=" + teacherMap +
                ", school=" + school +
                '}';
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Student(Integer stuId, String stuName, List<Subject> subjectList, Map<String, Teacher> teacherMap, School school) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.subjectList = subjectList;
        this.teacherMap = teacherMap;
        this.school = school;
    }

    public Student() {
    }
}
