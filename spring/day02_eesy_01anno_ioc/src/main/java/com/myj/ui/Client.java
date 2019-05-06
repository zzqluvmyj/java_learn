package com.myj.ui;

import com.myj.dao.IAccountDao;

import com.myj.service.IAccountService;
import com.myj.service.impl.AccountServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {
    public static void main(String[] args) {
        //IAccountService as=new AccountServiceImpl();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //IAccountService as = (IAccountService) ctx.getBean("accountServiceImpl");
        IAccountService as1 = (IAccountService) ctx.getBean("accountService");
        System.out.println(as1);
        IAccountService as2 = (IAccountService) ctx.getBean("accountService");

        IAccountDao acdo=(IAccountDao)ctx.getBean("accountDao");
        System.out.println(acdo);

        as1.saveAccount();
        System.out.println(as1==as2);
        ((ClassPathXmlApplicationContext)ctx).close();

    }
}
