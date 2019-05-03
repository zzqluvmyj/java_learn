package com.myj.factory;

import com.myj.service.IAccountService;
import com.myj.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
    public static IAccountService init(){
        System.out.println("service创建");
        return new AccountServiceImpl();
    }

    public static void destroy(){
        System.out.println("service销毁");
    }
}
