package com.ebuy.tax.user.api.user.service;

import com.ebuy.tax.user.api.user.entity.User;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;

/**
 * @Package com.ebuy.tax.user.api.user.dao
 * @author hdq
 * @Date 2018-09-05 18:26:56
 * @Description
 */
@Service(value = "userBizService")
public class UserBizServiceImpl implements UserBizService{

    private static final Logger logger = LoggerFactory.getLogger(UserBizServiceImpl.class);

    @Resource(name = "userDmlService")
    private UserDmlService userDmlService;

    @Resource(name = "userQueryService")
    private UserQueryService userQueryService;

    /**
     * @author      hdq
     * @see         [User]
     * @return      List<User>
     * @Description 查询列表
     * @date        2018-09-05 18:26:56
     */
    @Override
    public List<User> queryList(User user){
        return userQueryService.queryAllUser(user);
    }

    /**
     * @author      hdq
     * @see         [User] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-05 18:26:56
     */
    @Override
    public PageResult queryListPage(User user, Integer pageNo, Integer  pageSize){
        //查询分页列表总数
        int count = userQueryService.queryCountUser(user);
        List<User> list = new LinkedList<User>();
        if(count > 0) {
            list = userQueryService.queryListForPageUser(user,pageNo,pageSize);
        }
        return  new PageResult(list,(long)count);
    }

    /**
     * @author      hdq
     * @see         [id]
     * @return      User
     * @Description 按id查询
     * @date        2018-09-05 18:26:56
     */
    @Override
    public User queryById(BigInteger id){
        return userQueryService.queryById(id);
    }

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<User>
     * @Description 按ids查询列表
     * @date        2018-09-05 18:26:56
     */
    @Override
    public List<User> queryByIds(List<BigInteger> ids){
        return userQueryService.queryByIds(ids);
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return      User
     * @Description 根据entity查询一条记录
     * @date        2018-09-05 18:26:56
     */
    @Override
    public User queryByParam(User user){
        return userQueryService.queryEntityByUserEntity(user);
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return
     * @Description 添加
     * @date        2018-09-05 18:26:56
     */
    @Override
    public void insert(User user){
        userDmlService.insertUser(user);
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return
     * @Description 添加or更新
     * @date        2018-09-05 18:26:56
     */
    @Override
    public void insertOrUpdate(User user){
        userDmlService.insertOrUpdateUser(user);
    }

    /**
     * @author      hdq
     * @see         [User]
     * @return
     * @Description 更新
     * @date        2018-09-05 18:26:56
     */
    @Override
    public void update(User user){
        userDmlService.updateUser(user);
    }


}

