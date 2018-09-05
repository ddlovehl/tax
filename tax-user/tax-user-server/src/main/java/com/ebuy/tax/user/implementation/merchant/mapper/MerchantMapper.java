package com.ebuy.tax.user.implementation.merchant.mapper;

import com.ebuy.tax.user.api.merchant.entity.Merchant;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.merchant.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description  Mapper 接口
 */
public interface MerchantMapper extends SuperMapper<Merchant> {

    int queryCount(Merchant merchant);

    List<Merchant> queryList(Merchant merchant);

    List<Merchant> queryListForPage( @Param("entity")Merchant merchant, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    Merchant queryEntityByMerchantEntity(Merchant merchant);
}
