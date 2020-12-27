package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 20:55
 */
public class Lend {
    String sID;//学生学号外键
    int bID;//书本编号外键
    String lDate;//借书时间
    int lStatus;//借书记录状态

    public Lend() {
    }

    public Lend(String sID, int bID, String lDate, int lStatus) {
        this.sID = sID;
        this.bID = bID;
        this.lDate = lDate;
        this.lStatus = lStatus;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public int getbID() {
        return bID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }

    public String getlDate() {
        return lDate;
    }

    public void setlDate(String lDate) {
        this.lDate = lDate;
    }

    public int getlStatus() {
        return lStatus;
    }

    public void setlStatus(int lStatus) {
        this.lStatus = lStatus;
    }

    @Override
    public String toString() {
        return "Lend{" +
                "sID='" + sID + '\'' +
                ", bID=" + bID +
                ", lDate='" + lDate + '\'' +
                ", lStatus=" + lStatus +
                '}';
    }
}
