package com.GinElmaC.Pojo;

public class People {
    private int sid;
    private String sname;
    private int cid;

    private Classroom classroom;

    public People() {
    }

    public People(int sid, String sname, int cid) {
        this.sid = sid;
        this.sname = sname;
        this.cid = cid;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return sid;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.sid = id;
    }

    /**
     * 获取
     * @return sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * 设置
     * @param sname
     */
    public void setSname(String sname) {
        this.sname = sname;
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

    public String toString() {
        return "People{id = " + sid + ", sname = " + sname + ", cid = " + cid + "}";
    }

    public Classroom getClassroom(){
        return this.classroom;
    }
}
