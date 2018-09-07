package com.ebuy.tax.user.api.user.service;

import com.ebuy.tax.user.api.user.entity.User;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.user.dao
 * @author hdq
 * @Date 2018-09-05 18:26:56
 * @Description User操作服务
 */
public interface UserDmlService{

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-05 18:26:56
     */
    public boolean insertUser(User user);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-05 18:26:56
     */
    public boolean insertUsers(List<User> list);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-05 18:26:56
     */
    public boolean insertOrUpdateUser(User user);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:56
     */
    public boolean updateUser(User user);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-05 18:26:56
     */
    public boolean updateUsers(List<User> list);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-05 18:26:56
     */
    public boolean deleteUser(BigInteger id);

    /**
     * @author      hdq
     * @see         [User]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-05 18:26:56
     */
    public boolean deleteUsers(List<BigInteger> ids);
}

