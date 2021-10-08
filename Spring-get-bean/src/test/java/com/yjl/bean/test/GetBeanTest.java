package com.yjl.bean.test;

import com.yjl.bean.api.Fruit;
import com.yjl.bean.api.Happy;
import com.yjl.bean.impl.FruitAppleImpl;
import com.yjl.bean.impl.HappyImpl;
import com.yjl.bean.impl.Hello;
import com.yjl.bean.impl.MoreHappyImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeanTest {

    private ApplicationContext iocContainer = new ClassPathXmlApplicationContext("spring-context.xml");

    @Test
    public void testGetBean01() {
        Hello hello = iocContainer.getBean(Hello.class);
        System.out.println("hello = " + hello);
    }

    @Test
    public void testGetBean02() {

        Happy happy = iocContainer.getBean(Happy.class);
        System.out.println("happy = " + happy);

        HappyImpl happy1 = iocContainer.getBean(HappyImpl.class);
        System.out.println("happy1 = " + happy1);
    }

    @Test
    public void testGetBean03() {
//        Happy happy = iocContainer.getBean(Happy.class);
//        System.out.println("happy = " + happy);

        HappyImpl happy01 = iocContainer.getBean(HappyImpl.class);
        MoreHappyImpl happy02 = iocContainer.getBean(MoreHappyImpl.class);

        System.out.println("happy01 = " + happy01);
        System.out.println("happy02 = " + happy02);

    }

    @Test
    public void testGetBean04() {

        Fruit fruit = iocContainer.getBean(Fruit.class);
        System.out.println("fruit = " + fruit);

        FruitAppleImpl fruitApple = iocContainer.getBean(FruitAppleImpl.class);
        System.out.println("fruitApple = " + fruitApple);

    }

    @Test
    public void testGetBean05() {

        Hello hello = iocContainer.getBean(Hello.class);
        System.out.println("hello = " + hello);

    }

}
