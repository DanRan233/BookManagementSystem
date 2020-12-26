package com.wzk.service;

import com.wzk.entity.Power;
import com.wzk.entity.Result;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 16:39
 */
public interface PowerServiceIF {
    Result addPower(Power power);

    Result getPower(Power power);

    Result getPowerList(Power power, Integer pageNum, Integer pageSize);

    Result updatePower(Power power);

    Result deletePower(Power power);
}
