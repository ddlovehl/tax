package com.ebuy.tax.user.api.user_account.service;

import com.ebuy.tax.user.api.user_account.entity.UserAccount;

import com.ebuy.tax.common.entity.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.user_account.dao
 * @author hdq
 * @Date 2018-09-04 21:43:56
 * @Description
 */
public interface UserAccountBizService{

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
     * @see         [UserAccount] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-04 21:43:56
     */
    public PageResult queryListPage(UserAccount user_account, Integer pageNo, Integer  pageSize);

    /**
     * @author      hdq
     * @see         [id]
     * @return      UserAccount
     * @Description 按id查询
     * @date        2018-09-04 21:43:56
     */
    public UserAccount queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<UserAccount>
     * @Description 按ids查询列表
     * @date        2018-09-04 21:43:56
     */
    public List<UserAccount> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      UserAccount
     * @Description 根据entity查询一条记录
     * @date        2018-09-04 21:43:56
     */
    public UserAccount queryByParam(UserAccount user_account);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return
     * @Description 添加
     * @date        2018-09-04 21:43:56
     */
    public void insert(UserAccount user_account);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return
     * @Description 添加or更新
     * @date        2018-09-04 21:43:56
     */
    public void insertOrUpdate(UserAccount user_account);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return
     * @Description 更新
     * @date        2018-09-04 21:43:56
     */
    public void update(UserAccount user_account);


}

