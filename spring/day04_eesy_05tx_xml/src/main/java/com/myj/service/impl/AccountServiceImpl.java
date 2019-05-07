package com.myj.service.impl;

import com.myj.dao.IAccountDao;
import com.myj.domain.Account;
import com.myj.service.IAccountService;
import java.util.List;

/**
 * 账户业务层的实现类
 *
 * 事务控制应该在业务层
 *
 *
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void transfer(String sourceName, String targetName, Double money) {

            Account source=accountDao.findAccountByName(sourceName);
            Account target=accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            int a=1/0;//此处测试这一系列操作是否是一个事务
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
    public IAccountDao getAccountDao() {
        return accountDao;
    }
}
