package com.ebuy.tax.user.api.user.service;

import com.ebuy.tax.user.api.user.entity.User;

import com.ebuy.tax.common.entity.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.user.dao
 * @author hdq
 * @Date 2018-09-04 19:36:57
 * @Description
 */
public interface UserBizService{

    /**
     * @author      hdq
     * @see         [User]
     * @return      List<User>
     * @Description 查询列表
     * @date        2018-09-04 19:36:57
     */
    public List<User> queryList(User user);

    /**
     * @author      hdq
     * @see         [User] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-04 19:36:57
     */
    public PageResult queryListPage(User user, Integer pageNo, Integer  pageSize);

    /**
     * @author      hdq
     * @see         [id]
     * @return      User
     * @Description 按id查询
     * @date        2018-09-04 19:36:57
     */
    public User queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<User>
     * @Description 按ids查询列表
     * @date        2018-09-04 19:36:57
     */
    public List<User> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [User]
     * @return      User
     * @Description 根据entity查询一条记录
     * @date        2018-09-04 19:36:57
     */
    public User queryByParam(User user);

    /**
     * @author      hdq
     * @see         [User]
     * @return
     * @Description 添加
     * @date        2018-09-04 19:36:57
     */
    public void insert(User user);

    /**
     * @author      hdq
     * @see         [User]
     * @return
     * @Description 添加or更新
     * @date        2018-09-04 19:36:57
     */
    public void insertOrUpdate(User user);

    /**
     * @author      hdq
     * @see         [User]
     * @return
     * @Description 更新
     * @date        2018-09-04 19:36:57
     */
    public void update(User user);


}

