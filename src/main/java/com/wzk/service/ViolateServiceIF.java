package com.wzk.service;

import com.wzk.entity.Violate;
import com.wzk.entity.Result;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 21:03
 */
public interface ViolateServiceIF {
    Result addViolate(Violate violate);

    Result updateViolate(Violate violate);

    Result getViolateList(Violate violate,Integer pageNum,Integer pageSize);
}
