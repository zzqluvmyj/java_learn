package com.myj.ui;

import com.myj.dao.IAccountDao;

import com.myj.service.IAccountService;
import com.myj.service.impl.AccountServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建容器,获取对象
 * ApplicationContext的三个实现
 * ClassSystemXmlApplicationContext 在类路径下
 * FileSystemXmlApplicationContext 在磁盘目录下任意路径
 * AnnoationConfigApplicationContext 读取注解创建容器
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService as=new AccountServiceImpl();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService as = (IAccountService) ctx.getBean("accountService");
        IAccountDao adao=ctx.getBean("accountDao",IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);
    }
}
