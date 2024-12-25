package com.GinElmaC.bank.MyException;

public class TransferException extends Exception{
    public TransferException(){};
    public TransferException(String e){
        super(e);
    }
}
