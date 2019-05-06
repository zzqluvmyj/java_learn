package com.myj.test;

import com.myj.domain.Account;
import com.myj.service.IAccountService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 该项目中使用了繁琐的方式实现了事务,下面是测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:ApplicationContext.xml")
public class AccountServiceTest {
    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aaa","ccc",100f);
    }

}
