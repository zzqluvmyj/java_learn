package com.myj;

import com.myj.service.IAccountService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        as.saveAccount();
        as.deleteAccount();
        as.updateAccount(1);
    }
}
