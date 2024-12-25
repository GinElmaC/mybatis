package com.GinElmaC.Mapper;

import com.GinElmaC.Pojo.People;

import java.util.List;

public interface PeopleMapper {
    /**
     * 多表联查，返回学生对象
     * @param要查询的学生id
     * @return 返回带有班级的学生对象
     */
    People selectById(Integer sid);

    /**
     * 分布查询第一步，根据id查询
     * @param sid
     * @return
     */
    People selectFirstById(Integer sid);

    List<People> selectByCidMany(Integer cid);
}
