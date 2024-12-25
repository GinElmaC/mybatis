package com.GinElmaC.Mapper;

import com.GinElmaC.Pojo.Classroom;
import com.GinElmaC.Pojo.People;

import java.util.List;

public interface ClassMapper {
    Classroom selectByCid(Integer cid);

    //一对多

    /**
     * 根据编辑编号查信息
     * @param cid
     * @return
     */
    Classroom selectByCidMany(Integer cid);

    /**
     * 分布查询
     * @param cid
     * @return
     */
    List<People> selectByCidFirst(Integer cid);
}
