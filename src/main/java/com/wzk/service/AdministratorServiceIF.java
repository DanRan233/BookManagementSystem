package com.wzk.service;

import com.wzk.entity.Administrator;
import com.wzk.entity.Appointment;
import com.wzk.entity.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 17:13
 */

public interface AdministratorServiceIF {

    Result addAdm(Administrator administrator);


    Result login(Administrator administrator, HttpSession session);

    Result getAdmList(Administrator administrator,Integer pageNum,Integer pageSize);

    Result getAdm(Administrator administrator);

    Result updateAdm(Administrator administrator);

    Result delAdm(Administrator administrator);
}
