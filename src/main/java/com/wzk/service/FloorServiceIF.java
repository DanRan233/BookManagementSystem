package com.wzk.service;

import com.wzk.entity.Floor;
import com.wzk.entity.Result;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 23:37
 */
public interface FloorServiceIF {
    Result addFloor(Floor floor);

    Result getFloor(Floor floor);

    Result getFloorList(Floor floor,Integer pageNum,Integer pageSize);

    Result updateFloor(Floor floor);

    Result deleteFloor(Floor floor);
}
