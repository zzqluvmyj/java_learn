package com.myj.service;

import com.myj.domain.Account;

public interface IAccountService {
    Account findAccountById(Integer id);

    void transfer(String source, String target, Double money);

}
