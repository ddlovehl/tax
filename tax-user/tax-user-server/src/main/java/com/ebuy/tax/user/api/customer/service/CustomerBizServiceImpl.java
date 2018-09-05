package com.ebuy.tax.user.api.customer.service;

import com.ebuy.tax.user.api.customer.entity.Customer;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;

/**
 * @Package com.ebuy.tax.user.api.customer.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description
 */
public class CustomerBizServiceImpl implements CustomerBizService{

    private static final Logger logger = LoggerFactory.getLogger(CustomerBizServiceImpl.class);

    private CustomerDmlService customerDmlService;

    private CustomerQueryService customerQueryService;

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      List<Customer>
     * @Description 查询列表
     * @date        2018-09-05 09:57:25
     */
    public List<Customer> queryList(Customer customer){
        return customerQueryService.queryAllCustomer(customer);
    }

    /**
     * @author      hdq
     * @see         [Customer] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-05 09:57:25
     */
    public PageResult queryListPage(Customer customer, Integer pageNo, Integer  pageSize){
        //查询分页列表总数
        int count = customerQueryService.queryCountCustomer(customer);
        List<Customer> list = new LinkedList<Customer>();
        if(count > 0) {
            list = customerQueryService.queryListForPageCustomer(customer,pageNo,pageSize);
        }
        return  new PageResult(list,(long)count);
    }

    /**
     * @author      hdq
     * @see         [id]
     * @return      Customer
     * @Description 按id查询
     * @date        2018-09-05 09:57:25
     */
    public Customer queryById(BigInteger id){
        return customerQueryService.queryById(id);
    }

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<Customer>
     * @Description 按ids查询列表
     * @date        2018-09-05 09:57:25
     */
    public List<Customer> queryByIds(List<BigInteger> ids){
        return customerQueryService.queryByIds(ids);
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      Customer
     * @Description 根据entity查询一条记录
     * @date        2018-09-05 09:57:25
     */
    public Customer queryByParam(Customer customer){
        return customerQueryService.queryEntityByCustomerEntity(customer);
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return
     * @Description 添加
     * @date        2018-09-05 09:57:25
     */
    public void insert(Customer customer){
        customerDmlService.insertCustomer(customer);
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return
     * @Description 添加or更新
     * @date        2018-09-05 09:57:25
     */
    public void insertOrUpdate(Customer customer){
        customerDmlService.insertOrUpdateCustomer(customer);
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return
     * @Description 更新
     * @date        2018-09-05 09:57:25
     */
    public void update(Customer customer){
        customerDmlService.updateCustomer(customer);
    }


}

