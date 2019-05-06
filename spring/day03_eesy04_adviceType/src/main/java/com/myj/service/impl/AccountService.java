package com.myj.service.impl;

import com.myj.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountService implements IAccountService {

    public void saveAccount() {
        System.out.println("save");
    }

    public void updateAccount(int i) {
        System.out.println("update "+i);
    }

    public int deleteAccount() {
        System.out.println("delete");
        return 0;
    }
}
