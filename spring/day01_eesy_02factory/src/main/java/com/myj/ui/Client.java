package com.myj.ui;

import com.myj.factory.BeanFactory;
import com.myj.service.IAccountService;
import com.myj.service.impl.AccountServiceImpl;
import com.myj.factory.BeanFactory;
/**
 * 模拟表现层
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService as=new AccountServiceImpl();

        for (int i=0;i<5;i++){
            IAccountService as = (IAccountService)BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
