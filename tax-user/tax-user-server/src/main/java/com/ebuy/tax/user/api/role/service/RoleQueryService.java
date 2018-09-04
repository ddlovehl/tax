package com.ebuy.tax.user.api.role.service;

import com.ebuy.tax.user.api.role.entity.Role;


import  java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.role.dao
 * @author hdq
 * @Date 2018-09-04 21:44:36
 * @Description è§’è‰²è¡¨ 查询服务
 */
public interface RoleQueryService{

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 根据id查询
     * @date        2018-09-04 21:44:36
     */
    public Role queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 根据ids查询列表
     * @date        2018-09-04 21:44:36
     */
    public List<Role> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 查询列表总数
     * @date        2018-09-04 21:44:36
     */
    public int queryCountRole(Role role);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 查询列表
     * @date        2018-09-04 21:44:36
     */
    public List<Role> queryAllRole(Role role);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:44:36
     */
    public List<Role> queryListForPageRole(Role role,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      boolean
     * @Description 查询列表分页
     * @date        2018-09-04 21:44:36
     */
    public Role queryEntityByRoleEntity(Role role);

}

