package com.GinElmaC.bank.service.Impl;

import com.GinElmaC.bank.MyException.NoMoneyException;
import com.GinElmaC.bank.MyException.TransferException;
import com.GinElmaC.bank.Util.SqlSessionUtil;
import com.GinElmaC.bank.dao.AccountDao;
import com.GinElmaC.bank.dao.Impl.AccountDaoImpl;
import com.GinElmaC.bank.pojo.Account;
import com.GinElmaC.bank.service.AccountService;
import org.apache.ibatis.session.SqlSession;

/**
 * 银行账户逻辑接口的实现类
 * 修改：GinElmaC
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String fromActno, String toActno, double money) throws NoMoneyException, TransferException {
        SqlSession ss = SqlSessionUtil.openSqlSession();

        //1.判断转出账户余额(select)
        Account fromAccount = accountDao.selectByActno(fromActno);
        if(fromAccount.getBalance()<money){
            //如果不足
            throw new NoMoneyException("余额不足");
        }
        //如果充足
        //先更新java内存中的对象再修改数据库
        Account toAccount = accountDao.selectByActno(toActno);
        fromAccount.setBalance(fromAccount.getBalance()-money);
        toAccount.setBalance(toAccount.getBalance()+money);
        //2.更新转出账户余额(update)
        int count = accountDao.updateByActno(toAccount);
        //3.更新转入账户余额(update)
        count += accountDao.updateByActno(fromAccount);
        System.out.println(count);
        if(count != 2){
            throw new TransferException("未知原因转账失败");
        }

        ss.commit();

        SqlSessionUtil.close(ss);
    }
}
