package com.myj.test;

import com.myj.domain.Account;
import com.myj.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

/**
 * 使用junit单元测试,测试配置是否成功
 * Spring整合Junit的配置.
 *      1.导入spring整合后的junit的jar包,具体见依赖.
 *      2.使用Junit提供的注解将原有的main方法替换为spring提供的.
 *          Runwith
 *      3.告知spring的运行器,是基于xml还是基于注解的,说明位置.
 *          ContextConfiguration
 *              locations:指定xml文件,需要classpath
 *              classes:指定注解类位置
 *
 *      ************************************************
 *      使用spring 5版本的时候,junit的版本必须在4.12以上
 *
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class AccountServiceTest {

    /*
    private ApplicationContext ctx;
    private IAccountService as;
    @Before
    public void init(){
        ctx=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        as=ctx.getBean("accountService",IAccountService.class);
    }
    测试工程师可能写不了这些代码,他们可能不了解spring框架.
    解决方法:spring和junit的整合见上面.
    */
    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll() {

        List<Account> accounts=as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account=as.findAccount(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account=new Account();
        account.setName("tom");
        account.setMoney(1000f);//float类型必须显式声明
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        Account account=new Account();
        account.setName("jerry");
        account.setMoney(2000f);//float类型必须显式声明
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        as.deleteAccount(2);
    }



}
