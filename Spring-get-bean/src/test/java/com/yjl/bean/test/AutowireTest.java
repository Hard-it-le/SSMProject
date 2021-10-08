package com.yjl.bean.test;

import com.yjl.bean.api.Fruit;
import com.yjl.bean.impl.HappyImpl;
import com.yjl.bean.impl.Hello;
import com.yjl.bean.impl.MoreHappyImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-context.xml"})
public class AutowireTest {

    @Autowired
    private Hello hello;

//    @Autowired
//    private Happy happy;

    @Autowired
    private HappyImpl happyImpl;

    @Autowired
    private MoreHappyImpl moreHappy;

    @Autowired
    private Fruit fruit;

//    @Autowired
//    private FruitAppleImpl apple;

    @Test
    public void test01() {
        System.out.println("hello = " + hello);

        System.out.println("happyImpl = " + happyImpl);
        System.out.println("moreHappy = " + moreHappy);

        System.out.println("fruit = " + fruit);

//        System.out.println("apple = " + apple);
    }

}
