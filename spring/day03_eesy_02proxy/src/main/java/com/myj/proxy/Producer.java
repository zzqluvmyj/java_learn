package com.myj.proxy;

/**
 * 生产者
 */
public class Producer implements IProducer{
    /**
     * 销售
     *
     */
    public void saleProduct(double money){
        System.out.println("销售产品,得到金钱 "+money);
    }

    /**
     *售后
     *
     */
    public void afterService(double money){
        System.out.println("提供售后服务,拿到钱 "+money);
    }
}
