package com.myj.service.impl;

import com.myj.dao.IAccountDao;
import com.myj.dao.impl.AccountDaoImpl;
import com.myj.factory.BeanFactory;
import com.myj.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //private IAccountDao accountDao=new AccountDaoImpl();
    private int i;
    private IAccountDao accountDao= (IAccountDao)BeanFactory.getBean("accountDao");
    public void saveAccount(){
        accountDao.saveAccount();
        i+=1;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "i=" + i +
                ", accountDao=" + accountDao +
                '}';
    }
}
