package com.myj.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
        jt.execute("insert into account(name,money) values('ddd',10000)");
    }
}
