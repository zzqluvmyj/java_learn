package com.myj.utils;

/**
 * 和事务管理相关的工具类,包含了开启事务,提交事务,回滚事务,释放连接
 */
public class TransactionManager {
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    private  ConnectionUtils connectionUtils;



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

}
