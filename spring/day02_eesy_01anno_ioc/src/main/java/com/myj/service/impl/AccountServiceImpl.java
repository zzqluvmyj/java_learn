package com.myj.service.impl;

import com.myj.dao.IAccountDao;
import com.myj.dao.impl.AccountDaoImpl;
import com.myj.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.misc.Contended;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 账户业务层实现类
 * 使用xml配置
 * <bean id="accountService" class="com.myj.service.impl.AccountServiceImpl"
 *        scope="" init-method="" destroy-method="" >
 *        <property name="" value="" | ref=""></property>
 * </bean>
 *
 * 注解4类:
 * 1.创建对象的:
 *      和bean标签类似,bean的id是类首字母小写.
 *      Component
 *          作用:当前类对象装入spring容器
 *          属性:value,指定bean的id,默认的id是当前类名,首字母小写
 *      Controller:表现层
 *      Service:业务层
 *      Repository:持久层
 *          上面三个注解和Component一样,但是是提供明确的三层使用的注解,让架构清晰
 * 2.注入数据的
 *      和property类似
 *      Autowired:
 *          作用:自动按照类型注入,只要有唯一的一个bean对象和要注入的变量类型匹配,就可以注入成功.
 *          如果没有唯一的bean对象,则先找同样类型的,再找和变量相同的bean名称.
 *          出现位置:
 *              变量,方法.
 *          此时set方法不是必须的.
 *      Qualifier:
 *          作用:在按照类注入的基础上按照名称注入,在给类成员注入时不能单独使用,但是给方法参数注入时可以
 *          属性:
 *              value:用于指定注入bean的id
 *      Resource
 *          作用:直接按照bean的id注入,可以独立使用.
 *          属性:
 *              name:被注入的bean的id
 *      以上三个注入只能注入bean类型的数据,其他基本类型无法使用.
 *
 *      Value
 *          作用:用于注入基本类型和String类型的数据
 *          属性:
 *              用于指定数据的值,可以使用spring中的SpEL
 *              SpEl写法,${表达式}
 * 3.改变作用域的
 *      和scope类似
 *      Scope
 *          作用:用户指定范围的取值
 *          属性:value,枚举值,singleton和prototype
 * 4.生命周期相关的
 *      和init-method和destroy-method类似
 *      PreDestroy
 *          作用:指定销毁方法
 *      PostConstruct
 *          作用:指定初始化方法
 */


//@Component(value = "accountService")
//@Component("accountService")

@Service("accountService")
@Scope("singleton")
public class AccountServiceImpl implements IAccountService {
    //private IAccountDao accountDao=new AccountDaoImpl();

    //此时的set方法不是必须的
    @Autowired
    @Qualifier("accountDao2")//此时寻找id为该值的IAccountDao类型的bean,而不是默认的accountDao
    private IAccountDao accountDao;
    public void saveAccount(){
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁");
    }
}
