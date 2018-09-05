package com.ebuy.tax.user.implementation.merchant.service;

import com.ebuy.tax.user.api.merchant.entity.Merchant;
import com.ebuy.tax.user.api.merchant.dao.IMerchantDao;
import com.ebuy.tax.user.api.merchant.service.MerchantQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.merchant.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description  查询服务
 */
@CacheConfig(cacheNames = {"MerchantCache"})
public class MerchantQueryServiceImpl implements MerchantQueryService{

    @Resource(name = "merchantDao")
    private IMerchantDao merchantDao;

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-05 09:57:25
     */
    @Override
    public Merchant queryById(BigInteger id){
        return merchantDao.selectById(id);
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-05 09:57:25
     */
        @Override
    public List<Merchant> queryByIds(List<BigInteger> ids){
        return (List<Merchant>)merchantDao.selectBatchIds(ids);
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-05 09:57:25
     */
    @Override
    public int queryCountMerchant(Merchant merchant){
        return merchantDao.queryCount(merchant);
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-05 09:57:25
     */
    @Override
    public List<Merchant> queryAllMerchant(Merchant merchant){
        return merchantDao.queryList(merchant);
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 09:57:25
     */
    @Override
    public List<Merchant> queryListForPageMerchant(Merchant merchant,Integer pageNo,Integer pageSize){
        return merchantDao.queryListForPage(merchant,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 09:57:25
     */
    @Override
    public Merchant queryEntityByMerchantEntity(Merchant merchant){
        return merchantDao.queryEntityByMerchantEntity(merchant);
    }


}

