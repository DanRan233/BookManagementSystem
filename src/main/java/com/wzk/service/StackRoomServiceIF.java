package com.wzk.service;

import com.wzk.entity.StackRoom;
import com.wzk.entity.Result;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 12:02
 */
public interface StackRoomServiceIF {
    Result addStackRoom(StackRoom stackRoom);

    Result getStackRoom(StackRoom stackRoom);

    Result getStackRoomList(StackRoom stackRoom, Integer pageNum, Integer pageSize);

    Result updateStackRoom(StackRoom stackRoom);

    Result deleteStackRoom(StackRoom stackRoom);
}
