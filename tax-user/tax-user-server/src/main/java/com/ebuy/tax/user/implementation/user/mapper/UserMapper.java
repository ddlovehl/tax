package com.ebuy.tax.user.implementation.user.mapper;

import com.ebuy.tax.user.api.user.entity.User;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.user.dao
 * @author hdq
 * @Date 2018-09-05 09:57:25
 * @Description ç”¨æˆ·è¡¨ Mapper 接口
 */
public interface UserMapper extends SuperMapper<User> {

    int queryCount(User user);

    List<User> queryList(User user);

    List<User> queryListForPage( @Param("entity")User user, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    User queryEntityByUserEntity(User user);
}
