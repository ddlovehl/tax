package com.ebuy.tax.user.api.account_detail.service;

import com.ebuy.tax.user.api.account_detail.entity.AccountDetail;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.account_detail.dao
 * @author hdq
 * @Date 2018-09-04 21:44:21
 * @Description AccountDetail操作服务
 */
public interface AccountDetailDmlService{

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-04 21:44:21
     */
    public boolean insertAccountDetail(AccountDetail account_detail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-04 21:44:21
     */
    public boolean insertAccountDetails(List<AccountDetail> list);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-04 21:44:21
     */
    public boolean insertOrUpdateAccountDetail(AccountDetail account_detail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:44:21
     */
    public boolean updateAccountDetail(AccountDetail account_detail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:44:21
     */
    public boolean updateAccountDetails(List<AccountDetail> list);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-04 21:44:21
     */
    public boolean deleteAccountDetail(BigInteger id);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-04 21:44:21
     */
    public boolean deleteAccountDetails(List<BigInteger> ids);
}

