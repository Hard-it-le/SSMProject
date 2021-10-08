package com.yjl.ioc.component;

/**
 * @author yujiale
 * @Classname TestComponent
 * @Description TOO
 * @Date 2021/9/25 下午2:49
 * @Created by yujiale
 */
public class TestComponent implements TestInterface {

    private String name;

    private TestMachine testMachine;

    public TestComponent() {
    }

    public TestComponent(String name) {
        this.name = name;
    }

    public TestMachine getTestMachine() {
        return testMachine;
    }

    public void setTestMachine(TestMachine testMachine) {
        this.testMachine = testMachine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        System.out.println("component do work ....");
    }
}
