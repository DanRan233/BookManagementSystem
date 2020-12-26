package com.wzk.service;

import com.wzk.entity.Result;
import com.wzk.entity.Student;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 20:18
 */
public interface StudentServiceIF {

    Result login(Student student);

    Result addStuInfo(Student student);
}
