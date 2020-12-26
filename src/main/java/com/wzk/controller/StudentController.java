package com.wzk.controller;

import com.wzk.entity.Result;
import com.wzk.entity.Student;
import com.wzk.service.StudentServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 20:19
 */
@RequestMapping("/stu")
@RestController
@Controller
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
    public Result login(@RequestBody Student student){
        System.out.println(student);
        return studentServiceIF.login(student);
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


}
