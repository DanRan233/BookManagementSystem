package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 15:27
 */
public class BookType {
    String btID;//书本类型编号
    String btName;//书本类型

    public BookType() {
    }

    public BookType(String btName) {
        this.btName = btName;
    }

    public BookType(String btID, String btName) {
        this.btID = btID;
        this.btName = btName;
    }

    public String getBtID() {
        return btID;
    }

    public void setBtID(String btID) {
        this.btID = btID;
    }

    public String getBtName() {
        return btName;
    }

    public void setBtName(String btName) {
        this.btName = btName;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "btID='" + btID + '\'' +
                ", btName='" + btName + '\'' +
                '}';
    }
}
