package com.GinElmaC.Mapper;

import com.GinElmaC.Pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentMapper {
    /**
     * 根据id,name,birth,sex的查询
     */
    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    List<Student> selectByBirth(Date birth);
    List<Student> selectBySex(Character sex);

    /**
     * 多参数练习
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByMany(@Param("name")String name,@Param("sex") Character sex);
}
