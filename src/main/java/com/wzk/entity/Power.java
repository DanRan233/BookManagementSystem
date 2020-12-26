package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: 权限实体类 TODO
 * @date 2020/12/26 16:28
 */
public class Power {
    String pID;//权限编号
    String pName;//权限名称

    public Power() {
    }

    public Power(String pName) {
        this.pName = pName;
    }

    public Power(String pID, String pName) {
        this.pID = pID;
        this.pName = pName;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Power{" +
                "pID='" + pID + '\'' +
                ", pName='" + pName + '\'' +
                '}';
    }
}
