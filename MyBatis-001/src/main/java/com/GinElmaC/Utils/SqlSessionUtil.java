package com.GinElmaC.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * SqlSession工具类
 * 修改：GinElmaC
 * @version 1.0
 * @since  1.0
 */
public class SqlSessionUtil {
    //工具类私有构造方法
    private SqlSessionUtil(){};

    //因为一个数据库对应一个SqlSessionFactory，所以我们可以放在静态代码块里，再类加载的时候加载一次就行
    private static SqlSessionFactory sf;

    static{
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        try {
            sf = sfb.build(Resources.getResourceAsStream("MyBatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //开启回话
    public static SqlSession openSession(){
        SqlSession s = sf.openSession();
        return s;
    }
}
