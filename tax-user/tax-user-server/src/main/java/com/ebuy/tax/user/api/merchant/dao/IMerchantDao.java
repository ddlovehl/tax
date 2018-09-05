package com.ebuy.tax.user.api.merchant.dao;

import com.ebuy.tax.user.api.merchant.entity.Merchant;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.merchant.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:25
 * @Description ImerchantDao
 */
public interface IMerchantDao extends IService<Merchant> {

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-05 09:57:25
     */
    public int queryCount(Merchant merchant);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      List<Merchant>
     * @Description 查询列表
     * @date        2018-09-05 09:57:25
     */
    public List<Merchant> queryList(Merchant merchant);

    /**
     * @author      hdq
     * @see         List<Merchant>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-05 09:57:25
     */
    public List<Merchant>  queryListForPage(Merchant merchant,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Merchant]
     * @return      List<Merchant>
     * @Description 查询列表
     * @date        2018-09-05 09:57:25
     */
    public Merchant queryEntityByMerchantEntity(Merchant merchant);
}
