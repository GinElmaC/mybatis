package com.GinElmaC.test;

import com.GinElmaC.Mapper.StudentMapper;
import com.GinElmaC.Pojo.Student;
import com.GinElmaC.Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class selectByIdTest {
    @Test
    public void TestselectById(){
        SqlSession s = SqlSessionUtil.openSqlSession();
        //studentMapper实际上指向了代理对象
        StudentMapper studentMapper = s.getMapper(StudentMapper.class);
        //studentMapper是代理对象，selectById是代理方法
        List<Student> list = studentMapper.selectById(2l);
        list.forEach(student-> System.out.println(student));
    }
    @Test
    public void TestselectByMany(){
        SqlSession s = SqlSessionUtil.openSqlSession();
        StudentMapper studentMapper = s.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.selectByMany("张三",'男');
        list.forEach(aaa-> System.out.println(aaa));
    }
}
