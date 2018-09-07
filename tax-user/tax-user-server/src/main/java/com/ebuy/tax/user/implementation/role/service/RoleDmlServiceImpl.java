package com.ebuy.tax.user.implementation.role.service;

import com.ebuy.tax.user.api.role.entity.Role;
import com.ebuy.tax.user.api.role.dao.IRoleDao;
import com.ebuy.tax.user.api.role.service.RoleDmlService;
import com.ebuy.tax.common.constants.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.math.BigInteger;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import com.ebuy.tax.common.exception.SystemException;
import javax.annotation.Resource;

/**
 * @Package com.ebuy.tax.user.implementation.role.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description è§’è‰²è¡¨ 操作服务
 */
@CacheConfig(cacheNames = {"RoleCache}"})
public class RoleDmlServiceImpl implements RoleDmlService {

    private static final Logger log = LoggerFactory.getLogger(RoleDmlServiceImpl.class);

    @Resource(name = "roleDao")
    private IRoleDao roleDao;

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertRole(Role role){
        boolean flag = true;
        try{
            flag = roleDao.insert(role);
        } catch (Exception e){
            log.error("RoleDmlServiceImpl-insertRole添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertRoles(List<Role> list){
        boolean flag = true;
        try{
            flag = roleDao.insertBatch(list);
        } catch (Exception e){
            log.error("RoleDmlServiceImpl-insertRoles添加异常", e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "添加用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean insertOrUpdateRole(Role role){
        boolean flag = true;
        try{
        //存在更新记录，否插入一条记录
        flag = roleDao.insertOrUpdate(role);
        } catch (Exception e){
           log.info("RoleDmlServiceImpl-update更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateRole(Role role){
        boolean flag = true;
        try{
            flag = roleDao.updateById(role);
        } catch (Exception e){
            log.error("RoleDmlServiceImpl-updateRole更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean updateRoles(List<Role> list){
        boolean flag = true;
        try{
            flag = roleDao.updateBatchById(list);
        } catch (Exception e){
            log.error("RoleDmlServiceImpl-updateRoles更新异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量更新用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteRole(BigInteger id){
        boolean flag = true;
        try{
            flag = roleDao.deleteById(Long.parseLong(id.toString()));
        } catch (Exception e){
            log.error("RoleDmlServiceImpl-deleteRole删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "删除用户信息失败");
        }
        return flag;
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 18:26:55
     */
    @Override
    @CacheEvict(allEntries = true, beforeInvocation = true)
    public boolean deleteRoles(List<BigInteger> ids){
        boolean flag = true;
        try{
            flag = roleDao.deleteBatchIds(ids);
        } catch (Exception e){
            log.error("RoleDmlServiceImpl-deleteRoles删除异常",e);
            throw new SystemException(ResponseConstant.ERR_CODE.FAIL, "批量删除用户信息失败");
        }
        return flag;
    }
}

