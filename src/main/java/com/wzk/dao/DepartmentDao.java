package com.wzk.dao;

import com.wzk.entity.Department;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 16:08
 */
public interface DepartmentDao {
    int addDepartment(Department department);

    Department getDepartment(Department department);

    List<Department> getDepartmentList(Department department);

    int updateDepartment(Department department);

    int deleteDepartment(Department department);
}
