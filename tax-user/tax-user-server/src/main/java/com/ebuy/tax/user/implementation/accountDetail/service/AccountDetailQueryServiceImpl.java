package com.ebuy.tax.user.implementation.accountDetail.service;

import com.ebuy.tax.user.api.accountDetail.entity.AccountDetail;
import com.ebuy.tax.user.api.accountDetail.dao.IAccountDetailDao;
import com.ebuy.tax.user.api.accountDetail.service.AccountDetailQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.accountDetail.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
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
     * @date        2018-09-05 18:26:55
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
     * @date        2018-09-05 18:26:55
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
     * @date        2018-09-05 18:26:55
     */
    @Override
    public int queryCountAccountDetail(AccountDetail accountDetail){
        return accountDetailDao.queryCount(accountDetail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-05 18:26:55
     */
    @Override
    public List<AccountDetail> queryAllAccountDetail(AccountDetail accountDetail){
        return accountDetailDao.queryList(accountDetail);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 18:26:55
     */
    @Override
    public List<AccountDetail> queryListForPageAccountDetail(AccountDetail accountDetail,Integer pageNo,Integer pageSize){
        return accountDetailDao.queryListForPage(accountDetail,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [AccountDetail]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 18:26:55
     */
    @Override
    public AccountDetail queryEntityByAccountDetailEntity(AccountDetail accountDetail){
        return accountDetailDao.queryEntityByAccountDetailEntity(accountDetail);
    }


}

