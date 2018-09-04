package com.ebuy.tax.user.implementation.customer.service;

import com.ebuy.tax.user.api.customer.entity.Customer;
import com.ebuy.tax.user.api.user.dao.IUserDao;
import com.ebuy.tax.user.api.customer.service.CustomerQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.customer.dao
 * @author hdq
 * @Date 2018-09-04 21:41:20
 * @Description å®¢æˆ·è¡¨ 查询服务
 */
@CacheConfig(cacheNames = {"CustomerCache"})
public class CustomerQueryServiceImpl implements CustomerQueryService{

    @Resource(name = "customerDao")
    private ICustomerDao customerDao;

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-04 21:41:20
     */
    @Override
    public Customer queryById(BigInteger id){
        return customerDao.selectById(id);
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-04 21:41:20
     */
        @Override
    public List<Customer> queryByIds(List<BigInteger> ids){
        return (List<Customer>)customerDao.selectBatchIds(ids);
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-04 21:41:20
     */
    @Override
    public int queryCountCustomer(Customer customer){
        return customerDao.queryCount(customer);
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-04 21:41:20
     */
    @Override
    public List<Customer> queryAllCustomer(Customer customer){
        return customerDao.queryList(customer);
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:41:20
     */
    @Override
    public List<Customer> queryListForPageCustomer(Customer customer,Integer pageNo,Integer pageSize){
        return customerDao.queryListForPage(customer,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:41:20
     */
    @Override
    public Customer queryEntityByCustomerEntity(Customer customer){
        return customerDao.queryEntityByCustomerEntity(customer);
    }


}

