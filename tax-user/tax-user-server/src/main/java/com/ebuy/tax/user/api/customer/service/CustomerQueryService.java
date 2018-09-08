package com.ebuy.tax.user.api.customer.service;

import com.ebuy.tax.user.api.customer.entity.Customer;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.customer.dao
 * @author hdq
 * @Date 2018-09-07 15:01:17
 * @Description å®¢æˆ·è¡¨ 查询服务
 */
public interface CustomerQueryService{

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-07 15:01:17
     */
    public Customer queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<Customer> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-07 15:01:17
     */
    public int queryCountCustomer(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<Customer> queryAllCustomer(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:17
     */
    public List<Customer> queryListForPageCustomer(Customer customer,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:17
     */
    public Customer queryEntityByCustomerEntity(Customer customer);

}

