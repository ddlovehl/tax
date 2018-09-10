package com.ebuy.tax.user.implementation.sequence.mapper;

import com.ebuy.tax.common.entity.SuperMapper;
import com.ebuy.tax.user.api.sequence.entity.Sequence;
import com.ebuy.tax.user.api.sql.entity.AdapterSql;
/**
* @author dd
* @date 2018年9月8日
 */
public interface SequenceMapper extends SuperMapper<Sequence> {

	public Sequence select(AdapterSql sql);
}
