package com.wzk.dao;

import com.wzk.entity.Lend;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 15:27
 */
public interface LendDao {
    int addLend(Lend lend);

    int updateLend(Lend lend);

    Lend getLend(Lend lend);

    List<Lend> getLendList(Lend lend);
}
