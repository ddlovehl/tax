package com.ebuy.tax.user.api.user.service;

import com.ebuy.tax.user.api.user.entity.User;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.user.dao
 * @author hdq
 * @Date 2018-09-04 19:36:57
 * @Description ç”¨æˆ·è¡¨ 查询服务
 */
public interface UserQueryService{

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-04 19:36:57
     */
    public User queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-04 19:36:57
     */
    public List<User> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-04 19:36:57
     */
    public int queryCountUser(User user);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-04 19:36:57
     */
    public List<User> queryAllUser(User user);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 19:36:57
     */
    public List<User> queryListForPageUser(User user,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 19:36:57
     */
    public User queryEntityByUserEntity(User user);

}

