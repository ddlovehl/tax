package com.ebuy.tax.user.api.customer.dao;

import com.ebuy.tax.user.api.customer.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.customer.dao
 * @Author hdq
 * @Date 2018-09-05 18:26:55
 * @Description IcustomerDao
 */
public interface ICustomerDao extends IService<Customer> {

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-05 18:26:55
     */
    public int queryCount(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      List<Customer>
     * @Description 查询列表
     * @date        2018-09-05 18:26:55
     */
    public List<Customer> queryList(Customer customer);

    /**
     * @author      hdq
     * @see         List<Customer>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-05 18:26:55
     */
    public List<Customer>  queryListForPage(Customer customer,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      List<Customer>
     * @Description 查询列表
     * @date        2018-09-05 18:26:55
     */
    public Customer queryEntityByCustomerEntity(Customer customer);
}
