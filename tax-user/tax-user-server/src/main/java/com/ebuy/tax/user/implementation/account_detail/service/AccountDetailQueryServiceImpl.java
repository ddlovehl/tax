package com.ebuy.tax.user.implementation.account_detail.service;

import com.ebuy.tax.user.api.account_detail.dao.IAccountDetailDao;
import com.ebuy.tax.user.api.account_detail.entity.AccountDetail;
import com.ebuy.tax.user.api.account_detail.service.AccountDetailQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.account_detail.dao
 * @author hdq
 * @Date 2018-09-04 21:44:21
 * @Description  查询服务
 */
@CacheConfig(cacheNames = {"AccountDetailCache"})
public class AccountDetailQueryServiceImpl implements AccountDetailQueryService{

    @Resource(name = "accountDetailDao")
    private IAccountDetailDao accountDetailDao;

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-04 21:44:21
     */
    @Override
    public AccountDetail queryById(BigInteger id){
        return accountDetailDao.selectById(id);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-04 21:44:21
     */
        @Override
    public List<AccountDetail> queryByIds(List<BigInteger> ids){
        return (List<AccountDetail>)accountDetailDao.selectBatchIds(ids);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-04 21:44:21
     */
    @Override
    public int queryCountAccountDetail(AccountDetail account_detail){
        return accountDetailDao.queryCount(account_detail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-04 21:44:21
     */
    @Override
    public List<AccountDetail> queryAllAccountDetail(AccountDetail account_detail){
        return accountDetailDao.queryList(account_detail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:44:21
     */
    @Override
    public List<AccountDetail> queryListForPageAccountDetail(AccountDetail account_detail,Integer pageNo,Integer pageSize){
        return accountDetailDao.queryListForPage(account_detail,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:44:21
     */
    @Override
    public AccountDetail queryEntityByAccountDetailEntity(AccountDetail account_detail){
        return accountDetailDao.queryEntityByAccountDetailEntity(account_detail);
    }


}

