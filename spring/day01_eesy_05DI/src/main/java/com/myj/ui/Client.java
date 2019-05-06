package com.myj.ui;

import com.myj.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {
    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService as = (IAccountService) ctx.getBean("accountService");
        System.out.println(as);

        as = (IAccountService) ctx.getBean("accountService2");
        System.out.println(as);

    }
}
