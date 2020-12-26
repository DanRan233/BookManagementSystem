package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: 封装返回值枚举类 TODO
 * @date 2020/12/26 9:38
 */
public enum ResultEnum {
    UNEXECUTED(2000,"未执行！"),
    ERROR(2000,"操作异常"),
    NOT_FOUND(2000,"未找到信息，请检查输入是否正确"),
    CASCADE_ERROR(2000,"操作失败,请检查删除项是否被引用"),
    SUCCESS(2001,"操作成功！"),
    LOGIN_SUCCESS(2001,"登录成功！"),
    LOGIN_FAILED(2000,"用户名或密码错误！")
    ;

    private  int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
