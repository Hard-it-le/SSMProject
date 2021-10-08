package com.yjl.mybatis.mapper;

import com.yjl.mybatis.entity.Customer;
import com.yjl.mybatis.entity.CustomerExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    int countByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    int deleteByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    int deleteByPrimaryKey(Integer customerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    int insertSelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    List<Customer> selectByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    Customer selectByPrimaryKey(Integer customerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_customer
     *
     * @mbggenerated Sat May 29 14:08:57 CST 2021
     */
    int updateByPrimaryKey(Customer record);
}