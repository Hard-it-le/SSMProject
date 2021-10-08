package com.yjl.ioc.factory;

import com.yjl.ioc.component.TestMachine;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author yujiale
 * @Classname TestFactoryBean
 * @Description TOO
 * @Date 2021/9/25 下午6:12
 * @Created by yujiale
 */
public class TestFactoryBean implements FactoryBean<TestMachine> {
    private String machineName;

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    @Override
    public TestMachine getObject() throws Exception {
        //方法内部模拟创建、设置一个对象的复杂过程
        TestMachine testMachine = new TestMachine();
        testMachine.setMachineName("dasd");
        return testMachine;
    }

    @Override
    public Class<?> getObjectType() {
        return TestMachine.class;
    }
}
