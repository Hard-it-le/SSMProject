package com.yjl.mybatis;

import com.yjl.mybatis.entity.TbCustomer;
import com.yjl.mybatis.entity.TbOrder;
import com.yjl.mybatis.mapper.TbCustomerMapper;
import com.yjl.mybatis.mapper.TbOrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yujiale
 * @Classname MybatisTest
 * @Description TOO
 * @Date 2021/9/24 上午10:42
 * @Created by yujiale
 */
public class MybatisTestLazyLoading {


    private SqlSession session;

    @Test
    public void test1SelectCustomerWithOrderList() throws InterruptedException {

        TbCustomerMapper mapper = session.getMapper(TbCustomerMapper.class);

        TbCustomer customer = mapper.selectCustomerAndOrderTwoStep(1);

        // 这里必须只打印“customerId或customerName”这样已经加载的属性才能看到延迟加载的效果
        // 这里如果打印Customer对象整体则看不到效果
        System.out.println("customer = " + customer.getCustomerName());

        // 先指定具体的时间单位，然后再让线程睡一会儿
        TimeUnit.SECONDS.sleep(5);

        List<TbOrder> orderList = customer.getOrderList();

        for (TbOrder order : orderList) {
            System.out.println("order = " + order);
        }
    }


    @Test
    public void selectCustomerAndOrderTwoStepTest() {
        TbCustomerMapper customerMapper = session.getMapper(TbCustomerMapper.class);
        Integer customerId = 1;
        TbCustomer tbCustomer = customerMapper.selectCustomerAndOrderTwoStep(customerId);
        System.out.println(tbCustomer);
        List<TbOrder> orderList = tbCustomer.getOrderList();
        for (TbOrder order : orderList) {
            System.out.println(order);
        }

    }

    @Test
    public void selectOrderAndCustomerTwoStepTest() {
        TbOrderMapper orderMapper = session.getMapper(TbOrderMapper.class);
        Integer orderId = 1;
        TbOrder order = orderMapper.selectOrderAndCustomerTwoStep(orderId);
        System.out.println(order);
        TbCustomer customer = order.getCustomer();
        System.out.println(customer);
    }


    @Before
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @After
    public void clear() {
        session.commit();
        session.close();
    }

}
