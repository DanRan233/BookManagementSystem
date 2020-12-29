package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 13:53
 */
public class BookRack {
    String brID;//书架ID
    String brName;//书架名称
    String srID;//书库ID
    int brStatus;//书架状态：1可用，2禁用

    public BookRack(String brID, String brName, String srID, int brStatus) {
        this.brID = brID;
        this.brName = brName;
        this.srID = srID;
        this.brStatus = brStatus;
    }

    public BookRack(String brName) {
        this.brName = brName;
    }

    public BookRack() {
    }


    public String getBrID() {
        return brID;
    }

    public void setBrID(String brID) {
        this.brID = brID;
    }

    public String getBrName() {
        return brName;
    }

    public void setBrName(String brName) {
        this.brName = brName;
    }

    public String getSrID() {
        return srID;
    }

    public void setSrID(String srID) {
        this.srID = srID;
    }

    public int getBrStatus() {
        return brStatus;
    }

    public void setBrStatus(int brStatus) {
        this.brStatus = brStatus;
    }

    @Override
    public String toString() {
        return "Bookrack{" +
                "brID='" + brID + '\'' +
                ", brName='" + brName + '\'' +
                ", srID='" + srID + '\'' +
                ", brStatus=" + brStatus +
                '}';
    }
}
