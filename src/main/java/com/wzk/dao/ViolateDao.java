package com.wzk.dao;

import com.wzk.entity.Violate;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 15:28
 */
public interface ViolateDao {
    int addViolate(Violate violate);

    int updateViolate(Violate violate);

    Integer getViolate(Violate violate);

    List<Violate> getViolateList(Violate violate);
}
