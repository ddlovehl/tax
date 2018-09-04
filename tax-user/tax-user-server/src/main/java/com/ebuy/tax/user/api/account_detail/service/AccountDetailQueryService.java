package com.ebuy.tax.user.api.account_detail.service;

import com.ebuy.tax.user.api.account_detail.entity.AccountDetail;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.account_detail.dao
 * @author hdq
 * @Date 2018-09-04 21:44:21
 * @Description  查询服务
 */
public interface AccountDetailQueryService{

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-04 21:44:21
     */
    public AccountDetail queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-04 21:44:21
     */
    public List<AccountDetail> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-04 21:44:21
     */
    public int queryCountAccountDetail(AccountDetail account_detail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-04 21:44:21
     */
    public List<AccountDetail> queryAllAccountDetail(AccountDetail account_detail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:44:21
     */
    public List<AccountDetail> queryListForPageAccountDetail(AccountDetail account_detail,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:44:21
     */
    public AccountDetail queryEntityByAccountDetailEntity(AccountDetail account_detail);

}

