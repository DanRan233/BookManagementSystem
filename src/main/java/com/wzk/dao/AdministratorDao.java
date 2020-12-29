package com.wzk.dao;

import com.wzk.entity.Administrator;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 17:00
 */
public interface AdministratorDao {

    int addAdm(Administrator administrator);

    Administrator login(Administrator administrator);

    List<Administrator> getAdmList(Administrator administrator);

    Administrator getAdm(Administrator administrator);

    int updateAdm(Administrator administrator);

    int delAdm(Administrator administrator);

}
