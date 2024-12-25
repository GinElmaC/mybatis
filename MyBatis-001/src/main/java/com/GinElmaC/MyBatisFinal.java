package com.GinElmaC;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 完整的MyBatis代码
 * 修改：GinElmaC
 */
public class MyBatisFinal {
    public static void main(String[] args){
        SqlSession s = null;
        try {
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
            InputStream is = Resources.getResourceAsStream("MyBatis-config.xml");
            SqlSessionFactory sf = sfb.build(is);
            s = sf.openSession();
            int count = s.insert("insertCar");
            System.out.println("修改了："+count+"条数据");
            s.commit();
        } catch (IOException e) {
            if(s != null){
                s.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if(s != null){
                s.close();
            }
        }
    }
}
