package com.myj.dao;

import com.myj.domain.Account;

public interface IAccountDao {
    Account findAccountById(Integer id);
    Account findAccountByName(String name);
    void updateAccount(Account account);
}
