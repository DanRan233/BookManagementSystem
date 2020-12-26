package com.wzk.service;

import com.wzk.entity.Floor;
import com.wzk.entity.Press;
import com.wzk.entity.Result;
import com.wzk.entity.Press;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 14:47
 */
public interface PressServiceIF {
    Result addPress(Press press);

    Result getPress(Press press);

    Result getPressList(Press press, Integer pageNum, Integer pageSize);

    Result updatePress(Press press);

    Result deletePress(Press press);
}
