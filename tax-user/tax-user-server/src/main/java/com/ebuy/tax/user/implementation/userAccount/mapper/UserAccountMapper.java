package com.ebuy.tax.user.implementation.userAccount.mapper;

import com.ebuy.tax.user.api.userAccount.entity.UserAccount;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.userAccount.dao
 * @author hdq
 * @Date 2018-09-05 18:26:56
 * @Description è´¦æˆ·è¡¨ Mapper 接口
 */
public interface UserAccountMapper extends SuperMapper<UserAccount> {

    int queryCount(UserAccount userAccount);

    List<UserAccount> queryList(UserAccount userAccount);

    List<UserAccount> queryListForPage( @Param("entity")UserAccount userAccount, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    UserAccount queryEntityByUserAccountEntity(UserAccount userAccount);
}
