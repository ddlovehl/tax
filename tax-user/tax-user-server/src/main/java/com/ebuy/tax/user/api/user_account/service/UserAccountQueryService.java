package com.ebuy.tax.user.api.user_account.service;

import com.ebuy.tax.user.api.user_account.entity.UserAccount;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.user_account.dao
 * @author hdq
 * @Date 2018-09-04 21:43:56
 * @Description è´¦æˆ·è¡¨ 查询服务
 */
public interface UserAccountQueryService{

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-04 21:43:56
     */
    public UserAccount queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-04 21:43:56
     */
    public List<UserAccount> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-04 21:43:56
     */
    public int queryCountUserAccount(UserAccount user_account);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-04 21:43:56
     */
    public List<UserAccount> queryAllUserAccount(UserAccount user_account);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:43:56
     */
    public List<UserAccount> queryListForPageUserAccount(UserAccount user_account,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:43:56
     */
    public UserAccount queryEntityByUserAccountEntity(UserAccount user_account);

}

