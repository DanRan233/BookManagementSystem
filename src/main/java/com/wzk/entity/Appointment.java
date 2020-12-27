package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 20:52
 */
public class Appointment {
    String sID;//学生学号外键
    int bID;//书本编号外键
    String appDate;//预约时间
    int appStatus;//预约记录状态

    public Appointment() {
    }

    public Appointment(String sID, int bID, String appDate, int appStatus) {
        this.sID = sID;
        this.bID = bID;
        this.appDate = appDate;
        this.appStatus = appStatus;
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

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public int getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(int appStatus) {
        this.appStatus = appStatus;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "sID='" + sID + '\'' +
                ", bID=" + bID +
                ", appDate='" + appDate + '\'' +
                ", appStatus=" + appStatus +
                '}';
    }
}
