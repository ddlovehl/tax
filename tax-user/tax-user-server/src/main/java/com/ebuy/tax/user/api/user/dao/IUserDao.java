package com.ebuy.tax.user.api.user.dao;

import com.ebuy.tax.user.api.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.user.dao
 * @Author hdq
 * @Date 2018-09-05 18:26:56
 * @Description IuserDao
 */
public interface IUserDao extends IService<User> {

    /**
     * @author      hdq
     * @see         [User]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-05 18:26:56
     */
    public int queryCount(User user);

    /**
     * @author      hdq
     * @see         [User]
     * @return      List<User>
     * @Description 查询列表
     * @date        2018-09-05 18:26:56
     */
    public List<User> queryList(User user);

    /**
     * @author      hdq
     * @see         List<User>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-05 18:26:56
     */
    public List<User>  queryListForPage(User user,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [User]
     * @return      List<User>
     * @Description 查询列表
     * @date        2018-09-05 18:26:56
     */
    public User queryEntityByUserEntity(User user);
}
