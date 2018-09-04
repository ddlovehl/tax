package com.ebuy.tax.user.api.user_account.service;

import com.ebuy.tax.user.api.user_account.entity.UserAccount;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;

/**
 * @Package com.ebuy.tax.user.api.user_account.dao
 * @author hdq
 * @Date 2018-09-04 21:43:56
 * @Description
 */
public class UserAccountBizServiceImpl implements UserAccountBizService{

    private static final Logger logger = LoggerFactory.getLogger(UserAccountBizServiceImpl.class);

    private UserAccountDmlService user_accountDmlService;

    private UserAccountQueryService user_accountQueryService;

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      List<UserAccount>
     * @Description 查询列表
     * @date        2018-09-04 21:43:56
     */
    public List<UserAccount> queryList(UserAccount user_account){
        return user_accountQueryService.queryAllUserAccount(user_account);
    }

    /**
     * @author      hdq
     * @see         [UserAccount] [pageNo] [pageSize]
     * @return          PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-04 21:43:56
     */
    public PageResult queryListPage(UserAccount user_account, Integer pageNo, Integer  pageSize){
        //查询分页列表总数
        int count = user_accountQueryService.queryCountUserAccount(user_account);
        List<UserAccount> list = new LinkedList<UserAccount>();
        if(count > 0) {
            list = user_accountQueryService.queryListForPageUserAccount(user_account,pageNo,pageSize);
        }
        return  new PageResult(list,(long)count);
    }

    /**
     * @author      hdq
     * @see         [id]
     * @return      UserAccount
     * @Description 按id查询
     * @date        2018-09-04 21:43:56
     */
    public UserAccount queryById(BigInteger id){
        return user_accountQueryService.queryById(id);
    }

    /**
     * @author      hdq
     * @see         [ids]
     * @return      List<UserAccount>
     * @Description 按ids查询列表
     * @date        2018-09-04 21:43:56
     */
    public List<UserAccount> queryByIds(List<BigInteger> ids){
        return user_accountQueryService.queryByIds(ids);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return      UserAccount
     * @Description 根据entity查询一条记录
     * @date        2018-09-04 21:43:56
     */
    public UserAccount queryByParam(UserAccount user_account){
        return user_accountQueryService.queryEntityByUserAccountEntity(user_account);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return
     * @Description 添加
     * @date        2018-09-04 21:43:56
     */
    public void insert(UserAccount user_account){
        user_accountDmlService.insertUserAccount(user_account);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return
     * @Description 添加or更新
     * @date        2018-09-04 21:43:56
     */
    public void insertOrUpdate(UserAccount user_account){
        user_accountDmlService.insertOrUpdateUserAccount(user_account);
    }

    /**
     * @author      hdq
     * @see         [UserAccount]
     * @return
     * @Description 更新
     * @date        2018-09-04 21:43:56
     */
    public void update(UserAccount user_account){
        user_accountDmlService.updateUserAccount(user_account);
    }


}

