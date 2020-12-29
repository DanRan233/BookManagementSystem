package com.wzk.dao;

import com.wzk.entity.Return;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 15:28
 */
public interface ReturnDao {
    int addReturn(Return r);

    int updateReturn(Return r);

    List<Return> getReturnList(Return r);
}
