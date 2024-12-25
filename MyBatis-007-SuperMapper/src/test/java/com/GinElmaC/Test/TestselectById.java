package com.GinElmaC.Test;

import com.GinElmaC.Mapper.ClassMapper;
import com.GinElmaC.Mapper.PeopleMapper;
import com.GinElmaC.Pojo.Classroom;
import com.GinElmaC.Pojo.People;
import com.GinElmaC.Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestselectById {
    @Test
    public void selectByIdTest(){
        SqlSession ss = SqlSessionUtil.openSqlSession();
        PeopleMapper peopleMapper = ss.getMapper(PeopleMapper.class);
        People people = peopleMapper.selectById(1);
        System.out.println(people.getCid());
        System.out.println(people.getId());
        System.out.println(people.getSname());
        System.out.println(people.getClassroom().getCname());
        System.out.println(people.getClassroom().getCid());
        ss.close();
    }
    @Test
    public void testFirst(){
        SqlSession ss = SqlSessionUtil.openSqlSession();
        PeopleMapper peopleMapper = ss.getMapper(PeopleMapper.class);
        People people = peopleMapper.selectFirstById(4);
        System.out.println(people.getSname());
        System.out.println(people.getClassroom().getCname());
        ss.close();
    }
    @Test
    public void testClasstoPeople(){
        SqlSession ss = SqlSessionUtil.openSqlSession();
        ClassMapper classMapper = ss.getMapper(ClassMapper.class);
        Classroom classroom = classMapper.selectByCidMany(1000);
        System.out.println(classroom);
        ss.close();
    }
    @Test
    public void testthis(){
        SqlSession ss = SqlSessionUtil.openSqlSession();
        ClassMapper classMapper = ss.getMapper(ClassMapper.class);
        List<People> list = classMapper.selectByCidFirst(1000);
        System.out.println(list);
        ss.close();
    }
}
