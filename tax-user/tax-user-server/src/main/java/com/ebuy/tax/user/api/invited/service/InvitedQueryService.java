package com.ebuy.tax.user.api.invited.service;

import com.ebuy.tax.user.api.invited.entity.Invited;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.invited.dao
 * @author hdq
 * @Date 2018-09-04 21:45:09
 * @Description è¢«é‚€è¯·è¡¨ 查询服务
 */
public interface InvitedQueryService{

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-04 21:45:09
     */
    public Invited queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-04 21:45:09
     */
    public List<Invited> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-04 21:45:09
     */
    public int queryCountInvited(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-04 21:45:09
     */
    public List<Invited> queryAllInvited(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:45:09
     */
    public List<Invited> queryListForPageInvited(Invited invited,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:45:09
     */
    public Invited queryEntityByInvitedEntity(Invited invited);

}

