package com.ebuy.tax.user.api.accountDetail.service;

import com.ebuy.tax.user.api.accountDetail.entity.AccountDetail;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;

/**
 * @Package com.ebuy.tax.user.api.accountDetail.dao
 * @author hdq
 * @Date 2018-09-05 09:57:24
 * @Description
 */
public class AccountDetailBizServiceImpl implements AccountDetailBizService{

    private static final Logger logger = LoggerFactory.getLogger(AccountDetailBizServiceImpl.class);

    private AccountDetailDmlService accountDetailDmlService;

    private AccountDetailQueryService accountDetailQueryService;

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      List<AccountDetail>
     * @Description 查询列表
     * @date        2018-09-05 09:57:24
     */
    public List<AccountDetail> queryList(AccountDetail accountDetail){
        return accountDetailQueryService.queryAllAccountDetail(accountDetail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-05 09:57:24
     */
    public PageResult queryListPage(AccountDetail accountDetail, Integer pageNo, Integer  pageSize){
        //查询分页列表总数
        int count = accountDetailQueryService.queryCountAccountDetail(accountDetail);
        List<AccountDetail> list = new LinkedList<AccountDetail>();
        if(count > 0) {
            list = accountDetailQueryService.queryListForPageAccountDetail(accountDetail,pageNo,pageSize);
        }
        return  new PageResult(list,(long)count);
    }

    /**
     * @author      hdq
     * @see         [id]
     * @return      AccountDetail
     * @Description 按id查询
     * @date        2018-09-05 09:57:24
     */
    public AccountDetail queryById(BigInteger id){
        return accountDetailQueryService.queryById(id);
    }

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<AccountDetail>
     * @Description 按ids查询列表
     * @date        2018-09-05 09:57:24
     */
    public List<AccountDetail> queryByIds(List<BigInteger> ids){
        return accountDetailQueryService.queryByIds(ids);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      AccountDetail
     * @Description 根据entity查询一条记录
     * @date        2018-09-05 09:57:24
     */
    public AccountDetail queryByParam(AccountDetail accountDetail){
        return accountDetailQueryService.queryEntityByAccountDetailEntity(accountDetail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return
     * @Description 添加
     * @date        2018-09-05 09:57:24
     */
    public void insert(AccountDetail accountDetail){
        accountDetailDmlService.insertAccountDetail(accountDetail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return
     * @Description 添加or更新
     * @date        2018-09-05 09:57:24
     */
    public void insertOrUpdate(AccountDetail accountDetail){
        accountDetailDmlService.insertOrUpdateAccountDetail(accountDetail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return
     * @Description 更新
     * @date        2018-09-05 09:57:24
     */
    public void update(AccountDetail accountDetail){
        accountDetailDmlService.updateAccountDetail(accountDetail);
    }


}

