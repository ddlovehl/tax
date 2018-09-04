package com.ebuy.tax.user.api.user_account.dao;

import com.ebuy.tax.user.api.user_account.entity.UserAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.user_account.dao
 * @Author hdq
 * @Date 2018-09-04 21:43:56
 * @Description Iuser_accountDao
 */
public interface IUserAccountDao extends IService<UserAccount> {

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-04 21:43:56
     */
    public int queryCount(UserAccount user_account);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      List<UserAccount>
     * @Description 查询列表
     * @date        2018-09-04 21:43:56
     */
    public List<UserAccount> queryList(UserAccount user_account);

    /**
     * @author      hdq
     * @see         List<UserAccount>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-04 21:43:56
     */
    public List<UserAccount>  queryListForPage(UserAccount user_account,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      List<UserAccount>
     * @Description 查询列表
     * @date        2018-09-04 21:43:56
     */
    public UserAccount queryEntityByUserAccountEntity(UserAccount user_account);
}
