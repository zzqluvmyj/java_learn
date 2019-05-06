package com.myj.dao;

import com.myj.domain.Account;

import java.util.List;

public interface IAccountDao {
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
