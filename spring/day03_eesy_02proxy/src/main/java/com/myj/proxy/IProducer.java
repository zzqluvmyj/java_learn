package com.myj.proxy;

public interface IProducer {
    /**
     * 销售
     *
     */
    public void saleProduct(double money);

    /**
     *售后
     *
     */
    public void afterService(double money);
}
