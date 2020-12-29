package com.wzk.dao;

import com.wzk.entity.StackRoom;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 11:45
 */
public interface StackRoomDao {
    int addStackRoom(StackRoom stackRoom);

    StackRoom getStackRoom(StackRoom stackRoom);

    List<StackRoom> getStackRoomList(StackRoom stackRoom);

    int updateSrStatus(StackRoom stackRoom);

    int updateStackRoom(StackRoom stackRoom);

    int deleteStackRoom(StackRoom stackRoom);
}
