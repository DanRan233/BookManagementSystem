package com.wzk.controller;

import com.wzk.entity.Department;
import com.wzk.entity.Result;
import com.wzk.service.DepartmentServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 16:13
 */
@RequestMapping("/department")
@RestController
@Controller
public class DepartmentController {
    @Autowired
    DepartmentServiceIF departmentServiceIF;

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:14
     * @author      DanRan233
     * @Param       [department]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addDepartment")
    public Result addDepartment(@RequestBody Department department) {
        return departmentServiceIF.addDepartment(department);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:14
     * @author      DanRan233
     * @Param       [department]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getDepartment")
    public Result getDepartment(@RequestBody Department department) {
        System.out.println(department);
        return departmentServiceIF.getDepartment(department);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:14
     * @author      DanRan233
     * @Param       [depName, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getDepartmentList")
    public Result getDepartmentList(@RequestParam(defaultValue = "null") String depName, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        Department department = new Department(depName);
        return departmentServiceIF.getDepartmentList(department, pageNum, pageSize);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:14
     * @author      DanRan233
     * @Param       [department]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/updateDepartment")
    public Result updateDepartment(@RequestBody Department department) {
        return departmentServiceIF.updateDepartment(department);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:39
     * @author      DanRan233
     * @Param       [department]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delDepartment")
    public Result delDepartment(@RequestBody Department department) {
        return departmentServiceIF.deleteDepartment(department);
    }
}
