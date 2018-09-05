package com.ebuy.tax.user.api.customer.service;

import com.ebuy.tax.user.api.customer.entity.Customer;

import com.ebuy.tax.common.entity.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.customer.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description
 */
public interface CustomerBizService{

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      List<Customer>
     * @Description 查询列表
     * @date        2018-09-05 09:57:25
     */
    public List<Customer> queryList(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-05 09:57:25
     */
    public PageResult queryListPage(Customer customer, Integer pageNo, Integer  pageSize);

    /**
     * @author      hdq
     * @see         [id]
     * @return      Customer
     * @Description 按id查询
     * @date        2018-09-05 09:57:25
     */
    public Customer queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<Customer>
     * @Description 按ids查询列表
     * @date        2018-09-05 09:57:25
     */
    public List<Customer> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      Customer
     * @Description 根据entity查询一条记录
     * @date        2018-09-05 09:57:25
     */
    public Customer queryByParam(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return
     * @Description 添加
     * @date        2018-09-05 09:57:25
     */
    public void insert(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return
     * @Description 添加or更新
     * @date        2018-09-05 09:57:25
     */
    public void insertOrUpdate(Customer customer);

    /**
     * @author      hdq
     * @see         [Customer]
     * @return
     * @Description 更新
     * @date        2018-09-05 09:57:25
     */
    public void update(Customer customer);


}

