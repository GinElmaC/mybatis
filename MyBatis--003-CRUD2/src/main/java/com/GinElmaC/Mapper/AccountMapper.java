package com.GinElmaC.Mapper;

import com.GinElmaC.Pojo.Account;

import java.util.List;

public interface AccountMapper {
    /**
     * 增Account
     * @param account
     * @return
     */
    int insertAccount(Account account);
    /**
     * 删Account
     */
    int deleteById(Long id);
    int update(Account account);
    Account selectById(Long id);
    List<Account> selectAll();

    List<Account> selectIt(String aseOrDesc);

    /**
     * 返回插入的Account数据的主键值
     * @param account 插入的数据
     * @return 返回的主键值
     */
    int insertAccountUseGeneratedKeys(Account account);
}
