package com.yjl.ioc.component;

import java.util.List;
import java.util.Map;

/**
 * @author yujiale
 * @Classname TestTeam
 * @Description TOO
 * @Date 2021/9/25 下午5:44
 * @Created by yujiale
 */
public class TestTeam {
    private String teamName;
    private Integer memberCount;
    private Double memberSalary;
    private List<String> memberList;

    private Map<String,String> managerList;

    public TestTeam() {
    }

    public TestTeam(String teamName, Integer memberCount, Double memberSalary, List<String> memberList, Map<String,
            String> managerList) {
        this.teamName = teamName;
        this.memberCount = memberCount;
        this.memberSalary = memberSalary;
        this.memberList = memberList;
        this.managerList = managerList;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public Double getMemberSalary() {
        return memberSalary;
    }

    public void setMemberSalary(Double memberSalary) {
        this.memberSalary = memberSalary;
    }

    public List<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String> memberList) {
        this.memberList = memberList;
    }

    public Map<String, String> getManagerList() {
        return managerList;
    }

    public void setManagerList(Map<String, String> managerList) {
        this.managerList = managerList;
    }

    @Override
    public String toString() {
        return "TestTeam{" +
                "teamName='" + teamName + '\'' +
                ", memberCount=" + memberCount +
                ", memberSalary=" + memberSalary +
                ", memberList=" + memberList +
                ", managerList=" + managerList +
                '}';
    }
}
