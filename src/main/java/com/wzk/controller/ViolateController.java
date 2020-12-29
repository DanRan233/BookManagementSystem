package com.wzk.controller;

import com.wzk.entity.Result;
import com.wzk.entity.Violate;
import com.wzk.service.ViolateServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 21:11
 */
@RequestMapping("/vio")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class ViolateController {
    @Autowired
    ViolateServiceIF violateServiceIF;

    @RequestMapping("getViolateList")
    public Result getViolateList(@RequestBody Violate violate,@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "5") Integer pageSize){
        System.out.println(violate);
        return violateServiceIF.getViolateList(violate,pageNum,pageSize);
    }

    @RequestMapping("updateViolate")
    public Result updateVio(@RequestBody Violate violate, HttpSession session){
        violate.setAdmID(session.getAttribute("admID").toString());
        System.out.println(violate);
        return violateServiceIF.updateViolate(violate);
    }
}
