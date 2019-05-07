package com.myj.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类,包含了开启事务,提交事务,回滚事务,释放连接
 */
@Component("txManager")
@Aspect//表示切面类
public class TransactionManager {
    @Autowired
    private  ConnectionUtils connectionUtils;

    //声明切入点
    @Pointcut("execution(* com.myj.service.impl.*.*(..))")
    private void pt1(){}

    public void begin(){
        try{
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void rollback(){
        try{
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void commit(){
        try{
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void release(){
        try{
            connectionUtils.getThreadConnection().close();//没有真的关,只是还回了连接池中
            connectionUtils.removeConnection();//解除线程和对象的绑定
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //因为spring有通知顺序的问题,所以使用环绕通知
    //环绕通知
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object returnValue=null;
        try{
            Object[] args=pjp.getArgs();
            this.begin();
            returnValue=pjp.proceed(args);
            this.commit();
            return returnValue;
        }catch (Throwable e){
            this.rollback();
            throw new RuntimeException(e);
        }finally {
            this.release();
        }
    }

}
