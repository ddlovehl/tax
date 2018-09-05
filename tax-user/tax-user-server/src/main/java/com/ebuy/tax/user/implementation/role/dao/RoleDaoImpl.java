package com.ebuy.tax.user.implementation.role.dao;

import com.ebuy.tax.user.api.role.entity.Role;
import com.ebuy.tax.user.implementation.role.mapper.RoleMapper;

import com.ebuy.tax.user.api.role.dao.IRoleDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.role.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description
 */
@Repository(value = "roleDao")

public class RoleDaoImpl extends ServiceImpl<RoleMapper, Role> implements IRoleDao {

        private static final Logger logger = LoggerFactory.getLogger(IRoleDao.class);

        @Override
        public int queryCount(Role role) {
            return baseMapper.queryCount(role);
        }

        @Override
        public List<Role> queryList(Role role) {
            return baseMapper.queryList(role);
        }

        @Override
        public List<Role> queryListForPage(Role role, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(role, start, pageSize);
        }

        @Override
            public Role queryEntityByRoleEntity(Role role) {
            return baseMapper.queryEntityByRoleEntity(role);
        }
}
