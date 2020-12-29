package com.wzk.controller;

import com.wzk.entity.Lend;
import com.wzk.entity.Result;
import com.wzk.service.LendServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 21:10
 */
@RequestMapping("/lend")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class LendController {
    @Autowired
    LendServiceIF lendServiceIF;

    /**
     * description: 
     * TODO:
     * @date         2020/12/28 23:09
     * @author      DanRan233
     * @Param       [lend]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addLend")
    public Result addLend(@RequestBody Lend lend, HttpSession session){
        lend.setsID(session.getAttribute("sID").toString());
        System.out.println("***"+lend);
        return lendServiceIF.addLend(lend);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/29 15:27
     * @author      DanRan233
     * @Param       [lend, pageNum, pageSize, session]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getLendList")
    public Result getLendList(@RequestBody Lend lend,
                              @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize,
                              HttpSession session) {
        lend.setsID(session.getAttribute("sID").toString());
        System.out.println(lend);
        return lendServiceIF.getLendList(lend,pageNum,pageSize);
    }
}
