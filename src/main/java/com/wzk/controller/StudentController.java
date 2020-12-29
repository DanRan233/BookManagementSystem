package com.wzk.controller;

import com.wzk.entity.Result;
import com.wzk.entity.Student;
import com.wzk.service.StudentServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 20:19
 */
@RequestMapping("/stu")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class StudentController {

    @Autowired
    StudentServiceIF studentServiceIF;

    /**
     * description: 登录接口，前端传入学号与密码
     * TODO:
     * @date         2020/12/25 21:46
     * @author      DanRan233
     * @Param       [student]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/login")
    public Result login(@RequestBody Student student, HttpSession session){
        System.out.println(student);
        return studentServiceIF.login(student,session);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 21:19
     * @author      DanRan233
     * @Param       [student]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addStu")
    public Result addStuInfo(@RequestBody Student student){
        System.out.println(student);
        return studentServiceIF.addStuInfo(student);
    }

    @RequestMapping("/getStudent")
    public  Result getStudent(@RequestBody Student student){
        System.out.println(student);
        return studentServiceIF.getStudent(student);
    }

    @RequestMapping("/getStudentList")
    public  Result getStudentList(@RequestBody Student student,@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "5") Integer pageSize){
        System.out.println(student);
        return  studentServiceIF.getStudentList(student,pageNum,pageSize);
    }

    @RequestMapping("/updateStudent")
    public Result updateStu(@RequestBody Student student){
        System.out.println(student);
        return studentServiceIF.updateStudent(student);
    }

    @RequestMapping("deleteStudent")
    public  Result delstu(@RequestBody Student student){
        System.out.println(student);
        return studentServiceIF.delStudent(student);
    }

}
