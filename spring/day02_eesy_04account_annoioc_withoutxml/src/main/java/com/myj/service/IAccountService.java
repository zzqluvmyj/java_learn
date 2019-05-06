package com.myj.service;

import com.myj.domain.Account;

import java.util.List;

/**
 * 账号的业务层接口
 */
public interface IAccountService {
    /**
     * 查询所有账户
     *
     */
    List<Account> findAllAccount();

    /**
     * 查询单个
     */
    Account findAccount(Integer accountId);
    /**
     * 保存
     */
    void saveAccount(Account account);
    /**
     * 更新
     */
    void updateAccount(Account account);
    /**
     * 删除
     */
    void deleteAccount(Integer accountId);
}
