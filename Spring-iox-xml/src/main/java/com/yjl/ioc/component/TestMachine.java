package com.yjl.ioc.component;

/**
 * @author yujiale
 * @Classname TestMachine
 * @Description TOO
 * @Date 2021/9/25 下午4:08
 * @Created by yujiale
 */
public class TestMachine {

    private String machineName;

    public TestMachine() {
        System.out.println();
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
}
