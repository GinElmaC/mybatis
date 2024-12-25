package com.GinElmaC.bank.pojo;

/**
 * 这是个账户类，专门用来封装账户信息
 * 修改：GinElmaC
 * version:1.0
 */
public class Account {
    private Long id;
    private String Actno;
    private Double Balance;

    public Account() {
    }

    public Account(Long id, String actno, Double balance) {
        this.id = id;
        this.Actno = actno;
        this.Balance = balance;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return actno
     */
    public String getActno() {
        return Actno;
    }

    /**
     * 设置
     * @param actno
     */
    public void setActno(String actno) {
        this.Actno = actno;
    }

    /**
     * 获取
     * @return balance
     */
    public Double getBalance() {
        return Balance;
    }

    /**
     * 设置
     * @param balance
     */
    public void setBalance(Double balance) {
        this.Balance = balance;
    }

    public String toString() {
        return "Account{id = " + id + ", actno = " + Actno + ", balance = " + Balance + "}";
    }
}
