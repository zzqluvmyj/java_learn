package com.myj.service.impl;

import com.myj.service.IAccountService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * 账户业务层实现类
 */


@Service("accountService")
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
