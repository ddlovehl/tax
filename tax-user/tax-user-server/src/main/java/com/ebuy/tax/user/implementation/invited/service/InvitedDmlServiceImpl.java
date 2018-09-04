package com.ebuy.tax.user.implementation.invited.service;

import com.ebuy.tax.user.api.invited.entity.Invited;
import com.ebuy.tax.user.api.user.dao.IUserDao;
import com.ebuy.tax.user.api.invited.service.InvitedDmlService;
import com.ebuy.tax.common.constants.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.math.BigInteger;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import com.ebuy.tax.common.exception.SystemException;

/**
 * @Package com.ebuy.tax.user.implementation.invited.dao
 * @author hdq
 * @Date 2018-09-04 21:45:10
 * @Description è¢«é‚€è¯·è¡¨ 操作服务
 */
@CacheConfig(cacheNames = {"InvitedCache}"})
public class InvitedDmlServiceImpl implements InvitedDmlService {

    private static final Logger log = LoggerFactory.getLogger(InvitedDmlServiceImpl.class);

    private IInvitedDao invitedDao;

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-04 21:45:10
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertInvited(Invited invited){
        boolean flag = true;
        try{
            flag = invitedDao.insert(invited);
        } catch (Exception e){
            log.error("InvitedDmlServiceImpl-insertInvited添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-04 21:45:10
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertInviteds(List<Invited> list){
        boolean flag = true;
        try{
            flag = invitedDao.insertBatch(list);
        } catch (Exception e){
            log.error("InvitedDmlServiceImpl-insertInviteds添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-04 21:45:10
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertOrUpdateInvited(Invited invited){
        boolean flag = true;
        try{
        //存在更新记录，否插入一条记录
        flag = invitedDao.insertOrUpdate(invited);
        } catch (Exception e){
           log.info("InvitedDmlServiceImpl-update更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:45:10
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateInvited(Invited invited){
        boolean flag = true;
        try{
            flag = invitedDao.updateById(invited);
        } catch (Exception e){
            log.error("InvitedDmlServiceImpl-updateInvited更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:45:10
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateInviteds(List<Invited> list){
        boolean flag = true;
        try{
            flag = invitedDao.updateBatchById(list);
        } catch (Exception e){
            log.error("InvitedDmlServiceImpl-updateInviteds更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-04 21:45:10
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteInvited(BigInteger id){
        boolean flag = true;
        try{
            flag = invitedDao.deleteById(Long.parseLong(id.toString()));
        } catch (Exception e){
            log.error("InvitedDmlServiceImpl-deleteInvited删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "删除用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-04 21:45:10
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteInviteds(List<BigInteger> ids){
        boolean flag = true;
        try{
            flag = invitedDao.deleteBatchIds(ids);
        } catch (Exception e){
            log.error("InvitedDmlServiceImpl-deleteInviteds删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量删除用户信息失败");
        }
        return flag;
    }
}

