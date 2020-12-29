package com.wzk.service;

import com.wzk.entity.Lend;
import com.wzk.entity.Result;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 21:02
 */
public interface LendServiceIF {
    Result addLend(Lend lend);

    Result updateLend(Lend lend);

    Result getLendList(Lend lend,Integer pageNum,Integer pageSize);
}
