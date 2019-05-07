package com.myj.jdbcTemplate;

import com.myj.dao.IAccountDao;
import com.myj.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

        IAccountDao accountDao=ac.getBean("accountDao",IAccountDao.class);
        Account account=accountDao.findAccountById(6);
        System.out.println(account);
        account.setMoney(30000.0);
        accountDao.updateAccount(account);
        System.out.println(account);

    }
}
