package com.ebuy.tax.user.implementation.sequence.dao;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.tax.user.api.sequence.dao.ISequenceDao;
import com.ebuy.tax.user.api.sequence.entity.Sequence;
import com.ebuy.tax.user.api.sql.entity.AdapterSql;
import com.ebuy.tax.user.implementation.sequence.mapper.SequenceMapper;

import lombok.extern.slf4j.Slf4j;
/**
 * @Project new_project
 * @Package com.ebuy.tax.user.implementation.sequence.dao
 * @author hdq
 * @Date 2018-09-08 16:57:34
 * @Description
 */
@Slf4j
@Repository(value = "sequenceDao")

public class SequenceDaoImpl extends ServiceImpl<SequenceMapper, Sequence> implements ISequenceDao {@Override
	
	public Sequence select(AdapterSql sql) {
		return baseMapper.select(sql);
	}

       
}
