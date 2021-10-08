package com.yjl.aop;


import com.yjl.aop.service.CalculatorService;
import com.yjl.aop.service.Impl.EmployeeServiceImpl;
import com.yjl.aop.service.SoldierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yujiale
 * @Classname AopProxyTest
 * @Description TOO
 * @Date 2021/9/26 下午9:53
 * @Created by yujiale
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class AopProxyTest {


    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private SoldierService soldierService;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Test
    public void testNoInterfaceProxy() {
        employeeServiceImpl.getEmpList();
        System.out.println();
    }

    @Test
    public void testAOPProxy2() {
        int count = soldierService.removeSoldier(1);
        System.out.println("remove count = " + count + "\n");

        count = soldierService.saveSoldier("aa");
        System.out.println("save count = " + count + "\n");

        String soldierName = soldierService.getSoldierNameById(1);
        System.out.println("soldierName = " + soldierName + "\n");
    }

    @Test
    public void testAOPProxy() {

        int add = calculatorService.add(10, 2);
        System.out.println("方法外部 add = " + add);

        int div = calculatorService.div(10, 2);
        System.out.println("方法外部 div = " + div);

        int sub = calculatorService.sub(10, 2);
        System.out.println("方法外部 sub = " + sub);

        int mul = calculatorService.mul(10, 2);
        System.out.println("方法外部 mul = " + mul);
    }

}