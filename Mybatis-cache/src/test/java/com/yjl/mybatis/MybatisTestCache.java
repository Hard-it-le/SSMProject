package com.yjl.mybatis;

import com.yjl.mybatis.entity.TbEmp;
import com.yjl.mybatis.mapper.TbEmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yujiale
 * @Classname MybatisTest
 * @Description TOO
 * @Date 2021/9/24 上午10:42
 * @Created by yujiale
 */
public class MybatisTestCache {

    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        //1.Resources工具类，配置文件的加载，把配置文件加载成字节输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.解析了配置文件，并创建了sqlSessionFactory工厂
        factory = new SqlSessionFactoryBuilder()
                .build(resourceAsStream);
    }


    @Test
    public void secondLevelCacheTest() {
        //3.生产sqlSession
        // 默认开启一个事务，但是该事务不会自动提交
        SqlSession session = factory.openSession();
        TbEmpMapper employeeMapper = session.getMapper(TbEmpMapper.class);
        Integer empId = 1;
        // 第一次查询
        TbEmp emp01 = employeeMapper.selectEmpById(empId);
        System.out.println("emp01 = " + emp01);
        // 提交事务
        session.commit();
        // 关闭旧SqlSession
        session.close();
        // 开启新SqlSession
        session = factory.openSession();
        // 第二次查询
        employeeMapper = session.getMapper(TbEmpMapper.class);
        TbEmp emp02 = employeeMapper.selectEmpById(empId);
        System.out.println("emp02 = " + emp02);
        session.commit();
        session.close();
        session = factory.openSession();
        employeeMapper = session.getMapper(TbEmpMapper.class);
        employeeMapper.selectEmpById(empId);
        session.commit();
        session.close();
        session = factory.openSession();
        employeeMapper = session.getMapper(TbEmpMapper.class);
        employeeMapper.selectEmpById(empId);
        session.commit();
        session.close();
        session = factory.openSession();
        employeeMapper = session.getMapper(TbEmpMapper.class);
        employeeMapper.selectEmpById(empId);
        session.commit();
        session.close();
    }

    /**
     * 测试二级缓存是否存在，使用两个不同的SqlSession查询
     * 当Cache Hit Ratio : 0.0 时，说明没有存入二级缓存中
     * sqlSession提交事务时，才会将查询到数据存入到二级缓存中
     * 本例并没有能够成功从二级缓存获取到数据
     */
    @Test
    public void secondLevelCacheExistsTest() {
        SqlSession session01 = factory.openSession();
        SqlSession session02 = factory.openSession();
        TbEmpMapper tbEmpMapper01 = session01.getMapper(TbEmpMapper.class);
        TbEmpMapper tbEmpMapper02 = session02.getMapper(TbEmpMapper.class);
        TbEmp emp01 = tbEmpMapper01.selectEmpById(2);
        TbEmp emp02 = tbEmpMapper02.selectEmpById(2);
        System.out.println(emp01);
        System.out.println(emp02);
        session01.commit();
        session01.close();
        session02.commit();
        session02.close();
    }


    /**
     * 一级缓存失效情况五：同一个SqlSession两次查询期间提交了事务
     */
    @Test
    public void firstLevelCacheNotWorkTest05() {
        SqlSession session = factory.openSession();
        TbEmpMapper tbEmpMapper = session.getMapper(TbEmpMapper.class);
        Integer empId = 1;
        TbEmp tbEmp = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp);
        session.commit();
        TbEmp tbEmp1 = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp1);
    }

    /**
     * 一级缓存失效情况四：同一个SqlSession两次查询期间手动清空了缓存
     */
    @Test
    public void firstLevelCacheNotWorkTest04() {
        SqlSession session = factory.openSession();
        TbEmpMapper tbEmpMapper = session.getMapper(TbEmpMapper.class);
        Integer empId = 1;
        TbEmp tbEmp = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp);
        session.clearCache();
        TbEmp tbEmp1 = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp1);
    }

    /**
     * 一级缓存失效情况三：同一个SqlSession两次查询期间执行了任何一次增删改操作
     */
    @Test
    public void firstLevelCacheNotWorkTest03() {
        SqlSession session = factory.openSession();
        TbEmpMapper tbEmpMapper = session.getMapper(TbEmpMapper.class);
        Integer empId = 1;
        TbEmp tbEmp = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp);
        empId = 2;
        TbEmp tbEmp1 = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp1);
        empId = 1;
        TbEmp tbEmp2 = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp2);
    }


    /**
     * 一级缓存失效情况二：同一个SqlSession但是查询条件发生了变化
     */
    @Test
    public void firstLevelCacheNotWorkTest02() {
        SqlSession session = factory.openSession();
        TbEmpMapper tbEmpMapper = session.getMapper(TbEmpMapper.class);
        Integer empId = 1;
        TbEmp tbEmp = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp);
        empId = 2;
        TbEmp tbEmp1 = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp1);
    }

    /**
     * 一级缓存失效情况一：不是同一个SqlSession
     */
    @Test
    public void firstLevelCacheNotWorkTest01() {
        SqlSession session = factory.openSession();
        SqlSession session1 = factory.openSession();
        TbEmpMapper tbEmpMapper = session.getMapper(TbEmpMapper.class);
        TbEmpMapper tbEmpMapper1 = session1.getMapper(TbEmpMapper.class);
        Integer empId = 1;
        TbEmp tbEmp = tbEmpMapper.selectEmpById(empId);
        System.out.println(tbEmp);
        TbEmp tbEmp1 = tbEmpMapper1.selectEmpById(empId);
        System.out.println(tbEmp1);
    }


    /**
     * 一级缓存
     */
    @Test
    public void firstLevelCacheTest() {
        SqlSession session = factory.openSession();
        TbEmpMapper empMapper = session.getMapper(TbEmpMapper.class);

        Integer empId = 1;
        TbEmp tbEmp = empMapper.selectEmpById(empId);
        System.out.println(tbEmp);

        TbEmp tbEmp1 = empMapper.selectEmpById(empId);
        System.out.println(tbEmp1);

        session.commit();
        session.close();
    }


}
