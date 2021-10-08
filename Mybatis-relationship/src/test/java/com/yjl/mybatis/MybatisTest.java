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


/**
 * @author yujiale
 * @Classname MybatisTest
 * @Description TOO
 * @Date 2021/9/24 上午8:34
 * @Created by yujiale
 */
public class MybatisTest {

    private SqlSession session;


    @Test
    public void testSelectCustomerWithOrderList(){
        TbCustomerMapper customerMapper = session.getMapper(TbCustomerMapper.class);
        Integer customerId = 1;
        TbCustomer tbCustomer = customerMapper.selectCustomerWithOrderList(customerId);
        System.out.println(tbCustomer);
    }

    @Test
    public void testSelectOrderAndCustomer() {
        TbOrderMapper orderMapper = session.getMapper(TbOrderMapper.class);
        Long orderId = 1L;
        TbOrder order = orderMapper.selectOrderAndCustomer(orderId);
        System.out.println(order);
    }

    @Test
    public void testSelectOrderAll(){
        TbOrderMapper orderMapper = session.getMapper(TbOrderMapper.class);
        List<TbOrder> tbOrders = orderMapper.selectOrderAll();
        System.out.println(tbOrders);
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
