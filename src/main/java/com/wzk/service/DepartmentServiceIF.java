package com.wzk.service;

import com.wzk.entity.Department;
import com.wzk.entity.Result;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 16:10
 */
public interface DepartmentServiceIF {
    Result addDepartment(Department department);

    Result getDepartment(Department department);

    Result getDepartmentList(Department department, Integer pageNum, Integer pageSize);

    Result updateDepartment(Department department);

    Result deleteDepartment(Department department);
}
