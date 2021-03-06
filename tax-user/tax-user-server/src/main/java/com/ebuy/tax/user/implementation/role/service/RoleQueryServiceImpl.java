package com.ebuy.tax.user.implementation.role.service;

import com.ebuy.tax.user.api.role.entity.Role;
import com.ebuy.tax.user.api.role.dao.IRoleDao;
import com.ebuy.tax.user.api.role.service.RoleQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.role.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description è§’è‰²è¡¨ 查询服务
 */
@Service(value = "roleQueryService")
@CacheConfig(cacheNames = {"RoleCache"})
public class RoleQueryServiceImpl implements RoleQueryService{

    @Resource(name = "roleDao")
    private IRoleDao roleDao;

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-07 15:01:18
     */
    @Override
    public Role queryById(BigInteger id){
        return roleDao.selectById(id);
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-07 15:01:18
     */
        @Override
    public List<Role> queryByIds(List<BigInteger> ids){
        return (List<Role>)roleDao.selectBatchIds(ids);
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-07 15:01:18
     */
    @Override
    public int queryCountRole(Role role){
        return roleDao.queryCount(role);
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-07 15:01:18
     */
    @Override
    public List<Role> queryAllRole(Role role){
        return roleDao.queryList(role);
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:18
     */
    @Override
    public List<Role> queryListForPageRole(Role role,Integer pageNo,Integer pageSize){
        return roleDao.queryListForPage(role,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-07 15:01:18
     */
    @Override
    public Role queryEntityByRoleEntity(Role role){
        return roleDao.queryEntityByRoleEntity(role);
    }


}

