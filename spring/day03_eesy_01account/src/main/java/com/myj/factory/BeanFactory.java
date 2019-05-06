package com.myj.factory;

import com.myj.domain.Account;
import com.myj.service.IAccountService;
import com.myj.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {
    private IAccountService accountService;


    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    private TransactionManager txManager;

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service的代理对象
     *
     */
    public IAccountService getAccountService(){
        return (IAccountService)Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    //添加事务的支持
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue=null;
                        try{
                            //1.开启事务
                            txManager.begin();
                            //2.执行操作
                            //Account account= accountDao.findAccount(accountId);
                            returnValue=method.invoke(accountService,args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            //return account;
                            return returnValue;
                        }catch (Exception e){
                            //5.回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            //6.释放连接
                            txManager.release();
                        }
                    }
                });
    }
}
