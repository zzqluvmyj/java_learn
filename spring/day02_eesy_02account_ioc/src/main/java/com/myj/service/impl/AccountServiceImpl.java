package com.myj.service.impl;

import com.myj.dao.IAccountDao;
import com.myj.domain.Account;
import com.myj.service.IAccountService;

import java.util.List;

/**
 * 账户业务层的实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccount(Integer accountId) {
        return accountDao.findAccount(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }
}
