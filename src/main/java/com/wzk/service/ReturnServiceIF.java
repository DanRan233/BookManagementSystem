package com.wzk.service;

import com.wzk.entity.Return;
import com.wzk.entity.Result;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 21:02
 */
public interface ReturnServiceIF {
    Result addReturn(Return r);

    Result updateReturn(Return r);

    Result getReturnList(Return r);
}
