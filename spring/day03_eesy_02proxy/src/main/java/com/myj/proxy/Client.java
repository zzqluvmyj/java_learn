package com.myj.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer=new Producer();

        /**
         * 动态代理:
         *      特点:字节码随用随创建,随用随加载
         *      作用:不修改源码的基础上对方法增强
         *      分类:
         *          基于接口
         *          基于子类
         *      基于接口的动态代理:
         *          涉及的类Proxy
         *          提供者:官方
         *      如何创建代理对象?
         *          Proxy的newProxyInstance
         *      创建代理对象要求:
         *          被代理类最少实现一个接口,没有不能被代理
         *      Proxy的newProxyInstance的参数
         *          ClassLoader
         *              用于加载代理对象字节码的,写的是被代理对象的类加载器
         *              固定写法
         *          Class[]
         *              用户让代理对象对象和被被代理对象有相同方法,也就是实现了同一个接口
         *              固定写法
         *          InvocationHandler
         *              用于增强的代码
         *              让我们写如何代理,一般都是一个该接口的实现类,通常情况是匿名内部类,非必须.
         *              此接口的实现类,谁用谁写.
         */

        IProducer proxyProducer=(IProducer) Proxy.newProxyInstance(
                producer.getClass().getClassLoader(),//固定的
                producer.getClass().getInterfaces(),//固定的
                new InvocationHandler() {


                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前指定的方法
                     * @param args 当前执行方法需要的参数
                     * @return 和被代理的对象方法有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强代码
                        Object returnValue=null;
                        if("saleProduct".equals(method.getName())){
                            double money=(Double) args[0];
                            returnValue=method.invoke(producer,money*0.8);//此处调用的是被代理的原来的方法.
                        }

                        return returnValue;
                    }
                }
        );
        proxyProducer.saleProduct(10000);
    }
}
