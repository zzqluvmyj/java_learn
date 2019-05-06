package com.myj.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryRunnerTest {
    @Test
    public void testQueryRunner(){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner1=ctx.getBean("runner",QueryRunner.class);
        QueryRunner runner2=ctx.getBean("runner",QueryRunner.class);
        System.out.println(runner1==runner2);


    }
}
