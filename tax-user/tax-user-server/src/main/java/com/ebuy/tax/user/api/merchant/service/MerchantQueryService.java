package com.ebuy.tax.user.api.merchant.service;

import com.ebuy.tax.user.api.merchant.entity.Merchant;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.merchant.dao
 * @author hdq
 * @Date 2018-09-04 21:39:05
 * @Description  查询服务
 */
public interface MerchantQueryService{

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-04 21:39:05
     */
    public Merchant queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-04 21:39:05
     */
    public List<Merchant> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-04 21:39:05
     */
    public int queryCountMerchant(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-04 21:39:05
     */
    public List<Merchant> queryAllMerchant(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:39:05
     */
    public List<Merchant> queryListForPageMerchant(Merchant merchant,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:39:05
     */
    public Merchant queryEntityByMerchantEntity(Merchant merchant);

}

