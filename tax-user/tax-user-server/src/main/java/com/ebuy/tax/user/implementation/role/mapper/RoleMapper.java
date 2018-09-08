package com.ebuy.tax.user.implementation.role.mapper;

import com.ebuy.tax.user.api.role.entity.Role;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.role.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description è§’è‰²è¡¨ Mapper 接口
 */
public interface RoleMapper extends SuperMapper<Role> {

    int queryCount(Role role);

    List<Role> queryList(Role role);

    List<Role> queryListForPage( @Param("entity")Role role, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    Role queryEntityByRoleEntity(Role role);
}
