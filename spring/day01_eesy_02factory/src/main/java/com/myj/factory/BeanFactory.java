package com.myj.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建bean对象的工厂
 *
 * bean:在计算机英语中,有可重用组件的含义.
 * javabean:java编写的可重用组件.
 * javabean != 实体类
 *
 * 解决方法:读取配置文件,反射创建对象.
 */
public class BeanFactory {
    private static Properties props;//properties对象

    //定义一个map,存放要创建的对象,称为容器
    //为什么存放创建的对象?单例和多例
    private static Map<String,Object> beans;
    //单例更好
    //因为性能高,而且在单例中几乎不用保存很多的数据,不太需要实例变量

    //静态代码块初始化
    static {
        try{
            props=new Properties();
            //InputStream in=new FileInputStream();//部署后无法使用,所以不能用,也不能用绝对路径
            InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beans=new HashMap<String, Object>();
            Enumeration keys=props.keys();

            //将配置文件的类创建单例并且存入beans中
            while (keys.hasMoreElements()){
                String key=keys.nextElement().toString();
                String beanPath=props.getProperty(key);
                Object value=Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }

        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败!");
        }
    }
    //单例获取对象
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    //根据bean名称获取bean对象
//    public static Object getBean(String beanName){
//        Object bean=null;
//        try {
//            String beanPath=props.getProperty(beanName);
//            bean=Class.forName(beanPath).newInstance();//使用反射,用代码创建代码
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//    }

}
