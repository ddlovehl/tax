package com.ebuy.tax.user.implementation.userAccount.service;

import com.ebuy.tax.user.api.userAccount.entity.UserAccount;
import com.ebuy.tax.user.api.userAccount.dao.IUserAccountDao;
import com.ebuy.tax.user.api.userAccount.service.UserAccountDmlService;
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
 * @Package com.ebuy.tax.user.implementation.userAccount.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description è´¦æˆ·è¡¨ 操作服务
 */
@Service(value = "userAccountDmlService")
@CacheConfig(cacheNames = {"UserAccountCache"})
public class UserAccountDmlServiceImpl implements UserAccountDmlService {

    private static final Logger log = LoggerFactory.getLogger(UserAccountDmlServiceImpl.class);

    @Resource(name = "userAccountDao")
    private IUserAccountDao userAccountDao;

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-07 15:01:18
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertUserAccount(UserAccount userAccount){
        boolean flag = true;
        try{
            flag = userAccountDao.insert(userAccount);
        } catch (Exception e){
            log.error("UserAccountDmlServiceImpl-insertUserAccount添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-07 15:01:18
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertUserAccounts(List<UserAccount> list){
        boolean flag = true;
        try{
            flag = userAccountDao.insertBatch(list);
        } catch (Exception e){
            log.error("UserAccountDmlServiceImpl-insertUserAccounts添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-07 15:01:18
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertOrUpdateUserAccount(UserAccount userAccount){
        boolean flag = true;
        try{
        //存在更新记录，否插入一条记录
        flag = userAccountDao.insertOrUpdate(userAccount);
        } catch (Exception e){
           log.info("UserAccountDmlServiceImpl-update更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-07 15:01:18
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateUserAccount(UserAccount userAccount){
        boolean flag = true;
        try{
            flag = userAccountDao.updateById(userAccount);
        } catch (Exception e){
            log.error("UserAccountDmlServiceImpl-updateUserAccount更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-07 15:01:18
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateUserAccounts(List<UserAccount> list){
        boolean flag = true;
        try{
            flag = userAccountDao.updateBatchById(list);
        } catch (Exception e){
            log.error("UserAccountDmlServiceImpl-updateUserAccounts更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-07 15:01:18
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteUserAccount(BigInteger id){
        boolean flag = true;
        try{
            flag = userAccountDao.deleteById(Long.parseLong(id.toString()));
        } catch (Exception e){
            log.error("UserAccountDmlServiceImpl-deleteUserAccount删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "删除用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-07 15:01:18
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteUserAccounts(List<BigInteger> ids){
        boolean flag = true;
        try{
            flag = userAccountDao.deleteBatchIds(ids);
        } catch (Exception e){
            log.error("UserAccountDmlServiceImpl-deleteUserAccounts删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量删除用户信息失败");
        }
        return flag;
    }
}

