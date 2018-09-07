package com.ebuy.tax.user.implementation.invited.dao;

import com.ebuy.tax.user.api.invited.entity.Invited;
import com.ebuy.tax.user.implementation.invited.mapper.InvitedMapper;

import com.ebuy.tax.user.api.invited.dao.IInvitedDao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.common.constants.SysConstant;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.invited.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description
 */
@Repository(value = "invitedDao")

public class InvitedDaoImpl extends ServiceImpl<InvitedMapper, Invited> implements IInvitedDao {

        private static final Logger logger = LoggerFactory.getLogger(IInvitedDao.class);

        @Override
        public int queryCount(Invited invited) {
            return baseMapper.queryCount(invited);
        }

        @Override
        public List<Invited> queryList(Invited invited) {
            return baseMapper.queryList(invited);
        }

        @Override
        public List<Invited> queryListForPage(Invited invited, Integer pageNo, Integer pageSize) {
        //返回记录行的偏移量
            Integer start = (pageNo-SysConstant.ONE)*(pageSize);
            return baseMapper.queryListForPage(invited, start, pageSize);
        }

        @Override
            public Invited queryEntityByInvitedEntity(Invited invited) {
            return baseMapper.queryEntityByInvitedEntity(invited);
        }
}
