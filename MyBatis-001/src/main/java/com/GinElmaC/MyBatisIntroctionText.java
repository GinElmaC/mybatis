package com.GinElmaC;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisIntroctionText {
    public static void main(String[] args) throws IOException {
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        //SqlSessionFactory
        //SqlSessionFactoryBuilder创建下一级对象时需要传入一个输入流对象，这里有两个方法，一个是new一个InputStream流，输入xml文件的路径
        //另一个方法是利用类加载器，类加载器也是从类根路径下查找
        //InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("resource中的xml路径")
        //另一个方法就是下面的利用apache里Resources类的方法直接获取资源并转化为流
        //这个文件默认从类的根目录下查找资源，与resource文件类似，所以直接写名字就行
        InputStream is = Resources.getResourceAsStream("MyBatis-config.xml");
        SqlSessionFactory sf = sfb.build(is);//一般情况下是一个数据库(不是表)对应一个SqlSessionFactory
        //SqlSession
        //注意，默认获取的SqlSession对象是不支持自动提交的，在下面需要手动提交
        SqlSession s = sf.openSession();//如果使用的是JDBC管理机制，则底层会自动执行coon.serAutocommit(false)
        //执行SQL语句
        //去到对应配置文件中通过输入的参数作为id查找对应语句执行
        int count = s.insert("insertCar");//返回值是受影响的行数
        System.out.println("插入了："+count);

        //手动提交
        s.commit();
        //那提交后为什么id少了一个呢?因为就算没有提交，但sql语句也是执行了一次的，id的自增已经发生
    }
}
