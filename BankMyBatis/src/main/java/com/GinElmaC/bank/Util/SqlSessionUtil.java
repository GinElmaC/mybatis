package com.GinElmaC.bank.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * SqlSession工具类
 * 修改：GinElmaC
 * version:1.0
 */
public class SqlSessionUtil {
    private SqlSessionUtil(){};

    private static SqlSessionFactory sf;

    //全局服务器级别的，一个服务器一个
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    static{
        try {
            sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("MyBatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取会话对象
     * @return 会话对象
     */
    public static SqlSession openSqlSession(){
        SqlSession s = local.get();
        if(s == null){
            s = sf.openSession();
            local.set(s);
        }
        return s;
    }

    public static void close(SqlSession s){
        if(s != null){
            s.close();
            local.remove();
        }
    }
}
