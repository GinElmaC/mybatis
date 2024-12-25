package com.GinElmaC;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisIntroctionTextText {

    @Test
    public void textInsertCar(){
//        MyBatisIntroctionText mb = new MyBatisIntroctionText();
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
