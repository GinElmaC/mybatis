package com.GinElmaC.bank.service;

import com.GinElmaC.bank.MyException.NoMoneyException;
import com.GinElmaC.bank.MyException.TransferException;

/**
 * 这是一个账户业务类，负责处理账户相关业务
 * 修改：GinElmaC
 * version:1.0
 */
public interface AccountService {
    /**
     * 银行账户的转账业务
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 金额
     */
    void transfer(String fromActno,String toActno,double money) throws NoMoneyException, TransferException;
}
