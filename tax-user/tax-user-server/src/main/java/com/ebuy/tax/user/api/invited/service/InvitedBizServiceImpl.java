package com.ebuy.tax.user.api.invited.service;

import com.ebuy.tax.user.api.invited.entity.Invited;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;

/**
 * @Package com.ebuy.tax.user.api.invited.dao
 * @author hdq
 * @Date 2018-09-07 15:01:17
 * @Description
 */
@Slf4j
@Service(value = "invitedBizService")
public class InvitedBizServiceImpl implements InvitedBizService {

    @Resource(name = "invitedDmlService")
    private InvitedDmlService invitedDmlService;

    @Resource(name = "invitedQueryService")
    private InvitedQueryService invitedQueryService;

    /**
     * @author hdq
     * @see         [Invited]
     * @return List<Invited>
     * @Description 查询列表
     * @date        2018-09-07 15:01:17
     */
    @Override
    public List<Invited> queryList(Invited invited) {
        return invitedQueryService.queryAllInvited(invited);
    }

    /**
     * @author hdq
     * @see         [Invited] [pageNo] [pageSize]
     * @return PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-07 15:01:17
     */
    @Override
    public PageResult queryListPage(Invited invited, Integer pageNo, Integer pageSize) {
        //查询分页列表总数
        int count = invitedQueryService.queryCountInvited(invited);
        List<Invited> list = new LinkedList<Invited>();
        if (count > 0) {
            list = invitedQueryService.queryListForPageInvited(invited, pageNo, pageSize);
        }
        return new PageResult(list, (long) count);
    }

    /**
     * @author hdq
     * @see         [id]
     * @return      Invited
     * @Description 按id查询
     * @date        2018-09-07 15:01:17
     */
    @Override
    public Invited queryById(BigInteger id) {
        return invitedQueryService.queryById(id);
    }

    /**
     * @author hdq
     * @see         [ids]
     * @return List<Invited>
     * @Description 按ids查询列表
     * @date        2018-09-07 15:01:17
     */
    @Override
    public List<Invited> queryByIds(List<BigInteger> ids) {
        return invitedQueryService.queryByIds(ids);
    }

    /**
     * @author hdq
     * @see         [Invited]
     * @return      Invited
     * @Description 根据entity查询一条记录
     * @date        2018-09-07 15:01:17
     */
    @Override
    public Invited queryByParam(Invited invited) {
        return invitedQueryService.queryEntityByInvitedEntity(invited);
    }

    /**
     * @author hdq
     * @see         [Invited]
     * @return
     * @Description 添加
     * @date        2018-09-07 15:01:17
     */
    @Override
    public void insert(Invited invited) {
            invitedDmlService.insertInvited(invited);
    }

    /**
     * @author hdq
     * @see         [Invited]
     * @return
     * @Description 添加or更新
     * @date        2018-09-07 15:01:17
     */
    @Override
    public void insertOrUpdate(Invited invited) {
            invitedDmlService.insertOrUpdateInvited(invited);
    }

    /**
     * @author hdq
     * @see         [Invited]
     * @return
     * @Description 更新
     * @date        2018-09-07 15:01:17
     */
    @Override
    public void update(Invited invited) {
            invitedDmlService.updateInvited(invited);
    }


}

