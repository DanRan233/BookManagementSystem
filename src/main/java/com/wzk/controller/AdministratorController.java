package com.wzk.controller;

import com.wzk.entity.Administrator;
import com.wzk.entity.Result;
import com.wzk.entity.Student;
import com.wzk.service.AdministratorServiceIF;
import com.wzk.service.AppointmentServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 17:15
 */
@RequestMapping("/adm")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class AdministratorController {
    @Autowired
    AdministratorServiceIF administratorServiceIF;

    /**
     * description:
     * TODO:
     * @date         2020/12/29 15:51
     * @author      DanRan233
     * @Param       [administrator, session]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addAdm")
    public Result addAdm(@RequestBody Administrator administrator){
        System.out.println(administrator);
        return administratorServiceIF.addAdm(administrator);
    }

    @RequestMapping("/login")
    public Result login(@RequestBody Administrator administrator,HttpSession session){
        System.out.println(administrator);
        return administratorServiceIF.login(administrator,session);
    }

    @RequestMapping("/getAdm")
    public  Result getAdm(@RequestBody Administrator administrator){
        System.out.println(administrator);
        return administratorServiceIF.getAdm(administrator);
    }

    @RequestMapping("/getAdmList")
    public  Result getAdmList(@RequestBody Administrator administrator,@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "5") Integer pageSize,HttpSession session){
        System.out.println(administrator);
        return  administratorServiceIF.getAdmList(administrator,pageNum,pageSize);
    }

    @RequestMapping("/updateAdm")
    public Result updateStu(@RequestBody Administrator administrator){
        System.out.println(administrator);
        return administratorServiceIF.updateAdm(administrator);
    }

    @RequestMapping("deleteAdm")
    public  Result delstu(@RequestBody Administrator administrator){
        System.out.println(administrator);
        return administratorServiceIF.delAdm(administrator);
    }

}
