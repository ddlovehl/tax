package com.ebuy.tax.user.api.account_detail.service;

import com.ebuy.tax.user.api.account_detail.entity.AccountDetail;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;

/**
 * @Package com.ebuy.tax.user.api.account_detail.dao
 * @author hdq
 * @Date 2018-09-04 21:44:21
 * @Description
 */
public class AccountDetailBizServiceImpl implements AccountDetailBizService{

    private static final Logger logger = LoggerFactory.getLogger(AccountDetailBizServiceImpl.class);

    private AccountDetailDmlService account_detailDmlService;

    private AccountDetailQueryService account_detailQueryService;

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      List<AccountDetail>
     * @Description 查询列表
     * @date        2018-09-04 21:44:21
     */
    public List<AccountDetail> queryList(AccountDetail account_detail){
        return account_detailQueryService.queryAllAccountDetail(account_detail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-04 21:44:21
     */
    public PageResult queryListPage(AccountDetail account_detail, Integer pageNo, Integer  pageSize){
        //查询分页列表总数
        int count = account_detailQueryService.queryCountAccountDetail(account_detail);
        List<AccountDetail> list = new LinkedList<AccountDetail>();
        if(count > 0) {
            list = account_detailQueryService.queryListForPageAccountDetail(account_detail,pageNo,pageSize);
        }
        return  new PageResult(list,(long)count);
    }

    /**
     * @author      hdq
     * @see         [id]
     * @return      AccountDetail
     * @Description 按id查询
     * @date        2018-09-04 21:44:21
     */
    public AccountDetail queryById(BigInteger id){
        return account_detailQueryService.queryById(id);
    }

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<AccountDetail>
     * @Description 按ids查询列表
     * @date        2018-09-04 21:44:21
     */
    public List<AccountDetail> queryByIds(List<BigInteger> ids){
        return account_detailQueryService.queryByIds(ids);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      AccountDetail
     * @Description 根据entity查询一条记录
     * @date        2018-09-04 21:44:21
     */
    public AccountDetail queryByParam(AccountDetail account_detail){
        return account_detailQueryService.queryEntityByAccountDetailEntity(account_detail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return
     * @Description 添加
     * @date        2018-09-04 21:44:21
     */
    public void insert(AccountDetail account_detail){
        account_detailDmlService.insertAccountDetail(account_detail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return
     * @Description 添加or更新
     * @date        2018-09-04 21:44:21
     */
    public void insertOrUpdate(AccountDetail account_detail){
        account_detailDmlService.insertOrUpdateAccountDetail(account_detail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return
     * @Description 更新
     * @date        2018-09-04 21:44:21
     */
    public void update(AccountDetail account_detail){
        account_detailDmlService.updateAccountDetail(account_detail);
    }


}

