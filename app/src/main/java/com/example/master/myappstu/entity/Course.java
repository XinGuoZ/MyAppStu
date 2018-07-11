package com.example.master.myappstu.entity;

public class Course {
    private Integer classid;

    private Integer teaid;

    private String addr;

    private Integer cday;

    private Integer corder;

    private String coursename;

    private String classname;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer teaid) {
        this.teaid = teaid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getCday() {
        return cday;
    }

    public void setCday(Integer cday) {
        this.cday = cday;
    }

    public Integer getCorder() {
        return corder;
    }

    public void setCorder(Integer corder) {
        this.corder = corder;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }
}