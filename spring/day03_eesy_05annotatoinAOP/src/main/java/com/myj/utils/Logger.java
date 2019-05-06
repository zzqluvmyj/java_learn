package com.myj.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 记录日志的公共类
 */




@Component("logger")
@Aspect//表示当前类是切面类
public class Logger {
    /**
     * 打印日志
     */
    @Pointcut("execution(* com.myj.service.impl.*.*(..))")
    private void pt1(){}

    //一下四种通知在注解中的顺序有问题
    //@Before("pt1()")
    public void beforePrintLog(){
        System.out.println("logger printlog  前置通知");
    }
    //@AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("logger printlog  后置通知");
    }
    //@AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("logger printlog  异常通知");
    }
    //@After("pt1()")
    public void afterPrintLog(){
        System.out.println("logger printlog  最终通知");
    }

    /**
     *spring框架提供的和proxy类似的方法实现环绕通知,环绕通知是各种通知的总和
     */

    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object returnValue=null;
        try{
            System.out.println("环绕通知 前置");
            Object[] args=pjp.getArgs();
            returnValue=pjp.proceed(args);//执行原来接口中的方法
            System.out.println("环绕通知 后置");
            return returnValue;
        }catch (Throwable t){
            System.out.println("环绕通知 异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("环绕通知 最终");
        }
    }
}
