package com.myj.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //spring内置的数据源
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC");
        ds.setUsername("zam");
        ds.setPassword("zam123456");

        JdbcTemplate jt=new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money) values('ddd',10000)");
    }
}
