package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 20:56
 */
public class Return {
    String sID;//学生学号外键
    String bNumber;//书本编号外键
    String admID;//管理员编号外键
    String rDate;//归还时间
    int rStatus;//归还记录状态

    public Return() {
    }

    public Return(String sID, String bNumber, String admID, String rDate, int rStatus) {
        this.sID = sID;
        this.bNumber = bNumber;
        this.admID = admID;
        this.rDate = rDate;
        this.rStatus = rStatus;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getbNumber() {
        return bNumber;
    }

    public void setbNumber(String bNumber) {
        this.bNumber = bNumber;
    }

    public String getAdmID() {
        return admID;
    }

    public void setAdmID(String admID) {
        this.admID = admID;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public int getrStatus() {
        return rStatus;
    }

    public void setrStatus(int rStatus) {
        this.rStatus = rStatus;
    }

    @Override
    public String toString() {
        return "Return{" +
                "sID='" + sID + '\'' +
                ", bNumber='" + bNumber + '\'' +
                ", admID='" + admID + '\'' +
                ", rDate='" + rDate + '\'' +
                ", rStatus=" + rStatus +
                '}';
    }
}
