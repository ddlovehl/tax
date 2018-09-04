package com.ebuy.tax.user.api.user_account.service;

import com.ebuy.tax.user.api.user_account.entity.UserAccount;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.user_account.dao
 * @author hdq
 * @Date 2018-09-04 21:43:56
 * @Description UserAccount操作服务
 */
public interface UserAccountDmlService{

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-04 21:43:56
     */
    public boolean insertUserAccount(UserAccount user_account);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-04 21:43:56
     */
    public boolean insertUserAccounts(List<UserAccount> list);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-04 21:43:56
     */
    public boolean insertOrUpdateUserAccount(UserAccount user_account);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:43:56
     */
    public boolean updateUserAccount(UserAccount user_account);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:43:56
     */
    public boolean updateUserAccounts(List<UserAccount> list);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-04 21:43:56
     */
    public boolean deleteUserAccount(BigInteger id);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-04 21:43:56
     */
    public boolean deleteUserAccounts(List<BigInteger> ids);
}

