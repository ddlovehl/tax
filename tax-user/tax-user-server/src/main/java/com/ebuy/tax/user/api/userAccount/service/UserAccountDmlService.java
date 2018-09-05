package com.ebuy.tax.user.api.userAccount.service;

import com.ebuy.tax.user.api.userAccount.entity.UserAccount;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.userAccount.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description UserAccount操作服务
 */
public interface UserAccountDmlService{

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 18:26:55
     */
    public boolean insertUserAccount(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 18:26:55
     */
    public boolean insertUserAccounts(List<UserAccount> list);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 18:26:55
     */
    public boolean insertOrUpdateUserAccount(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    public boolean updateUserAccount(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    public boolean updateUserAccounts(List<UserAccount> list);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 18:26:55
     */
    public boolean deleteUserAccount(BigInteger id);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 18:26:55
     */
    public boolean deleteUserAccounts(List<BigInteger> ids);
}

