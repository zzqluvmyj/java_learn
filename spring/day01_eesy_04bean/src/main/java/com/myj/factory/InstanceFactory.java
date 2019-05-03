package com.myj.factory;

import com.myj.service.IAccountService;
import com.myj.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
