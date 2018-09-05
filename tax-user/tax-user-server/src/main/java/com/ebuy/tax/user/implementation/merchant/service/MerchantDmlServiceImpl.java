package com.ebuy.tax.user.implementation.merchant.service;

import com.ebuy.tax.user.api.merchant.dao.IMerchantDao;
import com.ebuy.tax.user.api.merchant.entity.Merchant;
import com.ebuy.tax.user.api.merchant.service.MerchantDmlService;
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
 * @Package com.ebuy.tax.user.implementation.merchant.dao
 * @author hdq
 * @Date 2018-09-04 21:39:06
 * @Description  操作服务
 */
@CacheConfig(cacheNames = {"MerchantCache}"})
public class MerchantDmlServiceImpl implements MerchantDmlService {

    private static final Logger log = LoggerFactory.getLogger(MerchantDmlServiceImpl.class);

    @Resource(name = "merchantDao")
    private IMerchantDao merchantDao;

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-04 21:39:06
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertMerchant(Merchant merchant){
        boolean flag = true;
        try{
            flag = merchantDao.insert(merchant);
        } catch (Exception e){
            log.error("MerchantDmlServiceImpl-insertMerchant添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-04 21:39:06
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertMerchants(List<Merchant> list){
        boolean flag = true;
        try{
            flag = merchantDao.insertBatch(list);
        } catch (Exception e){
            log.error("MerchantDmlServiceImpl-insertMerchants添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-04 21:39:06
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertOrUpdateMerchant(Merchant merchant){
        boolean flag = true;
        try{
        //存在更新记录，否插入一条记录
        flag = merchantDao.insertOrUpdate(merchant);
        } catch (Exception e){
           log.info("MerchantDmlServiceImpl-update更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:39:06
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateMerchant(Merchant merchant){
        boolean flag = true;
        try{
            flag = merchantDao.updateById(merchant);
        } catch (Exception e){
            log.error("MerchantDmlServiceImpl-updateMerchant更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:39:06
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateMerchants(List<Merchant> list){
        boolean flag = true;
        try{
            flag = merchantDao.updateBatchById(list);
        } catch (Exception e){
            log.error("MerchantDmlServiceImpl-updateMerchants更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-04 21:39:06
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteMerchant(BigInteger id){
        boolean flag = true;
        try{
            flag = merchantDao.deleteById(Long.parseLong(id.toString()));
        } catch (Exception e){
            log.error("MerchantDmlServiceImpl-deleteMerchant删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "删除用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-04 21:39:06
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteMerchants(List<BigInteger> ids){
        boolean flag = true;
        try{
            flag = merchantDao.deleteBatchIds(ids);
        } catch (Exception e){
            log.error("MerchantDmlServiceImpl-deleteMerchants删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量删除用户信息失败");
        }
        return flag;
    }
}

