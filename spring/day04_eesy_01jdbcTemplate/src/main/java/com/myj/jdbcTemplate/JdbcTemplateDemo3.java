package com.myj.jdbcTemplate;

import com.myj.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");

        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);

        //执行数据库操作
        //保存
        jt.update("insert into account(name,money) values(?,?)","eee",3000);
        //更新
        jt.update("update account set name=?,money=? where id=?","test",5000,6);
        //删除
        jt.update("delete from account where id=?",8);
        //查询所有
//        List<Account> accounts=jt.query("select * from account where money>?",new AccountRowMapper(),1000);
        //可以不用上面的
        List<Account> accounts=jt.query("select * from account where money>?",new BeanPropertyRowMapper<Account>(Account.class),1000);
        List<Account> accounts1=jt.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),1);

        //可以查询所有和查询多个

        for(Account account:accounts)
            System.out.println(account);
        System.out.println(accounts1.isEmpty()?"没有内容":accounts1.get(0));

        //查询一行一列
        //使用聚合函数,但是没有group by语句
        //Long是用于接收的类型
        Long count=jt.queryForObject("select count(*) from account where money>?",Long.class,1000);
        System.out.println(count);
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据分装到Account中,然后由spring把每个Account加到集合中
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account=new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getDouble("money"));
        return account;
    }
}
