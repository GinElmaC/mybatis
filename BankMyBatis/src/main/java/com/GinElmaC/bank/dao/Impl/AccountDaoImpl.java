package com.GinElmaC.bank.dao.Impl;

import com.GinElmaC.bank.Util.SqlSessionUtil;
import com.GinElmaC.bank.dao.AccountDao;
import com.GinElmaC.bank.pojo.Account;
import org.apache.ibatis.session.SqlSession;

/**
 * 账户Dao包的实现类
 */
public class AccountDaoImpl implements AccountDao {
    /**
     * 根据账户查询账号
     * @param Actno 要查询的账户账号
     * @return 查询到的账号
     */
    @Override
    public Account selectByActno(String Actno) {
        SqlSession ss = SqlSessionUtil.openSqlSession();
        Account account = (Account)ss.selectOne("account.selectOneAccount",Actno);

        return account;
    }

    @Override
    public int updateByActno(Account Actno) {
        SqlSession ss = SqlSessionUtil.openSqlSession();
        int count = ss.update("account.updateAccount",Actno);
        return count;
    }
}
