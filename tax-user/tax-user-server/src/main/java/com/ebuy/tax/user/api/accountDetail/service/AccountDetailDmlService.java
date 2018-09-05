package com.ebuy.tax.user.api.accountDetail.service;

import com.ebuy.tax.user.api.accountDetail.entity.AccountDetail;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.accountDetail.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description AccountDetail操作服务
 */
public interface AccountDetailDmlService{

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 18:26:55
     */
    public boolean insertAccountDetail(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 18:26:55
     */
    public boolean insertAccountDetails(List<AccountDetail> list);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 18:26:55
     */
    public boolean insertOrUpdateAccountDetail(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    public boolean updateAccountDetail(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    public boolean updateAccountDetails(List<AccountDetail> list);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 18:26:55
     */
    public boolean deleteAccountDetail(BigInteger id);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 18:26:55
     */
    public boolean deleteAccountDetails(List<BigInteger> ids);
}

