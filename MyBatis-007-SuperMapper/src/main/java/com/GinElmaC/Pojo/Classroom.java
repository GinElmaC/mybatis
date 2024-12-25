package com.GinElmaC.Pojo;

import java.util.List;

public class Classroom {
    private int cid;
    private String cname;
    private List<People> list;


    public Classroom() {
    }

    public Classroom(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Classroom(int cid, String cname, List<People> list) {
        this.cid = cid;
        this.cname = cname;
        this.list = list;
    }

    /**
     * 获取
     * @return cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * 设置
     * @param cid
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * 获取
     * @return cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String toString() {
        return "Classroom{cid = " + cid + ", cname = " + cname + "}"+",list = "+list;
    }

    /**
     * 获取
     * @return list
     */
    public List<People> getList() {
        return list;
    }

    /**
     * 设置
     * @param list
     */
    public void setList(List<People> list) {
        this.list = list;
    }
}
