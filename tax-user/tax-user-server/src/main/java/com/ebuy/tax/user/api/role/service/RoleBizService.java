package com.ebuy.tax.user.api.role.service;

import com.ebuy.tax.user.api.role.entity.Role;

import com.ebuy.tax.common.entity.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;

/**
 * @Package com.ebuy.tax.user.api.role.dao
 * @author hdq
 * @Date 2018-09-04 21:44:36
 * @Description
 */
public interface RoleBizService{

    /**
     * @author      hdq
     * @see         [Role]
     * @return      List<Role>
     * @Description 查询列表
     * @date        2018-09-04 21:44:36
     */
    public List<Role> queryList(Role role);

    /**
     * @author      hdq
     * @see         [Role] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-04 21:44:36
     */
    public PageResult queryListPage(Role role, Integer pageNo, Integer  pageSize);

    /**
     * @author      hdq
     * @see         [id]
     * @return      Role
     * @Description 按id查询
     * @date        2018-09-04 21:44:36
     */
    public Role queryById(BigInteger id);

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<Role>
     * @Description 按ids查询列表
     * @date        2018-09-04 21:44:36
     */
    public List<Role> queryByIds(List<BigInteger> ids);

    /**
     * @author      hdq
     * @see         [Role]
     * @return      Role
     * @Description 根据entity查询一条记录
     * @date        2018-09-04 21:44:36
     */
    public Role queryByParam(Role role);

    /**
     * @author      hdq
     * @see         [Role]
     * @return
     * @Description 添加
     * @date        2018-09-04 21:44:36
     */
    public void insert(Role role);

    /**
     * @author      hdq
     * @see         [Role]
     * @return
     * @Description 添加or更新
     * @date        2018-09-04 21:44:36
     */
    public void insertOrUpdate(Role role);

    /**
     * @author      hdq
     * @see         [Role]
     * @return
     * @Description 更新
     * @date        2018-09-04 21:44:36
     */
    public void update(Role role);


}

