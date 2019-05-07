package com.myj.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class AccountSupport {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //设置数据源的时候能够自动创建JdbcTemplate对象,此时可以不用配置
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        if(jdbcTemplate==null)
            jdbcTemplate=createJdbcTemplate(dataSource);
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
