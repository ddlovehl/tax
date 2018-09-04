package com.ebuy.tax.user.implementation.account_detail.mapper;

import com.ebuy.tax.user.api.account_detail.entity.AccountDetail;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.account_detail.dao
 * @author hdq
 * @Date 2018-09-04 21:44:21
 * @Description  Mapper 接口
 */
public interface AccountDetailMapper extends SuperMapper<AccountDetail> {

    int queryCount(AccountDetail account_detail);

    List<AccountDetail> queryList(AccountDetail account_detail);

    List<AccountDetail> queryListForPage( @Param("entity")AccountDetail account_detail, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    AccountDetail queryEntityByAccountDetailEntity(AccountDetail account_detail);
}
