package com.example.master.myappstu.entity;

public class Leave {
    private Integer id;

    private String stunum;

    private String stuname;

    private String teanum;

    private String leavecontext;

    private Integer leavstate;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum == null ? null : stunum.trim();
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getTeanum() {
        return teanum;
    }

    public void setTeanum(String teanum) {
        this.teanum = teanum == null ? null : teanum.trim();
    }

    public String getLeavecontext() {
        return leavecontext;
    }

    public void setLeavecontext(String leavecontext) {
        this.leavecontext = leavecontext == null ? null : leavecontext.trim();
    }

    public Integer getLeavstate() {
        return leavstate;
    }

    public void setLeavstate(Integer leavstate) {
        this.leavstate = leavstate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}