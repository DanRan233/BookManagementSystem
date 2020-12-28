package com.wzk.controller;

import com.wzk.entity.Power;
import com.wzk.entity.Result;
import com.wzk.service.PowerServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 16:41
 */
@RequestMapping("/power")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class PowerController {
    @Autowired
    PowerServiceIF powerServiceIF;

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:14
     * @author      DanRan233
     * @Param       [power]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addPower")
    public Result addPower(@RequestBody Power power) {
        return powerServiceIF.addPower(power);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:14
     * @author      DanRan233
     * @Param       [power]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getPower")
    public Result getPower(@RequestBody Power power) {
        System.out.println(power);
        return powerServiceIF.getPower(power);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:14
     * @author      DanRan233
     * @Param       [depName, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getPowerList")
    public Result getPowerList(@RequestParam(defaultValue = "null") String pName, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        Power power = new Power(pName);
        return powerServiceIF.getPowerList(power, pageNum, pageSize);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:14
     * @author      DanRan233
     * @Param       [power]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/updatePower")
    public Result updatePower(@RequestBody Power power) {
        return powerServiceIF.updatePower(power);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:39
     * @author      DanRan233
     * @Param       [power]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delPower")
    public Result delPower(@RequestBody Power power) {
        return powerServiceIF.deletePower(power);
    }
}