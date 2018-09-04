package com.ebuy.tax.user.api.invited.service;

import com.ebuy.tax.user.api.invited.entity.Invited;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.invited.dao
 * @author hdq
 * @Date 2018-09-04 21:45:09
 * @Description Invited操作服务
 */
public interface InvitedDmlService{

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-04 21:45:09
     */
    public boolean insertInvited(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-04 21:45:09
     */
    public boolean insertInviteds(List<Invited> list);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-04 21:45:09
     */
    public boolean insertOrUpdateInvited(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:45:09
     */
    public boolean updateInvited(Invited invited);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-04 21:45:09
     */
    public boolean updateInviteds(List<Invited> list);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-04 21:45:09
     */
    public boolean deleteInvited(BigInteger id);

    /**
     * @author      hdq
     * @see         [Invited]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-04 21:45:09
     */
    public boolean deleteInviteds(List<BigInteger> ids);
}

