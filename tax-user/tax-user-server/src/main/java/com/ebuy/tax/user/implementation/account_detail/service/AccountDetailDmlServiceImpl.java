package com.ebuy.tax.user.implementation.account_detail.service;

import com.ebuy.tax.user.api.account_detail.dao.IAccountDetailDao;
import com.ebuy.tax.user.api.account_detail.entity.AccountDetail;
import com.ebuy.tax.user.api.account_detail.service.AccountDetailDmlService;
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
 * @Package com.ebuy.tax.user.implementation.account_detail.dao
 * @author hdq
 * @Date 2018-09-04 21:44:21
 * @Description  操作服务
 */
@CacheConfig(cacheNames = {"AccountDetailCache}"})
public class AccountDetailDmlServiceImpl implements AccountDetailDmlService {

    private static final Logger log = LoggerFactory.getLogger(AccountDetailDmlServiceImpl.class);

    @Resource(name = "iAccountDetailDao")
    private IAccountDetailDao account_detailDao;

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-04 21:44:21
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertAccountDetail(AccountDetail account_detail){
        boolean flag = true;
        try{
            flag = account_detailDao.insert(account_detail);
        } catch (Exception e){
            log.error("AccountDetailDmlServiceImpl-insertAccountDetail添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-04 21:44:21
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertAccountDetails(List<AccountDetail> list){
        boolean flag = true;
        try{
            flag = account_detailDao.insertBatch(list);
        } catch (Exception e){
            log.error("AccountDetailDmlServiceImpl-insertAccountDetails添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-04 21:44:21
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertOrUpdateAccountDetail(AccountDetail account_detail){
        boolean flag = true;
        try{
        //存在更新记录，否插入一条记录
        flag = account_detailDao.insertOrUpdate(account_detail);
        } catch (Exception e){
           log.info("AccountDetailDmlServiceImpl-update更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:44:21
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateAccountDetail(AccountDetail account_detail){
        boolean flag = true;
        try{
            flag = account_detailDao.updateById(account_detail);
        } catch (Exception e){
            log.error("AccountDetailDmlServiceImpl-updateAccountDetail更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:44:21
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateAccountDetails(List<AccountDetail> list){
        boolean flag = true;
        try{
            flag = account_detailDao.updateBatchById(list);
        } catch (Exception e){
            log.error("AccountDetailDmlServiceImpl-updateAccountDetails更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-04 21:44:21
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteAccountDetail(BigInteger id){
        boolean flag = true;
        try{
            flag = account_detailDao.deleteById(Long.parseLong(id.toString()));
        } catch (Exception e){
            log.error("AccountDetailDmlServiceImpl-deleteAccountDetail删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "删除用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-04 21:44:21
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteAccountDetails(List<BigInteger> ids){
        boolean flag = true;
        try{
            flag = account_detailDao.deleteBatchIds(ids);
        } catch (Exception e){
            log.error("AccountDetailDmlServiceImpl-deleteAccountDetails删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量删除用户信息失败");
        }
        return flag;
    }
}

