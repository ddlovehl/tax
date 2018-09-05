package com.ebuy.tax.user.api.invited.dao;

import com.ebuy.tax.user.api.invited.entity.Invited;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.invited.dao
 * @Author hdq
 * @Date 2018-09-05 09:35:19
 * @Description IinvitedDao
 */
public interface IInvitedDao extends IService<Invited> {

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-05 09:35:19
     */
    public int queryCount(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      List<Invited>
     * @Description 查询列表
     * @date        2018-09-05 09:35:19
     */
    public List<Invited> queryList(Invited invited);

    /**
     * @author      hdq
     * @see         List<Invited>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-05 09:35:19
     */
    public List<Invited>  queryListForPage(Invited invited,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      List<Invited>
     * @Description 查询列表
     * @date        2018-09-05 09:35:19
     */
    public Invited queryEntityByInvitedEntity(Invited invited);
}
