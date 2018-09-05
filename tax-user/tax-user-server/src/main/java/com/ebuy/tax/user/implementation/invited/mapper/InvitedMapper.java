package com.ebuy.tax.user.implementation.invited.mapper;

import com.ebuy.tax.user.api.invited.entity.Invited;
import com.ebuy.tax.common.entity.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Package com.ebuy.tax.user.implementation.invited.dao
 * @author hdq
 * @Date 2018-09-05 09:35:19
 * @Description è¢«é‚€è¯·è¡¨ Mapper 接口
 */
public interface InvitedMapper extends SuperMapper<Invited> {

    int queryCount(Invited invited);

    List<Invited> queryList(Invited invited);

    List<Invited> queryListForPage( @Param("entity")Invited invited, @Param("start")Integer start, @Param("pageSize")Integer pageSize);

    Invited queryEntityByInvitedEntity(Invited invited);
}
