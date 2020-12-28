package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 17:23
 */
public class Book {
    int bID;//书本编号
    String bNumber;//书籍编号
    String bName;//书籍名称
    String author;//作者名称
    String pubDate;//出版日期
    int status;//状态
    String prID;//出版社ID
    String btID;//书本类型ID
    String brID;//书架ID

    public Book() {
    }

    public Book(int bID, String bNumber, String bName, String author, String pubDate, int status, String prID, String btID, String brID) {
        this.bID = bID;
        this.bNumber = bNumber;
        this.bName = bName;
        this.author = author;
        this.pubDate = pubDate;
        this.status = status;
        this.prID = prID;
        this.btID = btID;
        this.brID = brID;
    }

    public int getbID() {
        return bID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }

    public String getbNumber() {
        return bNumber;
    }

    public void setbNumber(String bNumber) {
        this.bNumber = bNumber;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPrID() {
        return prID;
    }

    public void setPrID(String prID) {
        this.prID = prID;
    }

    public String getBtID() {
        return btID;
    }

    public void setBtID(String btID) {
        this.btID = btID;
    }

    public String getBrID() {
        return brID;
    }

    public void setBrID(String brID) {
        this.brID = brID;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bID=" + bID +
                ", bNumber='" + bNumber + '\'' +
                ", bName='" + bName + '\'' +
                ", author='" + author + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", status=" + status +
                ", prID='" + prID + '\'' +
                ", btID='" + btID + '\'' +
                ", brID='" + brID + '\'' +
                '}';
    }
}
