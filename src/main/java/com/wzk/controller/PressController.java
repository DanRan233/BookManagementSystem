package com.wzk.controller;

import com.wzk.entity.Result;
import com.wzk.entity.Press;
import com.wzk.service.PressServiceIF;
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
 * @date 2020/12/26 14:56
 */
@RequestMapping("/press")
@RestController
@Controller
public class PressController {
    @Autowired
    PressServiceIF pressServiceIF;

    @RequestMapping("/addPress")
    public Result addPress(@RequestBody Press press) {
        return pressServiceIF.addPress(press);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 14:59
     * @author      DanRan233
     * @Param       [press]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getPress")
    public Result getPress(@RequestBody Press press) {
        System.out.println(press);
        return pressServiceIF.getPress(press);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 14:58
     * @author      DanRan233
     * @Param       [srName, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getPressList")
    public Result getPressList(@RequestParam(defaultValue = "null") String prName, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        Press press = new Press(prName);
        return pressServiceIF.getPressList(press, pageNum, pageSize);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 14:58
     * @author      DanRan233
     * @Param       [press]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/updatePress")
    public Result updatePress(@RequestBody Press press) {
        return pressServiceIF.updatePress(press);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 14:58
     * @author      DanRan233
     * @Param       [press]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delPress")
    public Result delPress(@RequestBody Press press) {
        return pressServiceIF.deletePress(press);
    }
}
