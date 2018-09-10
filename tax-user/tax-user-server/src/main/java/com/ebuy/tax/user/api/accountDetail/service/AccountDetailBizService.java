package com.ebuy.tax.user.api.accountDetail.service;

import com.ebuy.tax.user.api.accountDetail.entity.AccountDetail;

import com.ebuy.tax.common.entity.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.accountDetail.dao
 * @author hdq
 * @Date 2018-09-07 15:01:17
 * @Description
 */
public interface AccountDetailBizService{

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      List<AccountDetail>
     * @Description 查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<AccountDetail> queryList(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-07 15:01:17
     */
    public PageResult queryListPage(AccountDetail accountDetail, Integer pageNo, Integer  pageSize);

    /**
     * @author      hdq
     * @see         [id]
     * @return      AccountDetail
     * @Description 按id查询
     * @date        2018-09-07 15:01:17
     */
    public AccountDetail queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<AccountDetail>
     * @Description 按ids查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<AccountDetail> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      AccountDetail
     * @Description 根据entity查询一条记录
     * @date        2018-09-07 15:01:17
     */
    public AccountDetail queryByParam(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return
     * @Description 添加
     * @date        2018-09-07 15:01:17
     */
    public void insert(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return
     * @Description 添加or更新
     * @date        2018-09-07 15:01:17
     */
    public void insertOrUpdate(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return
     * @Description 更新
     * @date        2018-09-07 15:01:17
     */
    public void update(AccountDetail accountDetail);


}

