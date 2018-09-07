package com.ebuy.tax.user.api.customer.service;

import com.ebuy.tax.user.api.customer.entity.Customer;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.customer.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description Customer操作服务
 */
public interface CustomerDmlService{

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 18:26:55
     */
    public boolean insertCustomer(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 18:26:55
     */
    public boolean insertCustomers(List<Customer> list);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 18:26:55
     */
    public boolean insertOrUpdateCustomer(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    public boolean updateCustomer(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    public boolean updateCustomers(List<Customer> list);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 18:26:55
     */
    public boolean deleteCustomer(BigInteger id);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 18:26:55
     */
    public boolean deleteCustomers(List<BigInteger> ids);
}

