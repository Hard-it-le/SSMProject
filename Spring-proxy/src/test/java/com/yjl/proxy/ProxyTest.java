package com.yjl.proxy;

import com.yjl.proxy.service.Calculator;
import com.yjl.proxy.service.Impl.CalculatorPureImpl;
import com.yjl.proxy.service.Impl.LogDynamicProxyFactory;
import com.yjl.proxy.service.Impl.SoldierServiceImpl;
import com.yjl.proxy.service.SoldierService;
import org.junit.Test;

/**
 * @author yujiale
 * @Classname proxyTest
 * @Description TOO
 * @Date 2021/9/25 下午10:30
 * @Created by yujiale
 */
public class ProxyTest {


    @Test
    public void dynamicProxyTest01(){
        SoldierServiceImpl soldierService = new SoldierServiceImpl();
        LogDynamicProxyFactory<SoldierService> factory = new LogDynamicProxyFactory<>(soldierService);

        // 4.通过代理对象间接调用目标对象
        SoldierService proxy = factory.getProxy();
        String soldierNameById = proxy.getSoldierNameById(1);
        System.out.println(soldierNameById);
    }


    /**
     * 动态代理流程
     *
     *重要的是使用现成的动态代理类去套用到其他目标对象上。
     */
    @Test
    public void dynamicProxyTest() {

        // 1.创建被代理的目标对象
        Calculator target = new CalculatorPureImpl();

        // 2.创建能够生产代理对象的工厂对象
        LogDynamicProxyFactory<Calculator> factory = new LogDynamicProxyFactory<>(target);

        // 3.通过工厂对象生产目标对象的代理对象
        Calculator proxy = factory.getProxy();

        // 4.通过代理对象间接调用目标对象
        int addResult = proxy.add(10, 2);
        System.out.println("方法外部 addResult = " + addResult + "\n");

        int subResult = proxy.sub(10, 2);
        System.out.println("方法外部 subResult = " + subResult + "\n");

        int mulResult = proxy.mul(10, 2);
        System.out.println("方法外部 mulResult = " + mulResult + "\n");

        int divResult = proxy.div(10, 2);
        System.out.println("方法外部 divResult = " + divResult + "\n");
    }

    @Test
    public void ssTest(){
        CalculatorPureImpl calculatorPure = new CalculatorPureImpl();
        calculatorPure.add(10,20);
        calculatorPure.div(10,20);
        calculatorPure.mul(10,20);
        calculatorPure.sub(10,20);
    }
}
