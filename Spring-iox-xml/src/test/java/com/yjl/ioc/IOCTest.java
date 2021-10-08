package com.yjl.ioc;

import com.yjl.ioc.component.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yujiale
 * @Classname IOCTest
 * @Description TOO
 * @Date 2021/9/25 下午2:50
 * @Created by yujiale
 */
public class IOCTest {

    //创建ioc容器对象，为了各个实验方法这个对象，声明成员变量
    private ApplicationContext iocContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void testExperiment15() {
        TestMachine happyMachine01 = (TestMachine) iocContainer.getBean("happyMachine4");
        TestMachine happyMachine02 = (TestMachine) iocContainer.getBean("happyMachine4");
        System.out.println(happyMachine01 == happyMachine02);
        System.out.println("happyMachine01.hashCode() = " + happyMachine01.hashCode());
        System.out.println("happyMachine02.hashCode() = " + happyMachine02.hashCode());
    }

    @Test
    public void testExperiment14() {
        TestMachine happyMachine3 = (TestMachine) iocContainer.getBean("testMachine3");
        String machineName = happyMachine3.getMachineName();

        System.out.println("machineName = " + machineName);
    }

    @Test
    public void testExperiment12() {
        TestController happyController = iocContainer.getBean(TestController.class);
        TestService happyService = happyController.getTestService();
        System.out.println("happyService = " + happyService);
    }

    @Test
    public void testExperiment13() {
        TestTeam happyTeam2 = (TestTeam) iocContainer.getBean("happyTeam2");
        List<String> memberList = happyTeam2.getMemberList();
        for (String member : memberList) {
            System.out.println("member = " + member);
        }
        Map<String, String> managerList = happyTeam2.getManagerList();
        Set<Map.Entry<String, String>> entries = managerList.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "," + value);
        }

    }

    @Test
    public void testExperiment08() {

        TestTeam happyTeam = iocContainer.getBean(TestTeam.class);

        System.out.println("happyTeam = " + happyTeam);

    }

    @Test
    public void experiment07Test() {
        TestComponent testComponent6 = (TestComponent) iocContainer.getBean("testComponent6");
        String machineName = testComponent6.getTestMachine().getMachineName();
        System.out.println(machineName);

    }

    @Test
    public void experiment06Test() throws SQLException {
        DataSource bean = iocContainer.getBean(DataSource.class);
        Connection connection = bean.getConnection();
        System.out.println("connection:" + connection);
    }


    /**
     * 给bean的属性赋值：内部bean
     */
    @Test
    public void testExperiment04() {
        TestComponent happyComponent4 = (TestComponent) iocContainer.getBean("happyComponent5");
        TestMachine happyMachine = happyComponent4.getTestMachine();
        String machineName = happyMachine.getMachineName();
        System.out.println("machineName = " + machineName);
    }


    /**
     * 给bean的属性赋值：引用外部已声明的bean
     */
    @Test
    public void experiment04Test() {
        TestComponent testComponentAndMachine = (TestComponent) iocContainer.getBean("testComponentAndMachine");
        TestMachine testMachine = testComponentAndMachine.getTestMachine();
        String machineName = testMachine.getMachineName();
        System.out.println(machineName);

    }

    /**
     * 给bean的属性赋值：setter注入,主要是看get和set方法
     */
    @Test
    public void experimentSetBeanTest() {
        TestComponent testComponent = iocContainer.getBean(TestComponent.class);
        String name = testComponent.getName();
        System.out.println(name);
    }


    @Test
    public void experiment03Test() {
        //如果IOC容器中接口类型的bean只有一个，那么这个接口类型的bean对象接口类型执行instanceof判断能够返回true
        TestInterface bean = iocContainer.getBean(TestInterface.class);
        System.out.println(bean);
    }

    /**
     * 根据指定类型获取bean对象
     * <p>
     * 根据类型来获取bean时，在满足bean唯一性的前提下，
     * 其实只是看：『对象 instanceof 指定的类型』的返回结果，
     * 只要返回的是true就可以认定为和类型匹配，能够获取到
     */
    @Test
    public void experiment02Test() {
        TestComponent testComponent = iocContainer.getBean(TestComponent.class);
        testComponent.doWork();
    }

    /**
     * Spring 底层默认通过反射技术调用组件类的无参构造器来创建组件对象，
     * 这一点需要注意。如果在需要无参构造器时，没有无参构造器，则会抛出异常
     */
    @Test
    public void experiment01Test() {
        //1。从IOc容器中获取已经配置的bean
        TestComponent testComponent = (TestComponent) iocContainer.getBean("testComponent");
        //2。调用这个组件的对啊行方法
        testComponent.doWork();

    }
}
