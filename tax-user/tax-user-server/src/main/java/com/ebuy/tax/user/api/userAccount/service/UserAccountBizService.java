package com.ebuy.tax.user.api.userAccount.service;

import com.ebuy.tax.user.api.userAccount.entity.UserAccount;

import com.ebuy.tax.common.entity.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.userAccount.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description
 */
public interface UserAccountBizService{

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      List<UserAccount>
     * @Description 查询列表
     * @date        2018-09-07 15:01:18
     */
    public List<UserAccount> queryList(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-07 15:01:18
     */
    public PageResult queryListPage(UserAccount userAccount, Integer pageNo, Integer  pageSize);

    /**
     * @author      hdq
     * @see         [id]
     * @return      UserAccount
     * @Description 按id查询
     * @date        2018-09-07 15:01:18
     */
    public UserAccount queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<UserAccount>
     * @Description 按ids查询列表
     * @date        2018-09-07 15:01:18
     */
    public List<UserAccount> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      UserAccount
     * @Description 根据entity查询一条记录
     * @date        2018-09-07 15:01:18
     */
    public UserAccount queryByParam(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return
     * @Description 添加
     * @date        2018-09-07 15:01:18
     */
    public void insert(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return
     * @Description 添加or更新
     * @date        2018-09-07 15:01:18
     */
    public void insertOrUpdate(UserAccount userAccount);

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return
     * @Description 更新
     * @date        2018-09-07 15:01:18
     */
    public void update(UserAccount userAccount);

    /**
     * @return java.lang.String
     * @param
     * @author hdq
     * @Description 获取我的账户余额
     * @date 2018/9/8 18:39
     */
    public BigDecimal queryAccountBalance(String userId);
}

