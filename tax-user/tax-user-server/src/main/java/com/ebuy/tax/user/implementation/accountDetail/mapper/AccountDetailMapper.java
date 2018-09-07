package com.ebuy.tax.user.implementation.accountDetail.mapper;

import com.ebuy.tax.user.api.accountDetail.entity.AccountDetail;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.accountDetail.dao
 * @author hdq
 * @Date 2018-09-05 18:26:55
 * @Description  Mapper 接口
 */
public interface AccountDetailMapper extends SuperMapper<AccountDetail> {

    int queryCount(AccountDetail accountDetail);

    List<AccountDetail> queryList(AccountDetail accountDetail);

    List<AccountDetail> queryListForPage( @Param("entity")AccountDetail accountDetail, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    AccountDetail queryEntityByAccountDetailEntity(AccountDetail accountDetail);
}
