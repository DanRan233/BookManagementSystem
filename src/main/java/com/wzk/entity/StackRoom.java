package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: 书库实体类 TODO
 * @date 2020/12/26 11:45
 */
public class StackRoom {

    String srID;//书库编号
    String srName;//书库名称
    int srStatus;//书库状态：0禁用、1启用
    int fID;//楼层ID

    public StackRoom() {
    }

    public StackRoom(String srName) {
        this.srName = srName;
    }

    public StackRoom(String srID, String srName, int srStatus, int fID) {
        this.srID = srID;
        this.srName = srName;
        this.srStatus = srStatus;
        this.fID = fID;
    }

    public String getSrID() {
        return srID;
    }

    public void setSrID(String srID) {
        this.srID = srID;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName;
    }

    public int getSrStatus() {
        return srStatus;
    }

    public void setSrStatus(int srStatus) {
        this.srStatus = srStatus;
    }

    public int getfID() {
        return fID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    @Override
    public String toString() {
        return "StackRoom{" +
                "srID='" + srID + '\'' +
                ", srName='" + srName + '\'' +
                ", srStatus=" + srStatus +
                ", fID=" + fID +
                '}';
    }
}
