package com.GinElmaC.Mapper;

import com.GinElmaC.Pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    int delectByIds(@Param("ids") Long[] ids);
    int insertMany(@Param("list")List<Car> list);
    int delectMany(@Param("list")List<Car> list);
}
