package com.ebuy.tax.user.api.sequence.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ebuy.tax.user.api.sequence.entity.Sequence;
import com.ebuy.tax.user.api.sql.entity.AdapterSql;

/**
 * 
* @author dd
* @date 2018年9月8日
 */
public interface ISequenceDao extends IService<Sequence> {

    public Sequence select(AdapterSql sql);
}
