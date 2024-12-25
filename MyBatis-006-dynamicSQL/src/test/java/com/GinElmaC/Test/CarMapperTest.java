package com.GinElmaC.Test;

import com.GinElmaC.Mapper.CarMapper;
import com.GinElmaC.Pojo.Car;
import com.GinElmaC.Utils.SqlSessionUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarMapperTest {
    @Test
    public void TestdelectByIds(){
        SqlSession ss = SqlSessionUtil.openSqlSession();
        CarMapper carMapper = ss.getMapper(CarMapper.class);
        Long[] ids = {10l,11l,12l,13l};
        int count = carMapper.delectByIds(ids);
        System.out.println(count);
        ss.commit();
    }
    @Test
    public void TestinsertMany(){
        SqlSession ss = SqlSessionUtil.openSqlSession();
        CarMapper carMapper = ss.getMapper(CarMapper.class);
        List<Car> list = new ArrayList<>();
        for(int i = 0;i<3;i++){
            list.add(new Car(null,"aaa","fengtian",1000.00,"1000-01-11","燃油车"));
        }
        int count = carMapper.insertMany(list);
        System.out.println(count);
        ss.commit();
    }
}
