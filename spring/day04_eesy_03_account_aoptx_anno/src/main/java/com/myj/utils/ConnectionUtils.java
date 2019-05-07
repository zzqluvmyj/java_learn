package com.myj.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类,从数据源中获取一个连接,实现和线程的绑定
 *
 */
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl=new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection(){
        try{
            //1.从ThreadLocal获取连接,从当前线程获取value
            Connection conn=tl.get();
            //2.判断是否有连接
            if(conn==null){
                //3.从数据源中获取连接,并且和线程绑定
                conn=dataSource.getConnection();
                tl.set(conn);//设置conn的副本对象为value,key为当前线程的包装ThreadLocal
            }
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
