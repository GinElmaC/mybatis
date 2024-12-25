package com.GinElmaC.Utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 开启回话的工具类
 */
public class SqlSessionUtil {
    private SqlSessionUtil(){};
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    private static SqlSessionFactory sf;
    static{
        sf = new SqlSessionFactoryBuilder().build(ClassLoader.getSystemClassLoader().getResourceAsStream("MyBatis-config.xml"));
    }
    public static SqlSession openSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
            sqlSession = sf.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
    public static void close(SqlSession s){
        if(s != null){
            s.close();
            threadLocal.remove();
        }
    }
}
