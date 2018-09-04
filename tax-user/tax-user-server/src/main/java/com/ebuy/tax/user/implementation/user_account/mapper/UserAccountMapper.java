package com.ebuy.tax.user.implementation.user_account.mapper;

import com.ebuy.tax.user.api.user_account.entity.UserAccount;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.user_account.dao
 * @author hdq
 * @Date 2018-09-04 21:43:56
 * @Description è´¦æˆ·è¡¨ Mapper 接口
 */
public interface UserAccountMapper extends SuperMapper<UserAccount> {

    int queryCount(UserAccount user_account);

    List<UserAccount> queryList(UserAccount user_account);

    List<UserAccount> queryListForPage( @Param("entity")UserAccount user_account, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    UserAccount queryEntityByUserAccountEntity(UserAccount user_account);
}
