package com.ebuy.tax.user.api.account_detail.dao;

import com.ebuy.tax.user.api.account_detail.entity.AccountDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.account_detail.dao
 * @Author hdq
 * @Date 2018-09-04 21:44:21
 * @Description Iaccount_detailDao
 */
public interface IAccountDetailDao extends IService<AccountDetail> {

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-04 21:44:21
     */
    public int queryCount(AccountDetail account_detail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      List<AccountDetail>
     * @Description 查询列表
     * @date        2018-09-04 21:44:21
     */
    public List<AccountDetail> queryList(AccountDetail account_detail);

    /**
     * @author      hdq
     * @see         List<AccountDetail>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-04 21:44:21
     */
    public List<AccountDetail>  queryListForPage(AccountDetail account_detail,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      List<AccountDetail>
     * @Description 查询列表
     * @date        2018-09-04 21:44:21
     */
    public AccountDetail queryEntityByAccountDetailEntity(AccountDetail account_detail);
}
