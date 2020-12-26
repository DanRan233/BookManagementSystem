package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: 管理员实体类 TODO
 * @date 2020/12/26 16:55
 */
public class Administrator {
    String admID;//管理员编号
    String admName;//管理员姓名
    String password;//管理员密码
    String tel;//手机
    String pID;//权限ID

    public Administrator() {
    }

    public String getAdmID() {
        return admID;
    }

    public void setAdmID(String admID) {
        this.admID = admID;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "admID='" + admID + '\'' +
                ", admName='" + admName + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", pID='" + pID + '\'' +
                '}';
    }
}
