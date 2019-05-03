package com.myj.ui;

import com.myj.factory.StaticFactory;
import com.myj.service.IAccountService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {
    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService as1 = (IAccountService) ctx.getBean("accountService");
        IAccountService as2 = (IAccountService) ctx.getBean("accountService");
        System.out.println(as1==as2);

        StaticFactory as3 = (StaticFactory) ctx.getBean("accountService3");
        System.out.println(as3);

        ((ClassPathXmlApplicationContext)ctx).close();


    }
}
