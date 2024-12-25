package com.GinElmaC.bank.MyException;

public class NoMoneyException extends Exception{
    public NoMoneyException(){};

    public NoMoneyException(String e){
        super(e);
    }
}
