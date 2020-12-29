package com.wzk.controller;

import com.wzk.entity.Result;
import com.wzk.entity.Return;
import com.wzk.service.ReturnServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 21:11
 */
@RequestMapping("/return")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class ReturnController {
    @Autowired
    ReturnServiceIF returnServiceIF;

    @RequestMapping("/addReturn")
    public Result addReturn(@RequestBody Return r, HttpSession session){
        r.setsID(session.getAttribute("sID").toString());
        System.out.println(r);
        return returnServiceIF.addReturn(r);
    }
}
