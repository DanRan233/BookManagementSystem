package com.wzk.entity;


import java.io.Serializable;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: 返回体封装类 ，该类为接口返回数据封装类，使用泛型以便于封装各种数据类型
 * @date 2020/12/25 20:13
 */
public class Result<T> implements Serializable {
    private Integer code; // 消息码
    private String message; // 报文
    private T data; // 返回数据
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
