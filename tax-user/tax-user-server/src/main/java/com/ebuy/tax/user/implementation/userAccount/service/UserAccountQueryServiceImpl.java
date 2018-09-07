package com.ebuy.tax.user.implementation.userAccount.service;

import com.ebuy.tax.user.api.userAccount.entity.UserAccount;
import com.ebuy.tax.user.api.userAccount.dao.IUserAccountDao;
import com.ebuy.tax.user.api.userAccount.service.UserAccountQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.userAccount.dao
 * @author hdq
 * @Date 2018-09-05 18:26:56
 * @Description è´¦æˆ·è¡¨ 查询服务
 */
@CacheConfig(cacheNames = {"UserAccountCache"})
public class UserAccountQueryServiceImpl implements UserAccountQueryService{

    @Resource(name = "userAccountDao")
    private IUserAccountDao userAccountDao;

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-05 18:26:56
     */
    @Override
    public UserAccount queryById(BigInteger id){
        return userAccountDao.selectById(id);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-05 18:26:56
     */
        @Override
    public List<UserAccount> queryByIds(List<BigInteger> ids){
        return (List<UserAccount>)userAccountDao.selectBatchIds(ids);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-05 18:26:56
     */
    @Override
    public int queryCountUserAccount(UserAccount userAccount){
        return userAccountDao.queryCount(userAccount);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-05 18:26:56
     */
    @Override
    public List<UserAccount> queryAllUserAccount(UserAccount userAccount){
        return userAccountDao.queryList(userAccount);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 18:26:56
     */
    @Override
    public List<UserAccount> queryListForPageUserAccount(UserAccount userAccount,Integer pageNo,Integer pageSize){
        return userAccountDao.queryListForPage(userAccount,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 18:26:56
     */
    @Override
    public UserAccount queryEntityByUserAccountEntity(UserAccount userAccount){
        return userAccountDao.queryEntityByUserAccountEntity(userAccount);
    }


}

