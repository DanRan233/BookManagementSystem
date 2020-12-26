package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 23:18
 */
public class Floor {
    int fID;//楼层
    String fName;//楼层名称
    int fStatus;//楼层状态

    public Floor(int fID, String fName, int fStatus) {
        this.fID = fID;
        this.fName = fName;
        this.fStatus = fStatus;
    }

    public Floor(String fName) {
        this.fName = fName;
    }

    public Floor() {
    }

    public int getfID() {
        return fID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getfStatus() {
        return fStatus;
    }

    public void setfStatus(int fStatus) {
        this.fStatus = fStatus;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "fID=" + fID +
                ", fName='" + fName + '\'' +
                ", fStatus=" + fStatus +
                '}';
    }
}
