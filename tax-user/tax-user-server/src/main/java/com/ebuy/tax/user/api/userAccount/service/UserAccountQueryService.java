package com.ebuy.tax.user.api.userAccount.service;

import com.ebuy.tax.user.api.userAccount.entity.UserAccount;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.userAccount.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description è´¦æˆ·è¡¨ 查询服务
 */
public interface UserAccountQueryService{

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-07 15:01:18
     */
    public UserAccount queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-07 15:01:18
     */
    public List<UserAccount> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-07 15:01:18
     */
    public int queryCountUserAccount(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-07 15:01:18
     */
    public List<UserAccount> queryAllUserAccount(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:18
     */
    public List<UserAccount> queryListForPageUserAccount(UserAccount userAccount,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:18
     */
    public UserAccount queryEntityByUserAccountEntity(UserAccount userAccount);

}

