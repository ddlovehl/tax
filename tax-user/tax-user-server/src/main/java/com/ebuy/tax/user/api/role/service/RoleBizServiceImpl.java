package com.ebuy.tax.user.api.role.service;

import com.ebuy.tax.user.api.role.entity.Role;

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
 * @Package com.ebuy.tax.user.api.role.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description
 */
@Slf4j
@Service(value = "roleBizService")
public class RoleBizServiceImpl implements RoleBizService {

    @Resource(name = "roleDmlService")
    private RoleDmlService roleDmlService;

    @Resource(name = "roleQueryService")
    private RoleQueryService roleQueryService;

    /**
     * @author hdq
     * @see         [Role]
     * @return List<Role>
     * @Description 查询列表
     * @date        2018-09-07 15:01:18
     */
    @Override
    public List<Role> queryList(Role role) {
        return roleQueryService.queryAllRole(role);
    }

    /**
     * @author hdq
     * @see         [Role] [pageNo] [pageSize]
     * @return PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-07 15:01:18
     */
    @Override
    public PageResult queryListPage(Role role, Integer pageNo, Integer pageSize) {
        //查询分页列表总数
        int count = roleQueryService.queryCountRole(role);
        List<Role> list = new LinkedList<Role>();
        if (count > 0) {
            list = roleQueryService.queryListForPageRole(role, pageNo, pageSize);
        }
        return new PageResult(list, (long) count);
    }

    /**
     * @author hdq
     * @see         [id]
     * @return      Role
     * @Description 按id查询
     * @date        2018-09-07 15:01:18
     */
    @Override
    public Role queryById(BigInteger id) {
        return roleQueryService.queryById(id);
    }

    /**
     * @author hdq
     * @see         [ids]
     * @return List<Role>
     * @Description 按ids查询列表
     * @date        2018-09-07 15:01:18
     */
    @Override
    public List<Role> queryByIds(List<BigInteger> ids) {
        return roleQueryService.queryByIds(ids);
    }

    /**
     * @author hdq
     * @see         [Role]
     * @return      Role
     * @Description 根据entity查询一条记录
     * @date        2018-09-07 15:01:18
     */
    @Override
    public Role queryByParam(Role role) {
        return roleQueryService.queryEntityByRoleEntity(role);
    }

    /**
     * @author hdq
     * @see         [Role]
     * @return
     * @Description 添加
     * @date        2018-09-07 15:01:18
     */
    @Override
    public void insert(Role role) {
            roleDmlService.insertRole(role);
    }

    /**
     * @author hdq
     * @see         [Role]
     * @return
     * @Description 添加or更新
     * @date        2018-09-07 15:01:18
     */
    @Override
    public void insertOrUpdate(Role role) {
            roleDmlService.insertOrUpdateRole(role);
    }

    /**
     * @author hdq
     * @see         [Role]
     * @return
     * @Description 更新
     * @date        2018-09-07 15:01:18
     */
    @Override
    public void update(Role role) {
            roleDmlService.updateRole(role);
    }


}

