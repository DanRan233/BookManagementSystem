package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 21:00
 */
public class Violate {
    String sID;//学生学号外键
    int bID;//书本编号外键
    String admID;//管理员编号外键
    int vStatus;//违约记录状态

    public Violate() {
    }

    public Violate(String sID, int bID, String admID, int vStatus) {
        this.sID = sID;
        this.bID = bID;
        this.admID = admID;
        this.vStatus = vStatus;
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

    public String getAdmID() {
        return admID;
    }

    public void setAdmID(String admID) {
        this.admID = admID;
    }

    public int getvStatus() {
        return vStatus;
    }

    public void setvStatus(int vStatus) {
        this.vStatus = vStatus;
    }

    @Override
    public String toString() {
        return "Violate{" +
                "sID='" + sID + '\'' +
                ", bID=" + bID +
                ", admID='" + admID + '\'' +
                ", vStatus=" + vStatus +
                '}';
    }
}
