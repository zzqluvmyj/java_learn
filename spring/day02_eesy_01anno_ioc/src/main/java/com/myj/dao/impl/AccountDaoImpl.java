package com.myj.dao.impl;

import com.myj.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount(){
        System.out.println("保存了账号类");
    }
}
