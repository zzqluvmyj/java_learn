package com.myj.test;

import com.myj.domain.Account;
import com.myj.service.IAccountService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit单元测试,测试配置是否成功
 */
public class AccountServiceTest {
    private ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    private IAccountService as=ctx.getBean("accountService",IAccountService.class);

    @Test
    public void testFindAll() {

        List<Account> accounts=as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account=as.findAccount(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account=new Account();
        account.setName("tom");
        account.setMoney(1000f);//float类型必须显式声明
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        Account account=new Account();
        account.setName("jerry");
        account.setMoney(2000f);//float类型必须显式声明
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        as.deleteAccount(2);
    }



}
