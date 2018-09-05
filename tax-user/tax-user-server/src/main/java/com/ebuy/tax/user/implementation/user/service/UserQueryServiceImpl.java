package com.ebuy.tax.user.implementation.user.service;

import com.ebuy.tax.user.api.user.entity.User;
import com.ebuy.tax.user.api.user.dao.IUserDao;
import com.ebuy.tax.user.api.user.service.UserQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.user.dao
 * @author hdq
 * @Date 2018-09-05 18:26:56
 * @Description ç”¨æˆ·è¡¨ 查询服务
 */
@CacheConfig(cacheNames = {"UserCache"})
public class UserQueryServiceImpl implements UserQueryService{

    @Resource(name = "userDao")
    private IUserDao userDao;

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-05 18:26:56
     */
    @Override
    public User queryById(BigInteger id){
        return userDao.selectById(id);
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-05 18:26:56
     */
        @Override
    public List<User> queryByIds(List<BigInteger> ids){
        return (List<User>)userDao.selectBatchIds(ids);
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-05 18:26:56
     */
    @Override
    public int queryCountUser(User user){
        return userDao.queryCount(user);
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-05 18:26:56
     */
    @Override
    public List<User> queryAllUser(User user){
        return userDao.queryList(user);
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 18:26:56
     */
    @Override
    public List<User> queryListForPageUser(User user,Integer pageNo,Integer pageSize){
        return userDao.queryListForPage(user,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 18:26:56
     */
    @Override
    public User queryEntityByUserEntity(User user){
        return userDao.queryEntityByUserEntity(user);
    }


}

