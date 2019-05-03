package com.myj.jdbc;
import java.sql.*;
/**
 * 耦合和解耦
 *
 * 实际开发应该做到编译器不依赖,运行时才依赖.
 *
 * 解决思路:
 *     1.使用反射,避免使用new关键字.
 *     2.通过配置文件来获取要创建对象的全限定类名.
 *
 */

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException{
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());//编译时依赖
        try{
            Class.forName("com.mysql.jdbc.Driver");//运行时依赖
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        //2.获取连接
        Connection coon =DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC","zam","zam123456");

        //3.获取操作数据库的预处理对象
        PreparedStatement pstm=coon.prepareStatement("select * from account");

        //4.执行sql
        ResultSet rs=pstm.executeQuery();

        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }

        //6.释放资源
        rs.close();
        pstm.close();
        coon.close();

    }
}
