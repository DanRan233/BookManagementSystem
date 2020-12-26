package com.wzk.dao;

import com.wzk.entity.Floor;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 23:22
 */
public interface FloorDao {

    int addFloor(Floor floor);

    Floor getFloor(Floor floor);

    List<Floor> getFloorList(Floor floor);

    int updateFloor(Floor floor);

    int deleteFloor(Floor floor);
}
