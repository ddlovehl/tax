package com.ebuy.tax.user.api.role.dao;

import com.ebuy.tax.user.api.role.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Project new_project
 * @Package com.ebuy.tax.user.api.role.dao
 * @Author hdq
 * @Date 2018-09-07 15:01:18
 * @Description IroleDao
 */
public interface IRoleDao extends IService<Role> {

    /**
     * @author      hdq
     * @see         [Role]
     * @return      java.lang.Long
     * @Description 查询列表总数
     * @date        2018-09-07 15:01:18
     */
    public int queryCount(Role role);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      List<Role>
     * @Description 查询列表
     * @date        2018-09-07 15:01:18
     */
    public List<Role> queryList(Role role);

    /**
     * @author      hdq
     * @see         List<Role>
     * @return      java.lang.Long
     * @Description 查询列表
     * @date        2018-09-07 15:01:18
     */
    public List<Role>  queryListForPage(Role role,Integer pageNo,Integer pageSize);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      List<Role>
     * @Description 查询列表
     * @date        2018-09-07 15:01:18
     */
    public Role queryEntityByRoleEntity(Role role);
}
