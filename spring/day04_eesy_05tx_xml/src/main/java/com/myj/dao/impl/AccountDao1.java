package com.myj.dao.impl;

import com.myj.dao.IAccountDao;
import com.myj.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

//提取重复代码到父类中,也可以不用自己写,用spring提供的类继承就行
//如果用了,就不能用注解了,因为jar包的中类不可变
//public class AccountDao extends AccountSupport implements IAccountDao
public class AccountDao1 extends JdbcDaoSupport implements IAccountDao
{

    public Account findAccountById(Integer id) {
        List<Account> accounts=super.getJdbcTemplate().query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> accounts=super.getJdbcTemplate().query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
