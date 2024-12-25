package com.GinElmaC.testIt;

import com.GinElmaC.Mapper.AccountMapper;
import com.GinElmaC.Pojo.Account;
import com.GinElmaC.Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AccountMapperTest {
    @Test
    public void testInsert(){
        SqlSession ss = SqlSessionUtil.openSqlSession();
        //利用MyBatis特性，面向接口自动获取代理
        AccountMapper amper = ss.getMapper(AccountMapper.class);
        Account account = new Account(3l,"act003",10000.00);
        int count = amper.insertAccount(account);
        System.out.println(count);
        ss.commit();
    }
    @Test
    public void updateTest(){
        SqlSession ss = SqlSessionUtil.openSqlSession();
        AccountMapper am = ss.getMapper(AccountMapper.class);
        Account account = new Account(3l,"wanghyishuo",10000000.00);
        int count = am.update(account);
        System.out.println(count);
        ss.commit();
    }
    @Test
    public void turnTest(){
        SqlSession ss = SqlSessionUtil.openSqlSession();
        AccountMapper am = ss.getMapper(AccountMapper.class);
        List<Account> list = am.selectIt("asc");
        list.forEach(account-> System.out.println(account));
    }
}

