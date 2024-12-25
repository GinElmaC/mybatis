package com.GinElmaC.bank.dao;

import com.GinElmaC.bank.pojo.Account;

/**
 * 这是账户的Dao对象，负责对账户表中的数据CRUD
 * Dao中的方法不应该与任何业务有关系，只适用于数据库的增删改查
 * 修改：GinElmaC
 */
public interface AccountDao {
    /**
     * 根据账号获取对应的账户对象
     * @param Actno 要查询的账户账号
     * @return 查询到的账户对象
     */
    Account selectByActno(String Actno);

    /**
     * 更新账户信息
     * @param Actno 要更新的账户信息
     * @return 返回1表示成功，0表示失败
     */
    int updateByActno(Account Actno);
}
