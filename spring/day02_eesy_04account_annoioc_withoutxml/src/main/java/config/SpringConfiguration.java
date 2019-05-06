package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 配置类,通过java代码配置,而不是xml
 * spring注解:
 *      1.Configuration
 *      标记配置类
 *      *****************************************************
 *      当配置类作为AnnotationConfigApplicationContext对象创建的参数时,注解可以不写.
 *      但并不绝对.加上就对了,加上没坏处,去掉没好处.
 *      具体解决方法请看Import注解.
 *          如果不在AnnotationConfigApplicationContext对象中传入类,就必须有该注解.否则不是必须的.
 *          AnnotationConfigApplicationContext中可以传入多个类.
 *          如果没有该注解,该类中的所有注解将不会被识别.
 *
 *      ******************************************************
 *
 *      2.ComponentScan
 *      属性:
 *          value:和basePackages一样
 *      和xml中的包搜索类似
 *      <context:component-scan base-package="com.myj"></context:component-scan>
 *      确定通过注解时要搜索的包
 *
 *      3.Bean
 *      作用:将当前方法的返回值作为bean存入spring的容器中
 *      属性:
 *          name:指定bean的id,默认值是当前方法名称
 *      **********************************************************
 *          当使用此注解方法时,如果方法有参数,会去容器中找有没有可用的bean对象.
 *          和AutoWired注解一样
 *      *********************************************************
 *
 *      4.Import
 *          导入其他的子配置类.
 *          AnnotationConfigApplicationContext方法在导入父配置类的时候,会自动导入子配置类.
 *
 *      5.PropertySource
 *          导入property配置.
 *          属性:
 *              value:文件的名称和路径.
 *                  classpath:表示类路径,也就是找单文件或者类配置,而不是一整个包
 *                  加上classpath关键字是因为在生成build后,配置文件到了classes文件夹中.
 *       基本原则:xml适合配置jar包中的类.
 *       注解适合配置自己写的类.
 */


//@Configuration
//@ComponentScan(basePackages = "com.myj")
//@ComponentScan(values = "com.myj")
@ComponentScan("com.myj")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
