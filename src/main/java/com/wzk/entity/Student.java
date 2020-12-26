package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: 学生信息实体类，与数据库student表对应 TODO
 * @date 2020/12/25 21:11
 */
public class Student {
    String sID;//学号
    String sName;//姓名
    String password;//登陆密码
    int status;//学生状态：1可以借书0禁止借书
    String depID;//院系编号

    public Student() {
    }

    public Student(String sID, String sName, String password, int status, String depID) {
        this.sID = sID;
        this.sName = sName;
        this.password = password;
        this.status = status;
        this.depID = depID;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sID='" + sID + '\'' +
                ", sName='" + sName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", depID='" + depID + '\'' +
                '}';
    }
}
