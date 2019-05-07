package com.myj.service.impl;

import com.myj.dao.IAccountDao;
import com.myj.domain.Account;
import com.myj.service.IAccountService;
import com.myj.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户业务层的实现类
 *
 * 事务控制应该在业务层
 *
 *
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
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

    /**
     * 该方法不满足事务的一致性,如果中途出了异常,有可能发生钱转出去了,但是没有收到.
     *
     * @param sourceName 转出账户名
     * @param targetName 转入账户名
     * @param money 转账金额
     */
    public void transfer(String sourceName, String targetName, Float money) {
        //accountDao查找数据库和更新数据库在下面的语句中会建立四个连接,每个连接都是一个独立的事务
        //解决思路,只有一个连接,只有一个事务.
        //新的解决方法是使用代理扩展接口功能.
        //需要使用ThreadLocal对象将连接和当前线程绑定,从而一个线程中只有一个能控制事务的对象
//        Account source=accountDao.findAccountByName(sourceName);
//        Account target=accountDao.findAccountByName(targetName);
//        source.setMoney(source.getMoney()-money);
//        target.setMoney(target.getMoney()+money);
//        accountDao.updateAccount(source);
//        accountDao.updateAccount(target);

            Account source=accountDao.findAccountByName(sourceName);
            Account target=accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            //int a=1/0;//此处测试这一系列操作是否是一个事务
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }
}
