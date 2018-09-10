package com.ebuy.tax.user.api.invited.service;

import com.ebuy.tax.user.api.invited.entity.Invited;

import com.ebuy.tax.common.entity.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.invited.dao
 * @author hdq
 * @Date 2018-09-07 15:01:17
 * @Description
 */
public interface InvitedBizService{

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      List<Invited>
     * @Description 查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<Invited> queryList(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-07 15:01:17
     */
    public PageResult queryListPage(Invited invited, Integer pageNo, Integer  pageSize);

    /**
     * @author      hdq
     * @see         [id]
     * @return      Invited
     * @Description 按id查询
     * @date        2018-09-07 15:01:17
     */
    public Invited queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<Invited>
     * @Description 按ids查询列表
     * @date        2018-09-07 15:01:17
     */
    public List<Invited> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      Invited
     * @Description 根据entity查询一条记录
     * @date        2018-09-07 15:01:17
     */
    public Invited queryByParam(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return
     * @Description 添加
     * @date        2018-09-07 15:01:17
     */
    public void insert(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return
     * @Description 添加or更新
     * @date        2018-09-07 15:01:17
     */
    public void insertOrUpdate(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return
     * @Description 更新
     * @date        2018-09-07 15:01:17
     */
    public void update(Invited invited);


}

