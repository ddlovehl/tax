package com.ebuy.tax.user.implementation.customer.service;

import com.ebuy.tax.user.api.customer.entity.Customer;
import com.ebuy.tax.user.api.customer.dao.ICustomerDao;
import com.ebuy.tax.user.api.customer.service.CustomerDmlService;
import com.ebuy.tax.common.constants.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.math.BigInteger;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import com.ebuy.tax.common.exception.SystemException;
import javax.annotation.Resource;

/**
 * @Package com.ebuy.tax.user.implementation.customer.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description å®¢æˆ·è¡¨ 操作服务
 */
@CacheConfig(cacheNames = {"CustomerCache}"})
public class CustomerDmlServiceImpl implements CustomerDmlService {

    private static final Logger log = LoggerFactory.getLogger(CustomerDmlServiceImpl.class);

    @Resource(name = "customerDao")
    private ICustomerDao customerDao;

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertCustomer(Customer customer){
        boolean flag = true;
        try{
            flag = customerDao.insert(customer);
        } catch (Exception e){
            log.error("CustomerDmlServiceImpl-insertCustomer添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertCustomers(List<Customer> list){
        boolean flag = true;
        try{
            flag = customerDao.insertBatch(list);
        } catch (Exception e){
            log.error("CustomerDmlServiceImpl-insertCustomers添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertOrUpdateCustomer(Customer customer){
        boolean flag = true;
        try{
        //存在更新记录，否插入一条记录
        flag = customerDao.insertOrUpdate(customer);
        } catch (Exception e){
           log.info("CustomerDmlServiceImpl-update更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateCustomer(Customer customer){
        boolean flag = true;
        try{
            flag = customerDao.updateById(customer);
        } catch (Exception e){
            log.error("CustomerDmlServiceImpl-updateCustomer更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateCustomers(List<Customer> list){
        boolean flag = true;
        try{
            flag = customerDao.updateBatchById(list);
        } catch (Exception e){
            log.error("CustomerDmlServiceImpl-updateCustomers更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteCustomer(BigInteger id){
        boolean flag = true;
        try{
            flag = customerDao.deleteById(Long.parseLong(id.toString()));
        } catch (Exception e){
            log.error("CustomerDmlServiceImpl-deleteCustomer删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "删除用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Customer]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteCustomers(List<BigInteger> ids){
        boolean flag = true;
        try{
            flag = customerDao.deleteBatchIds(ids);
        } catch (Exception e){
            log.error("CustomerDmlServiceImpl-deleteCustomers删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量删除用户信息失败");
        }
        return flag;
    }
}

