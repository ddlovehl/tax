package com.ebuy.tax.user.api.accountDetail.service;

import com.ebuy.tax.user.api.accountDetail.entity.AccountDetail;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.accountDetail.dao
 * @author hdq
 * @Date 2018-09-07 15:01:17
 * @Description  查询服务
 */
public interface AccountDetailQueryService{

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-07 15:01:17
     */
    public AccountDetail queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<AccountDetail> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-07 15:01:17
     */
    public int queryCountAccountDetail(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<AccountDetail> queryAllAccountDetail(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:17
     */
    public List<AccountDetail> queryListForPageAccountDetail(AccountDetail accountDetail,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:17
     */
    public AccountDetail queryEntityByAccountDetailEntity(AccountDetail accountDetail);

}

