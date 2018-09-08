package com.ebuy.tax.user.api.role.service;

import com.ebuy.tax.user.api.role.entity.Role;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.role.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description Role操作服务
 */
public interface RoleDmlService{

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 添加信息
     * @date        2018-09-07 15:01:18
     */
    public boolean insertRole(Role role);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 批量增加
     * @date        2018-09-07 15:01:18
     */
    public boolean insertRoles(List<Role> list);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 增加or更新
     * @date        2018-09-07 15:01:18
     */
    public boolean insertOrUpdateRole(Role role);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-07 15:01:18
     */
    public boolean updateRole(Role role);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 更新
     * @date        2018-09-07 15:01:18
     */
    public boolean updateRoles(List<Role> list);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 删除
     * @date        2018-09-07 15:01:18
     */
    public boolean deleteRole(BigInteger id);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 根据id批量删除
     * @date        2018-09-07 15:01:18
     */
    public boolean deleteRoles(List<BigInteger> ids);
}

