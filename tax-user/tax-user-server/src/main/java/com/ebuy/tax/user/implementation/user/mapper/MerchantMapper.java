package com.ebuy.tax.user.implementation.user.mapper;

import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.user.dao
 * @author hdq
 * @Date 2018-09-04 21:37:37
 * @Description  Mapper 接口
 */
public interface MerchantMapper extends SuperMapper<Merchant> {

    int queryCount(Merchant user);

    List<Merchant> queryList(Merchant user);

    List<Merchant> queryListForPage( @Param("entity")Merchant user, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    Merchant queryEntityByMerchantEntity(Merchant user);
}
