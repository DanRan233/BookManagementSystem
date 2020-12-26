package com.wzk.dao;

import com.wzk.entity.Power;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 16:30
 */
public interface PowerDao {
    int addPower(Power powerDao);

    Power getPower(Power powerDao);

    List<Power> getPowerList(Power powerDao);

    int updatePower(Power powerDao);

    int deletePower(Power powerDao);
}
