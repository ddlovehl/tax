package com.ebuy.tax.user.api.merchant.service;

import com.ebuy.tax.user.api.merchant.entity.Merchant;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.merchant.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description Merchant操作服务
 */
public interface MerchantDmlService{

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 09:57:25
     */
    public boolean insertMerchant(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 09:57:25
     */
    public boolean insertMerchants(List<Merchant> list);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 09:57:25
     */
    public boolean insertOrUpdateMerchant(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 09:57:25
     */
    public boolean updateMerchant(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 09:57:25
     */
    public boolean updateMerchants(List<Merchant> list);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 09:57:25
     */
    public boolean deleteMerchant(BigInteger id);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 09:57:25
     */
    public boolean deleteMerchants(List<BigInteger> ids);
}

