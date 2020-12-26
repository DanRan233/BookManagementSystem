package com.wzk.dao;

import com.wzk.entity.Press;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 14:41s
 */
public interface PressDao {
    int addPress(Press press);

    Press getPress(Press press);

    List<Press> getPressList(Press press);

    int updatePress(Press press);

    int deletePress(Press press);
}
