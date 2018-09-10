package com.ebuy.tax.user.api.userAccount.service;

import com.ebuy.tax.user.api.userAccount.entity.UserAccount;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import java.math.BigInteger;
import java.util.LinkedList;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ebuy.tax.common.entity.PageResult;

/**
 * @Package com.ebuy.tax.user.api.userAccount.dao
 * @author hdq
 * @Date 2018-09-07 15:01:18
 * @Description
 */
@Slf4j
@Service(value = "userAccountBizService")
public class UserAccountBizServiceImpl implements UserAccountBizService {

    @Resource(name = "userAccountDmlService")
    private UserAccountDmlService userAccountDmlService;

    @Resource(name = "userAccountQueryService")
    private UserAccountQueryService userAccountQueryService;

    /**
     * @author hdq
     * @see         [UserAccount]
     * @return List<UserAccount>
     * @Description 查询列表
     * @date        2018-09-07 15:01:18
     */
    @Override
    public List<UserAccount> queryList(UserAccount userAccount) {
        return userAccountQueryService.queryAllUserAccount(userAccount);
    }

    /**
     * @author hdq
     * @see         [UserAccount] [pageNo] [pageSize]
     * @return PageResult
     * @Description 查询列表(分页)
     * @date        2018-09-07 15:01:18
     */
    @Override
    public PageResult queryListPage(UserAccount userAccount, Integer pageNo, Integer pageSize) {
        //查询分页列表总数
        int count = userAccountQueryService.queryCountUserAccount(userAccount);
        List<UserAccount> list = new LinkedList<UserAccount>();
        if (count > 0) {
            list = userAccountQueryService.queryListForPageUserAccount(userAccount, pageNo, pageSize);
        }
        return new PageResult(list, (long) count);
    }

    /**
     * @author hdq
     * @see         [id]
     * @return      UserAccount
     * @Description 按id查询
     * @date        2018-09-07 15:01:18
     */
    @Override
    public UserAccount queryById(BigInteger id) {
        return userAccountQueryService.queryById(id);
    }

    /**
     * @author hdq
     * @see         [ids]
     * @return List<UserAccount>
     * @Description 按ids查询列表
     * @date        2018-09-07 15:01:18
     */
    @Override
    public List<UserAccount> queryByIds(List<BigInteger> ids) {
        return userAccountQueryService.queryByIds(ids);
    }

    /**
     * @author hdq
     * @see         [UserAccount]
     * @return      UserAccount
     * @Description 根据entity查询一条记录
     * @date        2018-09-07 15:01:18
     */
    @Override
    public UserAccount queryByParam(UserAccount userAccount) {
        return userAccountQueryService.queryEntityByUserAccountEntity(userAccount);
    }

    /**
     * @author hdq
     * @see         [UserAccount]
     * @return
     * @Description 添加
     * @date        2018-09-07 15:01:18
     */
    @Override
    public void insert(UserAccount userAccount) {
            userAccountDmlService.insertUserAccount(userAccount);
    }

    /**
     * @author hdq
     * @see         [UserAccount]
     * @return
     * @Description 添加or更新
     * @date        2018-09-07 15:01:18
     */
    @Override
    public void insertOrUpdate(UserAccount userAccount) {
            userAccountDmlService.insertOrUpdateUserAccount(userAccount);
    }

    /**
     * @author hdq
     * @see         [UserAccount]
     * @return
     * @Description 更新
     * @date        2018-09-07 15:01:18
     */
    @Override
    public void update(UserAccount userAccount) {
            userAccountDmlService.updateUserAccount(userAccount);
    }

    /**
     * @return java.lang.String
     * @param
     * @author hdq
     * @Description 获取我的账户余额
     * @date 2018/9/8 18:39
     */
    @Override
    public BigDecimal queryAccountBalance(String userId){
        UserAccount param = new UserAccount();
        param.setUserId(userId);
        UserAccount result = userAccountQueryService.queryEntityByUserAccountEntity(param);
        return result.getBalance();
    }
}

