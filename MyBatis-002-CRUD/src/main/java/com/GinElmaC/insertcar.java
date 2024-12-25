package com.GinElmaC;

import com.GinElmaC.Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class insertcar {
    public static void main(String[] args) {
        SqlSession s = SqlSessionUtil.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("car_num","111");
        map.put("brand","撞大运了");
        map.put("guide_price",70.00);
        map.put("produce_time","2022-11-10");
        map.put("car_type","燃气车");
        int count = s.insert("insertCar",map);
        System.out.println(count);

        s.commit();
        s.close();
    }
}
