package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 14:37
 */
public class Press {
    String prID;//出版社编号
    String prName;//出版社名称

    public Press() {
    }

    public Press(String prName) {
        this.prName = prName;
    }

    public Press(String prID, String prName) {
        this.prID = prID;
        this.prName = prName;
    }

    public String getPrID() {
        return prID;
    }

    public void setPrID(String prID) {
        this.prID = prID;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    @Override
    public String toString() {
        return "Press{" +
                "prID='" + prID + '\'' +
                ", prName='" + prName + '\'' +
                '}';
    }
}
