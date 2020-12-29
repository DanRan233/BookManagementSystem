package com.wzk.dao;

import com.wzk.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 20:17
 */
public interface StudentDao {

    /**
     * description: 查询student表是否存在用户输入的账号与密码
     * TODO:
     * @date         2020/12/27 9:41
     * @author      DanRan233
     * @Param       [student]
     * @return      com.wzk.entity.Student
     */
    Student login(Student student);

    /**
     * description: 添加学生信息
     * TODO:
     * @date         2020/12/27 9:45
     * @author      DanRan233
     * @Param       [student]
     * @return      int
     */
    int addStuInfo(Student student);

    Student getStudent(Student student);

    List<Student> getStudentList(Student student);

    int updateStudent(Student student);

    int delStudent(Student student);
}
