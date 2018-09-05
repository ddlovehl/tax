package com.ebuy.tax.user.api.userAccount.dao;

import com.ebuy.tax.user.api.userAccount.entity.UserAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.userAccount.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:25
 * @Description IuserAccountDao
 */
public interface IUserAccountDao extends IService<UserAccount> {

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-05 09:57:25
     */
    public int queryCount(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      List<UserAccount>
     * @Description 查询列表
     * @date        2018-09-05 09:57:25
     */
    public List<UserAccount> queryList(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         List<UserAccount>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-05 09:57:25
     */
    public List<UserAccount>  queryListForPage(UserAccount userAccount,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      List<UserAccount>
     * @Description 查询列表
     * @date        2018-09-05 09:57:25
     */
    public UserAccount queryEntityByUserAccountEntity(UserAccount userAccount);
}
