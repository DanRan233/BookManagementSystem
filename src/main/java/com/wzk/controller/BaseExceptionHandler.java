package com.wzk.controller;

import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: 顶层异常捕获类，处理所有controller抛出或访问controller时未被处理的异常。
 * @date 2020/12/25 20:21
 */
@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * description: 顶层捕获所有异常
     * TODO:
     * @date         2020/12/25 21:30
     * @author      DanRan233
     * @Param       [e]
     * @return      com.wzk.entity.Result
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage(),e.getMessage());
    }
}
