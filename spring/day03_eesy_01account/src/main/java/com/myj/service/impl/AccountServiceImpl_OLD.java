package com.myj.service.impl;

import com.myj.dao.IAccountDao;
import com.myj.domain.Account;
import com.myj.service.IAccountService;
import com.myj.utils.TransactionManager;

import java.util.List;

/**
 * 账户业务层的实现类
 *
 * 事务控制应该在业务层
 *
 *
 */
public class AccountServiceImpl_OLD implements IAccountService {
    private IAccountDao accountDao;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    private TransactionManager txManager;

    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            txManager.begin();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            txManager.release();
        }
    }

    public Account findAccount(Integer accountId) {
        try{
            //1.开启事务
            txManager.begin();
            //2.执行操作
            Account account= accountDao.findAccount(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try{
            //1.开启事务
            txManager.begin();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
            //4.返回结果

        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    public void updateAccount(Account account) {
        try{
            //1.开启事务
            txManager.begin();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();
            //4.返回结果

        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            //1.开启事务
            txManager.begin();
            //2.执行操作
            accountDao.deleteAccount(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果

        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }
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
        //需要使用ThreadLocal对象将连接和当前线程绑定,从而一个线程中只有一个能控制事务的对象
//        Account source=accountDao.findAccountByName(sourceName);
//        Account target=accountDao.findAccountByName(targetName);
//        source.setMoney(source.getMoney()-money);
//        target.setMoney(target.getMoney()+money);
//        accountDao.updateAccount(source);
//        accountDao.updateAccount(target);

        try{
            //1.开启事务
            txManager.begin();
            //2.执行操作
            Account source=accountDao.findAccountByName(sourceName);
            Account target=accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            int a=1/0;//此处测试这一系列操作是否是一个事务
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();
            //4.返回结果
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            e.printStackTrace();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }
}
