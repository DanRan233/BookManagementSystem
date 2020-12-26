package com.wzk.dao;

import com.wzk.entity.Student;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 20:17
 */
public interface StudentDao {

    Student login(Student student);

    int addStuInfo(Student student);
}
