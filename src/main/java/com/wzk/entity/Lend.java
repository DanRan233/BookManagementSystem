package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 20:55
 */
public class Lend {
    String sID;//学生学号外键
    String bNumber;//书本编号外键
    String lDate;//借书时间
    int lStatus;//借书记录状态

    public Lend() {
    }

    public Lend(String sID, String bNumber, String lDate, int lStatus) {
        this.sID = sID;
        this.bNumber = bNumber;
        this.lDate = lDate;
        this.lStatus = lStatus;
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
                ", bNumber='" + bNumber + '\'' +
                ", lDate='" + lDate + '\'' +
                ", lStatus=" + lStatus +
                '}';
    }
}
