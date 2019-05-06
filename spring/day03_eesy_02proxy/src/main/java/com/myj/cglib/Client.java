package com.myj.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer=new Producer();//必须要final修饰

        /**
         * 动态代理:
         *      特点:字节码随用随创建,随用随加载
         *      作用:不修改源码的基础上对方法增强
         *      分类:
         *          基于接口(Proxy)
         *          基于子类(dglib)
         *      基于接口的动态代理:
         *          涉及的类:Enhancer
         *          使用:Enhancer的create方法
         *          要求:
         *              被代理类不能是最终类
         *          create方法的参数
         *              Class:被代理对象的字节码
         *              CallBack:用于增强的代码

         *
         */

        /**
         * MethodInterceptor前三个参数和代理一样
         */
        Producer cglibproducer=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue=null;
                double money=(Double) args[0];
                if("saleProduct".equals(method.getName())){
                    returnValue=method.invoke(producer,money*0.8);//此处调用的是被代理的原来的方法.
                }

                return returnValue;
            }
        });

        cglibproducer.saleProduct(12000);
    }
}
