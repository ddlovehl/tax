package com.ebuy.tax.user.implementation.user.service;

import com.ebuy.tax.user.api.user.entity.User;
import com.ebuy.tax.user.api.user.dao.IUserDao;
import com.ebuy.tax.user.api.user.service.UserDmlService;
import com.ebuy.tax.common.constants.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.math.BigInteger;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ebuy.tax.common.exception.SystemException;
import javax.annotation.Resource;

/**
 * @Package com.ebuy.tax.user.implementation.user.dao
 * @author hdq
 * @Date 2018-09-05 18:26:56
 * @Description ç”¨æˆ·è¡¨ 操作服务
 */
@Service(value = "userDmlService")
@CacheConfig(cacheNames = {"UserCache}"})
public class UserDmlServiceImpl implements UserDmlService {

    private static final Logger log = LoggerFactory.getLogger(UserDmlServiceImpl.class);

    @Resource(name = "userDao")
    private IUserDao userDao;

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 18:26:56
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertUser(User user){
        boolean flag = true;
        try{
            flag = userDao.insert(user);
        } catch (Exception e){
            log.error("UserDmlServiceImpl-insertUser添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 18:26:56
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertUsers(List<User> list){
        boolean flag = true;
        try{
            flag = userDao.insertBatch(list);
        } catch (Exception e){
            log.error("UserDmlServiceImpl-insertUsers添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 18:26:56
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertOrUpdateUser(User user){
        boolean flag = true;
        try{
        //存在更新记录，否插入一条记录
        flag = userDao.insertOrUpdate(user);
        } catch (Exception e){
           log.info("UserDmlServiceImpl-update更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:56
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateUser(User user){
        boolean flag = true;
        try{
            flag = userDao.updateById(user);
        } catch (Exception e){
            log.error("UserDmlServiceImpl-updateUser更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:56
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateUsers(List<User> list){
        boolean flag = true;
        try{
            flag = userDao.updateBatchById(list);
        } catch (Exception e){
            log.error("UserDmlServiceImpl-updateUsers更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 18:26:56
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteUser(BigInteger id){
        boolean flag = true;
        try{
            flag = userDao.deleteById(Long.parseLong(id.toString()));
        } catch (Exception e){
            log.error("UserDmlServiceImpl-deleteUser删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "删除用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 18:26:56
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteUsers(List<BigInteger> ids){
        boolean flag = true;
        try{
            flag = userDao.deleteBatchIds(ids);
        } catch (Exception e){
            log.error("UserDmlServiceImpl-deleteUsers删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量删除用户信息失败");
        }
        return flag;
    }
}

