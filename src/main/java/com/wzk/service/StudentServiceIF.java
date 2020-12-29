package com.wzk.service;

import com.wzk.entity.Result;
import com.wzk.entity.Student;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 20:18
 */
public interface StudentServiceIF {

    Result login(Student student, HttpSession session);

    Result addStuInfo(Student student);

    Result getStudent(Student student);

    Result getStudentList(Student student,Integer pageNum,Integer pageSize);

    Result updateStudent(Student student);

    Result delStudent(Student student);
}
