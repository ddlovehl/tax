package com.ebuy.tax.user.implementation.invited.service;

import com.ebuy.tax.user.api.invited.entity.Invited;
import com.ebuy.tax.user.api.invited.dao.IInvitedDao;
import com.ebuy.tax.user.api.invited.service.InvitedQueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.implementation.invited.dao
 * @author hdq
 * @Date 2018-09-05 09:57:24
 * @Description è¢«é‚€è¯·è¡¨ 查询服务
 */
@CacheConfig(cacheNames = {"InvitedCache"})
public class InvitedQueryServiceImpl implements InvitedQueryService{

    @Resource(name = "invitedDao")
    private IInvitedDao invitedDao;

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-05 09:57:24
     */
    @Override
    public Invited queryById(BigInteger id){
        return invitedDao.selectById(id);
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-05 09:57:24
     */
        @Override
    public List<Invited> queryByIds(List<BigInteger> ids){
        return (List<Invited>)invitedDao.selectBatchIds(ids);
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-05 09:57:24
     */
    @Override
    public int queryCountInvited(Invited invited){
        return invitedDao.queryCount(invited);
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-05 09:57:24
     */
    @Override
    public List<Invited> queryAllInvited(Invited invited){
        return invitedDao.queryList(invited);
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 09:57:24
     */
    @Override
    public List<Invited> queryListForPageInvited(Invited invited,Integer pageNo,Integer pageSize){
        return invitedDao.queryListForPage(invited,pageNo,pageSize);
    }

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-05 09:57:24
     */
    @Override
    public Invited queryEntityByInvitedEntity(Invited invited){
        return invitedDao.queryEntityByInvitedEntity(invited);
    }


}

