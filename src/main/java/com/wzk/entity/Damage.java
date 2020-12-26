package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 21:18
 */
public class Damage {
    String sID;//学生学号外键
    String bNumber;//书本编号外键
    String admID;//管理员编号外键
    int damStatus;//损坏记录状态

    public Damage() {
    }

    public Damage(String sID, String bNumber, String admID, int damStatus) {
        this.sID = sID;
        this.bNumber = bNumber;
        this.admID = admID;
        this.damStatus = damStatus;
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

    public int getDamStatus() {
        return damStatus;
    }

    public void setDamStatus(int damStatus) {
        this.damStatus = damStatus;
    }

    @Override
    public String toString() {
        return "Damage{" +
                "sID='" + sID + '\'' +
                ", bNumber='" + bNumber + '\'' +
                ", admID='" + admID + '\'' +
                ", damStatus=" + damStatus +
                '}';
    }
}
