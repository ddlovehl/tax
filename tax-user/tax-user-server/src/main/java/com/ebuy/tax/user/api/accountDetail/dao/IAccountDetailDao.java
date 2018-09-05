package com.ebuy.tax.user.api.accountDetail.dao;

import com.ebuy.tax.user.api.accountDetail.entity.AccountDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.accountDetail.dao
 * @Author hdq
 * @Date 2018-09-05 09:57:24
 * @Description IaccountDetailDao
 */
public interface IAccountDetailDao extends IService<AccountDetail> {

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-05 09:57:24
     */
    public int queryCount(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      List<AccountDetail>
     * @Description 查询列表
     * @date        2018-09-05 09:57:24
     */
    public List<AccountDetail> queryList(AccountDetail accountDetail);

    /**
     * @author      hdq
     * @see         List<AccountDetail>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-05 09:57:24
     */
    public List<AccountDetail>  queryListForPage(AccountDetail accountDetail,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      List<AccountDetail>
     * @Description 查询列表
     * @date        2018-09-05 09:57:24
     */
    public AccountDetail queryEntityByAccountDetailEntity(AccountDetail accountDetail);
}
