package com.ebuy.tax.user.implementation.user_account.service;

import com.ebuy.tax.user.api.user_account.dao.IUserAccountDao;
import com.ebuy.tax.user.api.user_account.entity.UserAccount;
import com.ebuy.tax.user.api.user.dao.IUserDao;
import com.ebuy.tax.user.api.user_account.service.UserAccountQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.user_account.dao
 * @author hdq
 * @Date 2018-09-04 21:43:56
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
     * @date        2018-09-04 21:43:56
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
     * @date        2018-09-04 21:43:56
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
     * @date        2018-09-04 21:43:56
     */
    @Override
    public int queryCountUserAccount(UserAccount user_account){
        return userAccountDao.queryCount(user_account);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-04 21:43:56
     */
    @Override
    public List<UserAccount> queryAllUserAccount(UserAccount user_account){
        return userAccountDao.queryList(user_account);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:43:56
     */
    @Override
    public List<UserAccount> queryListForPageUserAccount(UserAccount user_account,Integer pageNo,Integer pageSize){
        return userAccountDao.queryListForPage(user_account,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:43:56
     */
    @Override
    public UserAccount queryEntityByUserAccountEntity(UserAccount user_account){
        return userAccountDao.queryEntityByUserAccountEntity(user_account);
    }


}

